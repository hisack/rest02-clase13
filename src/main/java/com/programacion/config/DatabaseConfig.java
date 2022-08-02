package com.programacion.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;

@ApplicationScoped
public class DatabaseConfig {

    @Produces
    @ApplicationScoped
    public DataSource dataSource(){

        HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://tyke.db.elephantsql.com/hazmombe");
        ds.setUsername("hazmombe");
        ds.setPassword("xYCuf06MWgFjaSF2PtM_-Sgdu2BsH5Rv");

        ds.setMinimumIdle(1);
        ds.setMaximumPoolSize(5);

        return ds;

    }
}
