package br.com.monktec;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

public class DataBaseLifeCycle implements QuarkusTestResourceLifecycleManager {

    private static PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer("postgres:12.2");

    @Override
    public Map<String, String> start() {
        POSTGRES.start();

        Map<String,String> propriedades = new HashMap<>();

        propriedades.put("quarkus.datasource.jdbc.url", POSTGRES.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", POSTGRES.getUsername());
        propriedades.put("quarkus.datasource.password", POSTGRES.getPassword());

        return propriedades;
    }

    @Override
    public void stop() {
        if (POSTGRES != null) {
            POSTGRES.stop();
        }
    }
}
