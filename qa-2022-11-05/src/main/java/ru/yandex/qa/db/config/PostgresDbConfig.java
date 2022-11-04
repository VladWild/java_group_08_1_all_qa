package ru.yandex.qa.db.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
        entityManagerFactoryRef = "entityManagerFactoryRefPostgres",
        transactionManagerRef = "transactionManagerRefPostgres",
        basePackages = {"ru.yandex.qa.db.repositories"}
)
public class PostgresDbConfig {

    @Bean(name = "dataSourcePostgres")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryRefPostgres")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSourcePostgres") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("ru.yandex.qa.db.model")
                //.persistenceUnit("postgres")
                .build();
    }

    @Bean(name = "transactionManagerRefPostgres")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryRefPostgres")
                                                         EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
