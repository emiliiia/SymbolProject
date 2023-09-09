package org.symbolBackEnd.repository;
/*
  @author emilia
  @project SymbolProject
  @class UserRepository
  @version 1.0.0
  @since 05.09.2023 - 20:34
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symbolBackEnd.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    boolean existsById(Integer id);
}
