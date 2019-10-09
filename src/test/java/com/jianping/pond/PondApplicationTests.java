package com.jianping.pond;

import com.jianping.pond.exception.SysException;
import com.jianping.pond.util.RedisUtil;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PondApplicationTests {
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        try {
            String s = redisUtil.getString("name");
            String s1 = redisUtil.getString("name1");
            System.out.println(s+s1);
        } catch (SysException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://192.144.217.74:3306/pond", "root", "xu111538");
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `user`");
//            ResultSet resultSet = statement.executeQuery();
//            System.out.println(resultSet.getRow());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}