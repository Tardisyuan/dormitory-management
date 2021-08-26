package com.tardisyuan.dormmanagement.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class dbconnection {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //用流读入properties配置文件
            Properties properties = new Properties();
            //通过类加载器读取把文件转化成输入字节流
            properties.load(dbconnection.class.getClassLoader().getResourceAsStream("db.properties"));

            // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
            String JDBC_DRIVER = properties.getProperty("jdbc.driver");
            String DB_URL = properties.getProperty("jdbc.url");
            // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
            //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            // 数据库的用户名与密码，需要根据自己的设置
            String USER = properties.getProperty("jdbc.username");
            String PASS = properties.getProperty("jdbc.password");
//            System.out.println(JDBC_DRIVER);
//            System.out.println(DB_URL);
//            System.out.println(USER);
//            System.out.println(PASS);

            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT cid, cname, mid FROM classes";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("cid");
                String name = rs.getString("cname");
                String mid = rs.getString("mid");

                // 输出数据
                System.out.print("班级: " + id);
                System.out.print(", 班级名称: " + name);
                System.out.print(", 专业编号: " + mid);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

