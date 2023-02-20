package com.example.javafxapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler extends Configs {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection dbConnection;
        String connectionName = "jbdc:mysql://" + bdHost + ":" + bdPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionName, bdUser, dbPass);
        return dbConnection;
    }

    public Connection signUpUser(User user) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO " +
                Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," +
                Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," +
                Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," +
                Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, user.getFirstName());
        pstmt.setString(1, user.getLastName());
        pstmt.setString(1, user.getUserName());
        pstmt.setString(1, user.getPassword());
        pstmt.setString(1, user.getLocation());
        pstmt.setString(1, user.getGender());
        pstmt.execute();
        return signUpUser(user);
    }
}
