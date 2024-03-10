package com.softskillz.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softskillz.dao.ProductDAO;
import com.softskillz.models.Product;

@WebServlet("/MallSelect")
public class MallSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 調用 DAO 查詢商品
        ProductDAO productDao = new ProductDAO();
        List<Product> products = productDao.getAllProducts();
        
        // 將查詢結果存入請求屬性
        request.setAttribute("products", products);
        
        // 將請求轉發到顯示商品的頁面
        request.getRequestDispatcher("productDisplay.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}