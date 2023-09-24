package org.symbolBackEnd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
  @author emilia
  @project SymbolProject
  @class JsonUtil
  @version 1.0.0
  @since 09.09.2023 - 14:50
*/

public class JsonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}