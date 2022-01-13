package com.gdm.unitbv.bdd.library.config.database;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.domain.util.Genre;
import com.gdm.unitbv.bdd.library.service.FantasyBooksService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "entityManagerFactoryRefBDDFantasyBooks",
        basePackages = "com.gdm.unitbv.bdd.library.repository.fantasy",
        transactionManagerRef = "transactionManagerBDDFantasyBooks"
)
public class BDDFantasyBooks {

    @Primary
    @Bean(name = "dataSourceBDDFantasyBooks")
    public DataSource dataSource(){

        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/bdd-fantasy-books" +
                "?createDatabaseIfNotExist=true");
    }

    @Primary
    @Bean(name = "entityManagerFactoryRefBDDFantasyBooks")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanFantasy(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("dataSourceBDDFantasyBooks") DataSource dataSourceFantasyBooks){

        return entityManagerFactoryBuilder.dataSource(dataSourceFantasyBooks)
                .properties(GenericConfig.getProperties())
                .packages("com.gdm.unitbv.bdd.library.domain.entity")
                .persistenceUnit("bdd-fantasy-books")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerBDDFantasyBooks")
    public PlatformTransactionManager platformTransactionManagerFantasy(
            @Qualifier("entityManagerFactoryRefBDDFantasyBooks") EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean
    CommandLineRunner commandLineRunnerFantasy(FantasyBooksService fantasyBooksService){
        return args -> {
            for (int i = 10; i < 20; i++) {
                fantasyBooksService.saveOrUpdate(new Book("bookFantasy" + i,
                        Genre.FANTASY,
                        "author" + i));
            }
        };
    }
}
