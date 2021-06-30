/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.TaiKhoanDAO;
import entity.LoaiTaiKhoan;
import entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Configs;
import utils.Notification;
import utils.Utils;
import static utils.Utils.md5;

/**
 *
 * @author CHUNG
 */
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String baseURL = Utils.getBaseUrl(request);
        HttpSession ss = request.getSession();
        ss.setAttribute("baseURL", baseURL);
        String tenDN = request.getParameter("ten_dang_nhap");
        String password = request.getParameter("password");
        String passwordMd5 = md5(password);
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        int phoneNumber = Integer.parseInt(phone);
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        TaiKhoan user = taiKhoanDAO.find(tenDN);
        if (user != null) {
            Notification noti = new Notification("Warning", "Tài khoản đã bị trùng.<br/> Vui lòng chọn tên tài khoản khác.", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("register.jsp");
            rt.forward(request, response);
        } else {
            TaiKhoan newUser = new TaiKhoan();
            newUser.setTenDangNhap(tenDN);
            newUser.setPassword(passwordMd5);
            newUser.setTenNguoiDung(fullname);
            newUser.setSoDienThoai(phoneNumber);
            newUser.setLoaiTaiKhoan(new LoaiTaiKhoan(3));
            newUser.setAvatar(Configs.IMG_PATH_AVATAR_DEFAULT);
            newUser.setNgCachLy(null);
            taiKhoanDAO.create(newUser);
            // set Session Login
            TaiKhoan user2 = taiKhoanDAO.find(tenDN, passwordMd5);
            ss.setAttribute("userLogin", user2);
            Notification noti = new Notification("Success", "Xin chúc mừng bạn đã đăng ký thành công", "success");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("home.jsp");
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
