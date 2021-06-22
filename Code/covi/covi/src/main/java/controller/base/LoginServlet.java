/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.TaiKhoanDAO;
import entity.KhuCachLy;
import entity.TaiKhoan;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;
import utils.Utils;
import static utils.Utils.md5;

/**
 *
 * @author CHUNG
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String baseURL = Utils.getBaseUrl(request);
        HttpSession ss = request.getSession();
        ss.setAttribute("baseURL", baseURL);
        String tenDN = request.getParameter("ten_dang_nhap");
        String password = request.getParameter("password");
        String passwordMd5 = md5(password);
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        TaiKhoan user = taiKhoanDAO.find(tenDN, passwordMd5);
        if (user == null) {
            Notification noti = new Notification("Error", "Tài khoản không đúng. Vui lòng kiểm tra lại.", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("login.jsp");
            
            rt.forward(request, response);
        } else {
            KhuCachLy khuCachLy = user.getKhuCachLy();  
            ss.setAttribute("userLogin", user);
            ss.setAttribute("khuCachLy", khuCachLy);
            RequestDispatcher rt = request.getRequestDispatcher("home");
            rt.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
