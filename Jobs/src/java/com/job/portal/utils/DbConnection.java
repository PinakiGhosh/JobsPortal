package com.job.portal.utils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author 711638
 */
public class DbConnection {

    private String server, port, username, password, driver, database, lang_support;
    int min, max, part, idleMaxAgeInMinutes;
    static BoneCP connectionPool = null;

    public DbConnection() {
    }

    public void createPool() {
        try {
            Properties prop = new Properties();
            prop.load(DbConnection.class.getResourceAsStream("/db.properties"));
            server = prop.getProperty("server");
            port = prop.getProperty("port");
            database = prop.getProperty("database");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
            min = Integer.parseInt(prop.getProperty("min_Connections"));
            max = Integer.parseInt(prop.getProperty("max_Connections"));
            part = Integer.parseInt(prop.getProperty("partitions"));
            idleMaxAgeInMinutes = Integer.parseInt(prop.getProperty("idleMaxAgeInMinutes"));
            lang_support = prop.getProperty("lang_support");

            Class.forName(driver);
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl("jdbc:mysql://" + server + ":" + port + "/" + database + lang_support);
            config.setUsername(username);
            config.setPassword(password);
            config.setMinConnectionsPerPartition(min);
            config.setMaxConnectionsPerPartition(max);
            config.setPartitionCount(part);
            config.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
            config.setIdleConnectionTestPeriodInMinutes(3);
            config.setConnectionTestStatement("SELECT 1");
            config.setCloseConnectionWatch(true);
            connectionPool = new BoneCP(config);
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            if (connectionPool == null) {
                createPool();
            }
            con = connectionPool.getConnection();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }
        return con;
    }

    public void closePool() {
        try {
            connectionPool.shutdown();
        } catch (Exception e) {
            LogOut.log.error("In " + new Object() {
            }.getClass().getEnclosingClass().getName() + "." + new Object() {
            }.getClass().getEnclosingMethod().getName() + " " + e);
        }

    }

    public static void main(String[] args) {
        System.out.println(new DbConnection().getConnection());
    }
}
