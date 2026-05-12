package com.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @Value("${spring.datasource.username:root}")
    private String userDB;

    @Test
    void databaseUserCheck(){

        String user = "root";

        boolean isEqual = user.equals(userDB);

        assertTrue(isEqual, "True");
    }

}
