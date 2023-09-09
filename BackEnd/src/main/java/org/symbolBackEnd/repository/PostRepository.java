package org.symbolBackEnd.repository;
/*
  @author emilia
  @project SymbolProject
  @class PostRepository
  @version 1.0.0
  @since 05.09.2023 - 20:32
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symbolBackEnd.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {
}
