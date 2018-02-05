package com.icexxx.iceip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * Servlet implementation class IceIpServlet
 */
@WebServlet("/aaa")
public class IceIpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IceIpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // http://127.0.0.1:8080/iceip/aaa?hostname=hostname&group=1&username=username&password=password&ip=192.168.123.123&time=1517661789454
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hostname = request.getParameter("hostname");
        String group = request.getParameter("group");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ip = request.getParameter("ip");
        String time = request.getParameter("time");
        String clientIp = request.getLocalAddr();
        IceIp iceIp = new IceIp();
        iceIp.setClientIp(clientIp);
        iceIp.setHostname(hostname);
        iceIp.setGroup(Convert.toInt(group, -1));
        iceIp.setUsername(username);
        iceIp.setPassword(password);
        iceIp.setIp(ip);
        if (StrUtil.isNotBlank(time)) {
            iceIp.setClientTime(DateUtil.date(Convert.toLong(time)).toString());
        }
        iceIp.setClientIp(clientIp);
        IceSerevice.save(iceIp);
        String json = IceSerevice.find(username, password, group);
        response.getWriter().append(json);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
