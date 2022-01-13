package com.gdm.unitbv.bdd.library.config.database;


import java.util.HashMap;
import java.util.Map;

public class GenericConfig {

    public static Map<String, Object> getProperties(String URL){

        Map<String, Object> properties = new HashMap<>();

        properties.put("javax.persistence.jdbc.url", URL);
        properties.put("javax.persistence.jdbc.driver",
                "org.postgresql.Driver");
        properties.put("javax.persistence.jdbc.user",
                "postgres");
        properties.put("javax.persistence.jdbc.password",
                "18062000gdm");
        properties.put("hibernate.hbm2ddl.auto",
                "update");
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");

        properties.put("javax.persistence.schema-generation.database.action",
                "drop-and-create");

        return properties;
    }
}
