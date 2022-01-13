package com.gdm.unitbv.bdd.library.config.database;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.domain.util.Genre;
import com.gdm.unitbv.bdd.library.service.RealistBooksService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRefBDDRealistBooks",
        basePackages = "com.gdm.unitbv.bdd.library.repository.realist",
        transactionManagerRef = "transactionManagerBDDRealistBooks"
)
public class BDDRealistBooks {

    @Bean(name = "dataSourceBDDRealistBooks")
    public DataSource dataSource(){

        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/bdd-realist-books" +
                "?createDatabaseIfNotExist=true");
    }

    @Bean(name = "entityManagerFactoryRefBDDRealistBooks")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanFantasy(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("dataSourceBDDRealistBooks") DataSource dataSourceFantasyBooks){

        return entityManagerFactoryBuilder.dataSource(dataSourceFantasyBooks)
                .properties(GenericConfig.getProperties())
                .packages("com.gdm.unitbv.bdd.library.domain.entity")
                .persistenceUnit("bdd-realist-books")
                .build();
    }

    @Bean(name = "transactionManagerBDDRealistBooks")
    public PlatformTransactionManager platformTransactionManagerFantasy(
            @Qualifier("entityManagerFactoryRefBDDRealistBooks") EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    CommandLineRunner commandLineRunnerRealist(RealistBooksService realistBooksService){
        return args -> {
            for (int i = 10; i < 20; i++) {
                realistBooksService.saveOrUpdate(new Book("bookRealist" + i,
                        Genre.REALIST,
                        "author" + i));
            }
        };
    }
}
