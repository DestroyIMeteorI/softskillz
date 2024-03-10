package com.softskillz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softskillz.dao.ProductDAO;
import com.softskillz.models.Product;

@WebServlet("/MallUpdate")
public class MallUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 從請求中獲取資料
        String productId = request.getParameter("id");
        String productName = request.getParameter("name");
        String productDescription = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        boolean isUpdated = false;
        
        // 驗證並轉換資料，調用 DAO 更新商品
        if (productId != null && productName != null && productDescription != null && category != null && price != null && stock != null) {
            Product product = new Product();
            product.setProductId(Integer.parseInt(productId));
            product.setProductName(productName);
            product.setProductDescription(productDescription);
            product.setCategoryId(Integer.parseInt(category));
            product.setProductPrice(Integer.parseInt(price));
            product.setProductStock(Integer.parseInt(stock));

            ProductDAO productDao = new ProductDAO();
            isUpdated = productDao.updateProduct(product);
        }
        
        // 設定更新結果屬性並重定向到 CRUD 結果顯示頁面
        request.getSession().setAttribute("crudResult", isUpdated ? "Update successful" : "Update failed");
        response.sendRedirect(request.getContextPath() + "/mall/admin/product/crudResult.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}