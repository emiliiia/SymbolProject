package org.symbolBackEnd.config;
/*
  @author emilia
  @project SymbolProject
  @class JpaConfig
  @version 1.0.0
  @since 05.09.2023 - 20:20
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
