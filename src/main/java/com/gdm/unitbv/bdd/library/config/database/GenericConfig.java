package com.gdm.unitbv.bdd.library.config.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class GenericConfig {

    public static DataSource getDataSource(String url){

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        }catch (Exception exception){
            exception.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser("—PUT YOUR CREDENTIALS HERE—");
        dataSource.setPassword("—PUT YOUR CREDENTIALS HERE—");

        return dataSource;
    }

    public static Map<String, Object> getProperties(){

        Map<String, Object> properties = new HashMap<>();

        properties.put("javax.persistence.schema-generation.database.action",
                "drop-and-create");

        properties.put("hibernate.hbm2ddl.auto",
                "update");
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.current_session_context_class",
                "org.springframework.orm.hibernate5.SpringSessionContext");

        properties.put("connection.provider_class","org.hibernate.connection.C3P0ConnectionProvider");
        properties.put("hibernate.c3p0.min_size","10");
        properties.put("hibernate.c3p0.max_size",50);
        properties.put("hibernate.c3p0.acquire_increment","5");
        properties.put("hibernate.c3p0.idle_test_period","600");
        properties.put("hibernate.c3p0.timeout","5000");

        return properties;
    }
}
