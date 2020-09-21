package com.wp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHlper {
    private static String DRIVER="com.mysql.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/userinfo";
    private static String USERNAME="root";
    private static String PASSWORD="123456";
    public static Connection getConn(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        close(conn,ps);
    }

    public static void close(Connection conn, PreparedStatement ps) {
        try {
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConn());
    }


}
