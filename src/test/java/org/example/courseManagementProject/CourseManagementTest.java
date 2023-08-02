package org.example.courseManagementProject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CourseManagementTest.class)
@Slf4j
@RunWith(SpringRunner.class)
class CourseManagementTest {

    @Test
    void contextLoads(){
    }

    @Test
    void databaseConnectionTest(){
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/courseManagementSystem",
                "postgres","momentum");
        try{
            Connection connection = dataSource.getConnection();
            log.info("connected to Db");
            assertNotNull(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}