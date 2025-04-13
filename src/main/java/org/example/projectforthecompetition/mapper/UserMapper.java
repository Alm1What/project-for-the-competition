package org.example.projectforthecompetition.mapper;

import org.example.projectforthecompetition.dto.ForRegister.UserDto;
import org.example.projectforthecompetition.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "restorationAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(User user);

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "restorationAt", ignore = true)
    User toUser(UserDto userDto);
}
