package org.symbolBackEnd.repository;
/*
  @author emilia
  @project SymbolProject
  @class RoleRepository
  @version 1.0.0
  @since 05.09.2023 - 20:36
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symbolBackEnd.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {}
