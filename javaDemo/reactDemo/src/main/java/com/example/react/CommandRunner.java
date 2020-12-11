package com.example.react;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;


@Component
public class CommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ConnectionFactory connectionFactory = null;
        DatabaseClient client = DatabaseClient.create(connectionFactory);
        client.sql("select * from performance").then()
    }
}
