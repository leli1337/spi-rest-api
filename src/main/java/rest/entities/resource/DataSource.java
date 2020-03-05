package rest.entities.resource;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;

public class DataSource {
    public static BasicDataSource basicDataSource;
    private static int poolMaxConnections = 50;
    private static int poolMinConnections = 5;

    private static String instance = "SPI";
    private static String IP = "52.169.180.160";
    private static String port = "1433";
    private static String database = "marketplace";
    private static String username = "marketplace";
    private static String password = "marketplace";

    private DataSource() {
    }

    public static synchronized Connection getConnection() throws Exception {
        if (basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
            String url = "jdbc:jtds:sqlserver://" + IP + ":" + port + "/" + database;
            if (instance != null) {
                url += ";instance=" + instance;
            }
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
            basicDataSource.setInitialSize(poolMinConnections);
            basicDataSource.setMaxActive(poolMaxConnections);
            basicDataSource.setMaxWait(10000);
            basicDataSource.setTestOnBorrow(true); //default true
            basicDataSource.setTestOnReturn(true);
            basicDataSource.setTestWhileIdle(true);
            basicDataSource.setValidationQuery("Select 1");
            basicDataSource.setMaxIdle(poolMinConnections);
            basicDataSource.setPoolPreparedStatements(false);
        }
        Connection connection = basicDataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}