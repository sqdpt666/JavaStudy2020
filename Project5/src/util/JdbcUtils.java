package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;


    static {
        Properties properties = new Properties();
        //读取jdbc配置文件
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //从流中加载数据
            properties.load(inputStream);
            //创 数据库连接池
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //返回null则失败
   public static Connection getConnection()  {

       Connection connection=null;
       try {
           connection=dataSource.getConnection();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return connection;


    }

    public static void close(Connection connection){
         if(connection!=null){
             try {
                 connection.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }

    }

}
