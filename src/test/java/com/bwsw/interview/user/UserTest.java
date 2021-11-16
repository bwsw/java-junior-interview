package com.bwsw.interview.user;

import org.apache.commons.io.IOUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.testng.Assert.*;

public class UserTest {

    public final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.0-alpine")
            .withDatabaseName("user_task")
            .withUsername("user")
            .withPassword("password")
            .withInitScript("user_dump.sql");

    @BeforeClass
    public void beforeClass() {
        postgreSQLContainer.start();
    }

    @AfterClass
    public void afterClass() {
        if (postgreSQLContainer.isRunning()) {
            postgreSQLContainer.stop();
        }
    }

    @Test
    public void testSelect() {
        try (Connection connection = DriverManager.getConnection(postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword());
                Statement statement = connection.createStatement()) {
            ResultSet resultSet =
                    statement.executeQuery(IOUtils.resourceToString("user_select.sql", StandardCharsets.UTF_8, getClass().getClassLoader()));
            assertTrue(resultSet.next());
            assertEquals(resultSet.getInt(1), 2);
            assertFalse(resultSet.next());
        } catch (Exception e) {
            fail(e.getClass().getSimpleName(), e);
        }
    }
}
