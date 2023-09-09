package org.symbolBackEnd.service.user;
/*
  @author emilia
  @project SymbolProject
  @class UserService
  @version 1.0.0
  @since 05.09.2023 - 20:45
*/

import org.symbolBackEnd.dto.user.FullUserDTO;
import org.symbolBackEnd.dto.user.UserDTO;
import org.symbolBackEnd.entity.User;

import java.util.List;

public interface IUserService {
    FullUserDTO getFullUserById(Integer id);
    User getEntityById(Integer id);
    void delete(Integer id);
    List<UserDTO> getAll();
}
