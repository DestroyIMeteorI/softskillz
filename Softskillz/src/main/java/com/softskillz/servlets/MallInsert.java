package com.softskillz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MallInsert
 */
@WebServlet("/MallInsert")
public class MallInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MallInsert() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 處理GET請求
        response.getWriter().append("Insert functionality is not supported via GET method.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 實現新增商品的邏輯
        // 示例: String productName = request.getParameter("name");
        // 根據接收的參數進行處理，例如新增商品到資料庫

        // 重定向到商品列表頁面或顯示成功訊息
        response.sendRedirect("mall/admin/product/MallSelect.jsp");
    }
}
