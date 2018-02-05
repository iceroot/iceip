package com.icexxx.iceip.client;

import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.util.NetUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpUtil;
import cn.hutool.setting.Setting;

public class Client {
    // http://127.0.0.1:8080/iceip/aaa?hostname=hostname&group=1&username=username&password=password&ip=192.168.123.123&time=1517661789454
    public static void main(String[] args) {
        Setting setting = null;
        try {
            setting = new Setting("../iceip.setting");
        } catch (NoResourceException e) {
            System.out.println("配置文件iceip.setting不存在");
            e.printStackTrace();
        }
        String username = setting.getStr("username");
        String password = setting.getStr("password");
        String group = setting.getStr("group");
        String hostname = setting.getStr("hostname");
        String url = setting.getStr("url");
        System.out.println(username);
        System.out.println(password);
        System.out.println(group);
        System.out.println(hostname);
        String ip = NetUtil.getLocalhostStr();
        long time = System.currentTimeMillis();
        String timeStr = time + "";
        String urlStr = "http://" + url + "/iceip/aaa?hostname=" + hostname + "&group=" + group + "&username="
                + username + "&password=" + password + "&ip=" + ip + "&time=" + timeStr + "";
        String result = null;
        try {
            result = HttpUtil.get(urlStr);
        } catch (HttpException e) {
            System.out.println("网址" + urlStr + "不可用");
            e.printStackTrace();
        }
        System.out.println(result);
    }

}
