package com.softskillz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 實現類 MallDelete
 */
@WebServlet("/MallDelete")
public class MallDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 默認構造函數。
     */
    public MallDelete() {
        super();
        // TODO 自動生成的構造函數存根
    }

    /**
     * 處理 HTTP GET 請求。
     * @param request servlet 請求
     * @param response servlet 回應
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 示例：從請求中獲取要刪除的商品 ID
        String productId = request.getParameter("id");
        
        // TODO: 實現從資料庫中刪除該商品的邏輯
        // 例如，調用 DAO 類的方法根據商品 ID 進行刪除
        
        // 刪除後重定向到確認頁面或商品列表頁面
        response.sendRedirect("path/to/confirmation/page.jsp");
    }

    /**
     * 處理 HTTP POST 請求。
     * @param request servlet 請求
     * @param response servlet 回應
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果您希望 POST 請求和 GET 請求相同的處理方式，可以調用 doGet 方法
        doGet(request, response);
    }
}
