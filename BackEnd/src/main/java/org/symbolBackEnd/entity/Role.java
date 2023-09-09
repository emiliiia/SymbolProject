package org.symbolBackEnd.entity;
/*
  @author emilia
  @project SymbolProject
  @class Role
  @version 1.0.0
  @since 05.09.2023 - 20:24
*/

import org.symbolBackEnd.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name="role", schema="public")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public Role() {
    }

    public Role(Integer id, RoleType role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}

