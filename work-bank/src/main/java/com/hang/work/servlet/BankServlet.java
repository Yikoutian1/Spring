package com.hang.work.servlet;

import com.google.gson.Gson;
import com.hang.work.dao.RecordDao;
import com.hang.work.entity.BankOprecord;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName BaseServlet
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/19 019 19:22
 * @Version 1.0
 */
@WebServlet("/query/*")
public class BankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getParameter(null) = " + req.getParameter(null));
        //  /work_bank_war_exploded
        WebApplicationContext webApplicationContext =
                WebApplicationContextUtils
                        .getWebApplicationContext(this.getServletContext());
        resp.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        RecordDao recordDao = webApplicationContext.getBean("recordDao", RecordDao.class);
        List<BankOprecord> bankOprecords = recordDao.selectById(123);
        resp.getWriter().println(gson.toJson(bankOprecords));
    }
}
