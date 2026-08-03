package com.projects.lovableClone.controller;

import com.projects.lovableClone.dto.member.InviteMemberRequest;
import com.projects.lovableClone.dto.member.MemberResponse;
import com.projects.lovableClone.dto.member.UpdateMemberRoleRequest;
import com.projects.lovableClone.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // if we use this we don't need to create constructor, also we are using constructor dependency injection
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    //Inviting a member
    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody InviteMemberRequest request){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId, request, userId)
        );
    }

    //Update member role
    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRoleRequest request
    ){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, request, userId));
    }

    //Remove a member
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    ){
        Long userId = 1L;
        projectMemberService.removeProjectMember(projectId, memberId, userId);
        return ResponseEntity.noContent().build();
    }
}
