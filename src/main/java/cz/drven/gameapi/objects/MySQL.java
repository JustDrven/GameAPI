package cz.drven.gameapi.objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    private String host, user, password, database;
    private int port;
    private Connection conn;

    public MySQL(String host, String user, int port, String password, String database) throws SQLException {
        this.host = host;
        this.user = user;
        this.port = port;
        this.password = password;
        this.database = database;
    }

    public void connect() throws SQLException {
        if (conn != null && !conn.isClosed()) return;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";
        conn = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public ResultSet execute(String sqlURL) throws SQLException {
        if (conn == null || conn.isClosed()) {
            connect();
        }

        return conn.createStatement().executeQuery(sqlURL);
    }

}
