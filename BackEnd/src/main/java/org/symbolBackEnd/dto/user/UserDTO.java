package org.symbolBackEnd.dto.user;
/*
  @author emilia
  @project SymbolProject
  @class UserDTO
  @version 1.0.0
  @since 05.09.2023 - 20:41
*/

public class UserDTO {
    private Integer id;
    private String username;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
