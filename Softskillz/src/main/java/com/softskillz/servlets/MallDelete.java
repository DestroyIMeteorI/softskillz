package com.softskillz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softskillz.dao.ProductDAO;

@WebServlet("/MallDelete")
public class MallDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MallDelete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        boolean isDeleted = false;
        
        // 呼叫 DAO 刪除商品
        ProductDAO productDao = new ProductDAO();
        if (productId != null && !productId.trim().isEmpty()) {
            int id = Integer.parseInt(productId);
            isDeleted = productDao.deleteProduct(id);
        }
        
        // 設定刪除結果屬性並重定向到 CRUD 結果顯示頁面
        request.getSession().setAttribute("crudResult", isDeleted ? "Delete successful" : "Delete failed");
        response.sendRedirect(request.getContextPath() + "/mall/admin/product/crudResult.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
