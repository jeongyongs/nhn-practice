package com.nhnacademy.aiot;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sloth", "sloth", "sloth");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("password"));
            }

            connection.close(); // auto closeable

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
