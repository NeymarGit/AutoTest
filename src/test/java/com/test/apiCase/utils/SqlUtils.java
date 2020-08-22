package com.test.apiCase.utils;

import com.test.apiCase.basedata.TMaUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 执行sql语句
 */

public class SqlUtils {

    public static void main(String[] args) throws Exception{
        String selectSql = "select hight from t_ma_user where id = 1002;";
        double beforValue = selectColum(selectSql);
        updateSql();
        double afterValue = selectColum(selectSql);
        if(beforValue == afterValue){
            System.out.println("断言成功");
        }else{
            System.out.println("断言失败");
        }


    }

    private static QueryRunner runner = new QueryRunner();
    // 获取数据库连接
   private static Connection conn = JDBCUtils.getConnection();

    // 执行查询语句,返回map类型的一条查询结果
    public static void selectMap(String sql) throws Exception{
        // 返回map类型的一条查询结果
        MapHandler handler = new MapHandler();
        Map<String, Object> query = runner.query(conn, sql, handler);
        System.out.println(query);
    }

    // 返回map类型的多条查询结果
    public static void selectMaps(String sql) throws Exception{
        MapListHandler listHandler = new MapListHandler();
        List<Map<String, Object>> query1 = runner.query(conn, sql, listHandler);
        System.out.println(query1);
        System.out.println("----------------------------");

    }

    // 执行查询语句,返回对象类型
    public static void selectBean(String sql) throws SQLException {
        // 返回对象类型的一条查询结果
        BeanHandler bh = new BeanHandler(TMaUser.class);
        Object query2 = runner.query(conn, sql, bh);
        System.out.println(query2);
        }


    // 执行查询语句,返回对象类型
    public static void selectBeans(String sql) throws SQLException {
        // 返回对象类型的多条查询结果
        BeanListHandler<TMaUser> blh = new BeanListHandler<>(TMaUser.class);
        List<TMaUser> query3 = runner.query(conn, sql, blh);
        for(TMaUser user : query3){
            System.out.println(user);
        }
    }

    // 查询某个指定字段的值
    public static Double selectColum(String sql) throws SQLException {
        // 返回对象类型的一条查询结果
        ScalarHandler<Double> scalarHandler = new ScalarHandler<>();
        double query4 = runner.query(conn, sql, scalarHandler);
        System.out.println(query4);
        return query4;
    }

    // 执行增删改sql
    public static void updateSql() throws SQLException {
        String sql = "update t_ma_user set hight = 1.85 where id = 1002;";
        String sql1 = "INSERT INTO `t_ma_user`(`name`, `pwd`, `hight`, `remark`) VALUES ('meul', 'hehe', 1.24,'发货3天内');";

        // 执行sql语句
        int update = runner.update(conn, sql);
        System.out.println(update);
//        JDBCUtils.close(conn);
    }



}
