package com.project.Database;

import java.sql.*;

public class BankDatabase {

    public boolean LogIn(Long no, int pin) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/user_schema";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "SELECT * FROM user_table WHERE Cardno =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(no));
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("Cardno").equals(no.toString()) && rs.getString("pin").equals((Integer.toString(pin)));
            } else {
                return false;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean SignUp(Long no, int pin) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/user_schema";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sql2 = "INSERT INTO user_table(Cardno,pin)" + " VALUES (?,?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, String.valueOf(no));
            statement2.setString(2, String.valueOf(pin));
            statement2.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public long getMoney(Long no) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/user_schema";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "SELECT * FROM user_table WHERE Cardno =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(no));
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getLong("money");
            } else {
                return 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean Withdraw(Long no,Long money1) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/user_schema";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "UPDATE user_table SET money=money +"+money1+" WHERE Cardno="+no;
            Statement statement = connection.createStatement();
            int rows =  statement.executeUpdate(sql);
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}