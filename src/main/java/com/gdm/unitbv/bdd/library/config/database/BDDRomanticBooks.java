package com.gdm.unitbv.bdd.library.config.database;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.service.RomanticBooksService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRefBDDRomanticBooks",
        basePackages = "com.gdm.unitbv.bdd.library.repository",
        transactionManagerRef = "transactionManagerBDDRomanticBooks"
)
public class BDDRomanticBooks {


    @Bean(name = "dataSourceBDDRomanticBooks")
    public DataSource dataSourceFantasyBooks(){return DataSourceBuilder.create().build();}

    @Bean(name = "entityManagerFactoryRefBDDRomanticBooks")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanFantasy(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("dataSourceBDDRomanticBooks") DataSource dataSourceFantasyBooks){

        Map<String, Object> properties = GenericConfig.getProperties(
                "jdbc:postgresql://127.0.0.1:5432/bdd-romantic-books?createDatabaseIfNotExist=true");

        return entityManagerFactoryBuilder.dataSource(dataSourceFantasyBooks)
                .properties(properties)
                .packages("com.gdm.unitbv.bdd.library.domain.entity")
                .persistenceUnit("bdd-romantic-books")
                .build();
    }

    @Bean(name = "transactionManagerBDDRomanticBooks")
    public PlatformTransactionManager platformTransactionManagerFantasy(
            @Qualifier("entityManagerFactoryRefBDDRomanticBooks") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    CommandLineRunner commandLineRunnerRealist(RomanticBooksService romanticBooksService){
        return args -> {
            for (int i = 10; i < 20; i++) {
                romanticBooksService.saveOrUpdate(new Book("romantic-config" + i,
                        "romantic",
                        "author" + i));
            }
        };
    }
}
