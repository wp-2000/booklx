package com.wp.dao;

import com.wp.util.DBHlper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public <T> List<T> findAll(String sql, Class<T> cls, Object... obj){
        // 获取连接
        Connection conn = DBHlper.getConn();
        // 定义预处理对象，返回值结果对象
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> infos = new ArrayList<>();
        try{
            // 获取对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i+1, obj[i]);
            }
            // 执行
            rs = ps.executeQuery();
            while(rs.next()){
                T bean = rsToBean(rs, cls);
                infos.add(bean);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            DBHlper.close(conn, ps, rs);
        }
        return infos;
    }

    /***
     * 通用的单条查询
     * @param sql
     *          sql 语句
     * @param cls
     *          返回的类型
     * @param obj
     *          参数
     * @param <T>
     * @return
     */
    public <T> T findOne(String sql, Class<T> cls, Object... obj){
        List<T> infos = findAll(sql, cls, obj);
        if (infos != null){
            return infos.get(0);
        }
        return null;
    }

    /***
     * 通用的增删改
     * @param sql
     *      SQL语句
     * @param obj
     *      参数
     * @return
     */
    public int editBase(String sql, Object... obj){
        // 获取连接
        Connection conn = DBHlper.getConn();
        // 定义预处理对象，返回值结果对象
        PreparedStatement ps = null;
        try{
            // 获取对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i+1, obj[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            DBHlper.close(conn, ps);
        }

        return -1;
    }


    private <T> T rsToBean(ResultSet rs, Class<T> cls) {
        T t = null;
        try{
            t = cls.newInstance(); //  cls.newInstance(); == new DeptInfo();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i + 1);
                Object data = rs.getObject(columnLabel);

                Field declaredField = cls.getDeclaredField(columnLabel); // 使用反射操作类的属性
                declaredField.setAccessible(true);
                declaredField.set(t, data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }

}
