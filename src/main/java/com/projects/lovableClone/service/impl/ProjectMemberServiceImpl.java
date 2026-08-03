package com.projects.lovableClone.service.impl;

import com.projects.lovableClone.dto.member.InviteMemberRequest;
import com.projects.lovableClone.dto.member.MemberResponse;
import com.projects.lovableClone.dto.member.UpdateMemberRoleRequest;
import com.projects.lovableClone.entity.Project;
import com.projects.lovableClone.entity.ProjectMember;
import com.projects.lovableClone.entity.ProjectMemberId;
import com.projects.lovableClone.entity.User;
import com.projects.lovableClone.mapper.ProjectMemberMapper;
import com.projects.lovableClone.repository.ProjectMemberRepository;
import com.projects.lovableClone.repository.ProjectRepository;
import com.projects.lovableClone.repository.UserRepository;
import com.projects.lovableClone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;


    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner())); //convert user to memberResponse using mapStruct. Only owner added

        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList()
        ); //--added all members

        return memberResponseList;
    }

    //TODO: We can create an api to check when the user is accepting our invite, that feature needs to be updated ---- respond to invite by user
    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
