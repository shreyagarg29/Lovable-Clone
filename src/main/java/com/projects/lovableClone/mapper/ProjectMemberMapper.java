package com.projects.lovableClone.mapper;

import com.projects.lovableClone.dto.member.MemberResponse;
import com.projects.lovableClone.entity.ProjectMember;
import com.projects.lovableClone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "role", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id") // user.id is a way of doing nested mapping where projectMember has a field called user, and in user table id is present. So . notation is used
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "avatarUrl", source = "user.avatarUrl")
    @Mapping(target = "role", source = "projectRole")
    @Mapping(target = "invitedAt", source = "invitedAt")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
