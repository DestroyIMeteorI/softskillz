package com.softskillz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MallSelect
 */
@WebServlet("/MallSelect")
public class MallSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MallSelect() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 實現查詢商品的邏輯
        // 可以根據請求參數查詢商品，然後將結果設置到請求屬性中
        // request.setAttribute("products", products);

        // 轉發到商品顯示頁面
        request.getRequestDispatcher("/mall/admin/product/MallSelect.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通常查詢操作使用GET方法，所以這裡可以重定向到GET方法處理
        doGet(request, response);
    }
}
