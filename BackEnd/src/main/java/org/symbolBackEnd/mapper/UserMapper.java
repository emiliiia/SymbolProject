package org.symbolBackEnd.mapper;
/*
  @author emilia
  @project SymbolProject
  @class UserMapper
  @version 1.0.0
  @since 05.09.2023 - 20:48
*/

import org.springframework.stereotype.Component;
import org.symbolBackEnd.dto.user.FullUserDTO;
import org.symbolBackEnd.dto.user.UserDTO;
import org.symbolBackEnd.entity.User;

@Component
public class UserMapper {

    public UserMapper() {
    }

    public UserDTO toUserDto(User entity) {
        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());

        return dto;
    }

    public FullUserDTO toFullUserDto(User entity) {
        FullUserDTO dto = new FullUserDTO();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole().getRole());
        return dto;
    }

}
