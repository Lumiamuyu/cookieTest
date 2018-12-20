package Lumiamuyu.utilTest;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USER ="root";
    private static final String PWD ="123456";

    static {
        try {
            //调用驱动
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //定义一个方法来创建连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //定义增删改方法
    public static int executeUpdate(String sql,Object... object){
        int a = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            if (object!=null){
                for (int i=0;i<object.length;i++){
                    preparedStatement.setObject(i+1,object[i]);
                }
            }
            a =  preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            close(null,preparedStatement,connection);
        }
        return a;
    }

    //定义查询方法
    public static <T> List<T> executeQuery(String sql, RowMap<T> rowMap, Object... objects){
        List<T> lists = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);

            if (objects !=null){
                for (int i = 0; i<objects.length;i++){
                    preparedStatement.setObject(i+1,objects[i]);
                }}
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    T t = rowMap.RowMapping(resultSet);
                    lists.add(t);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,preparedStatement,connection);
        }
        return lists;
    }


    public static <T> T queryOne(String sql, RowMap<T> rowMap, Object... objects){
        T t = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);

            if (objects !=null){
                for (int i = 0; i<objects.length;i++){
                    preparedStatement.setObject(i+1,objects[i]);
                }}
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                t = rowMap.RowMapping(resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,preparedStatement,connection);
        }
        return t;
    }

    public static <T> int executeCount(String sql, Object... objects){
        int a = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);

            if (objects !=null){
                for (int i = 0; i<objects.length;i++){
                    preparedStatement.setObject(i+1,objects[i]);
                }}
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                a=resultSet.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,preparedStatement,connection);
        }
        return a;
    }


}
