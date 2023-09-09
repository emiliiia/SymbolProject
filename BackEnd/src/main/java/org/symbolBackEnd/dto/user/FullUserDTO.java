package org.symbolBackEnd.dto.user;
/*
  @author emilia
  @project SymbolProject
  @class FullUserDTO
  @version 1.0.0
  @since 05.09.2023 - 20:42
*/

import org.symbolBackEnd.enums.RoleType;

public class FullUserDTO {
    private Integer id;
    private String username;
    private String email;
    private RoleType role;

    public FullUserDTO() {
    }

    public FullUserDTO(Integer id, String username, String email, RoleType role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "FullUserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
