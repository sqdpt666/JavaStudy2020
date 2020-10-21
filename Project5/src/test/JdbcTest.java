package test;

import org.junit.Test;
import util.JdbcUtils;

import java.sql.Connection;

public class JdbcTest {
@Test
public void test(){
    Connection connection=JdbcUtils.getConnection();
    System.out.println(connection);
    JdbcUtils.close(connection);
}

}
