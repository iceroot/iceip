package com.icexxx.iceip;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.hutool.core.date.DateUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.SqlRunner;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.sql.SqlExecutor;

public class Main {

    public static void main(String[] args) {
        DataSource ds = DSFactory.get();
        SqlRunner runner = SqlRunner.create(ds);
        Connection conn = null;
        try {
            conn = ds.getConnection();
            String sql="insert into iceip(id,hostname,ip,groupx,client_time,server_time,username,password,client_ip) values(null,?,?,?,?,?,?,?,?)";
            Object params;
//        String id="1001";
            String hostname="localhost";
            String ip="127.0.0.1";
            int group = 0;
            String clientTime="2010-12-23 13:46:57";
            String serverTime=DateUtil.now();
            String username = "username";
            String password = "password";
            String clientIp = "clientIp";
            int execute = SqlExecutor.execute(conn, sql, hostname,ip,group,clientTime,serverTime,username,password,clientIp);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbUtil.close(conn);
        }
    }

}
