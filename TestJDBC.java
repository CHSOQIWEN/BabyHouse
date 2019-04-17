package com.bittch;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Auther:CHAOQIWEN
 */
public class TestJDBC {

    public static void main(String[] args) {
        //1.加载驱动程序

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获取连接
        //JDBC  API
        //第一种：DriverManager
        //第二种：DataSource
        //url： JDBC url schema:
        //     jdbc：<数据库产品名称>：//host:port/<databaseName>?param1=value1&param2=value2
        //user：root
        //password： root

        String ur1="jdbc:mysql://127.0.0.1:3306/memo";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DriverManager.getConnection(ur1,"root","root");

            //3：创建命令
            connection.createStatement();
            //4.准备sql语句，执行
            String sql="select id,name,created_name,modify_time from memo_group";
            statement.executeQuery(sql);

            //5.返回结果，处理结果
            while(resultSet.next()){
              int id=resultSet.getInt("id");
              String name = resultSet.getString("name");
              LocalDateTime createdTime = resultSet.getTimestamp("create_time").toLocalDateTime();
              LocalDateTime modifyTime=resultSet.getTimestamp("modify_time").toLocalDateTime();

              System.out.println(String.format("编号：%d   名称：%s      创建时间：%s  修改时间：%s，" +
                      "id,name,createdTime,modifyTime"));


            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.关闭资源
            //结果->命令->连接
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
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
    }
}

