package DB;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;

public class Database {
    public static BasicDataSource basicDataSource;
    private static int poolMaxConnections = 50;
    private static int poolMinConnections = 5;

    private void DataSource() {
    }

    public static synchronized Connection getConnection() throws Exception {
        if (basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            String instance = "INSTANCE";
            String IP = "52.169.180.160";
            String port = "1433";
            String database = "marketplace";
            String username = "marketplace";
            String password = "marketplace";
            int maxConnections = 100;
            basicDataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
            String url = "jdbc:jtds:sqlserver://" + IP + ":" + port + "/" + database;
            if (instance != null) {
                url += ";instance=" + instance;
            }
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
            basicDataSource.setInitialSize(poolMinConnections);
            basicDataSource.setMaxActive(maxConnections);
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
