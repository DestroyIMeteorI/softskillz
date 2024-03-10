package com.softskillz.servlets;

import com.softskillz.dao.ProductDAO;
import com.softskillz.models.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;

@WebServlet("/MallInsert")
public class MallInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取参数
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productStock = Integer.parseInt(request.getParameter("productStock"));
        String productDescription = request.getParameter("productDescription");
        
        // 创建Product对象并设置属性
        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductStock(productStock);
        product.setProductDescription(productDescription);
        product.setProductCreateDate(LocalDateTime.now());
        product.setProductUpdateDate(LocalDateTime.now());
        
        // 这里需要自己实现获取数据库连接的方法
        Connection connection = null; // 获取数据库连接
        ProductDAO dao = new ProductDAO(connection);
        boolean result = dao.addProduct(product);
        
        // 根据操作结果重定向到不同的页面
        if (result) {
            response.sendRedirect("success.jsp"); // 成功页面
        } else {
            response.sendRedirect("error.jsp"); // 错误页面
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通常将GET请求重定向到POST处理，或者可以直接返回错误。
        doPost(request, response);
    }
}
