package com.epam.spring.hometask.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;

public class JsonParser {

    public static final <T> List<T> convertJsonToList(final byte[] jsonEntities, Class<T> entityClass)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.readValue(jsonEntities,
                objectMapper.getTypeFactory().constructCollectionType(List.class, entityClass));

    }


}
