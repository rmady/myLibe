package br.mylibe.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection con = null;

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String sql = "jdbc:mysql://localhost/myLibe";
                con = DriverManager.getConnection(sql, "root", "R");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver não localizado");
            }
        }
        return con;
    }

    public void finalize() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro de fechamento do banco");
        }
    }
}
