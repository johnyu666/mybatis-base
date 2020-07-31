package cn.johnyu.tools;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            Properties properties=new Properties();
            try {
                properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataSource = new BasicDataSource();
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setDriverClassName(properties.getProperty("dirver"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
        }
        return dataSource;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getDataSource().getConnection());
    }
}
