package com.fengze.shop.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	//声明线程共享变量
	public static ThreadLocal<Connection> container = null;

	private static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
		container = new ThreadLocal<Connection>();
	}

	//获取共享变量
	public static ThreadLocal<Connection> getContainer(){
		return container;
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        }catch (Exception e){
            throw new RuntimeException();
        }
	}

    /**
     * 获取当前线程上的连接 开启事务
     */
    public static void startTransaction(){
        Connection conn = container.get();//首先获取当前线程的连接
        if(conn == null){//如果连接为空
            conn = getConnection(); //从连接池中获取连接
            container.set(conn);//将此连接放在当前线程上
        }
        try {
            conn.setAutoCommit(false);//开启事务
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * 提交事务
     */
    public static void commit() {
        Connection conn = container.get();// 从当前线程上获取连接
        if (conn != null) {// 如果连接为空，则不做处理
            try {
                conn.commit();// 提交事务
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     *回滚事务
     */
    public static void rollback(){
        Connection conn = container.get();//检查当前线程是否存在连接
        if(conn != null){
            try {
                conn.rollback();//回滚事务
                // container.remove();//如果回滚了，就移除这个连接
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(),e);
            }
        }
    }
    /**
     * 关闭连接
     */
    public static void close(){
        Connection conn = container.get();
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(),e);
            }finally{
                container.remove();//从当前线程移除连接 切记
            }
        }
    }
}
