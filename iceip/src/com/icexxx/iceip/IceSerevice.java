package com.icexxx.iceip;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.json.JSONUtil;

public class IceSerevice {

    public static void save(IceIp iceIp) {
        String clientIp = iceIp.getClientIp();
        String clientTime = iceIp.getClientTime();
        String hostname = iceIp.getHostname();
        int group = iceIp.getGroup();
        String ip = iceIp.getIp();
        String username = iceIp.getUsername();
        String password = iceIp.getPassword();
        String serverTime = DateUtil.now();
        DataSource ds = DSFactory.get();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            String sql = "insert into iceip(id,hostname,ip,groupx,client_time,server_time,username,password,client_ip) values(null,?,?,?,?,?,?,?,?)";
            int execute = SqlExecutor.execute(conn, sql, hostname, ip, group, clientTime, serverTime, username,
                    password, clientIp);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn);
        }
    }

    public static String find(String username, String password, String group) {
        if (StrUtil.isNotBlank(username)) {
            if (StrUtil.isNotBlank(password)) {
                if (StrUtil.isNotBlank(group)) {
                    return findIp(username, password, group);
                }
            }
        }
        return null;
    }

    private static String findIp(String username, String password, String group) {
        String sql = "select m.hostname,ip from (select * from iceip where username = ? and password = ? and groupx = ?) t left join "
        +" (select hostname,max(server_time) max_server_time from iceip where username = ? and password = ? and groupx = ? group by hostname) m "
        +" on t.hostname = m.hostname where t.server_time = m.max_server_time";
        return sql(sql, username, password, group);
    }

    private static String sql(String sql, String username, String password, String group) {
        DataSource ds = DSFactory.get();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            RsHandler rsh = new EntityListHandler();
            List<Entity> query = (List<Entity>) SqlExecutor.query(conn, sql, rsh, username, password, group, username, password, group);
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            for (int i = 0; i < query.size(); i++) {
                Entity entity = query.get(i);
                String hostname = entity.getStr("hostname");
                String ip = entity.getStr("ip");
                Map<String, String> map = new HashMap<String, String>();
                map.put("hostname", hostname);
                map.put("ip", ip);
                list.add(map);
            }
            return JSONUtil.toJsonStr(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn);
        }
        return null;
    }

}
