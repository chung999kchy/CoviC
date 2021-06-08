/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.accountManager;

import dao.LoaiTaiKhoanDAO;
import dao.TaiKhoanDAO;
import entity.KhuCachLy;
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
import static utils.Utils.md5;

/**
 *
 * @author CHUNG
 */
public class addAccount extends HttpServlet {

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
        String tenDN = request.getParameter("ten_dang_nhap");
        String password = request.getParameter("mat_khau");
        String passwordMd5 = md5(password);
        String fullname = request.getParameter("ho_ten");
        String phone = request.getParameter("so_dien_thoai");
        String tenLoai = request.getParameter("loai");
        int phoneNumber = Integer.parseInt(phone);
        HttpSession ss = request.getSession();
        KhuCachLy khu = (KhuCachLy) ss.getAttribute("khuCachLy");
        
        
        //check ten dang nhap
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        TaiKhoan user = taiKhoanDAO.find(tenDN);
        if (user != null) {
            Notification noti = new Notification("Error", "Tài khoản đã tồn tại", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("add-nhansu.jsp");
            rt.forward(request, response);
        } else {

            // lay so id loai tai khoan
            LoaiTaiKhoanDAO loaiDAO = new LoaiTaiKhoanDAO();
            LoaiTaiKhoan loaiTK = loaiDAO.find(tenLoai);

            TaiKhoan newUser = new TaiKhoan();
            newUser.setTenDangNhap(tenDN);
            newUser.setPassword(passwordMd5);
            newUser.setTenNguoiDung(fullname);
            newUser.setSoDienThoai(phoneNumber);
            newUser.setLoaiTaiKhoan(loaiTK);
            newUser.setAvatar(Configs.IMG_PATH_AVATAR_DEFAULT);
            newUser.setNgCachLy(null);
            newUser.setKhuCachLy(khu);
            taiKhoanDAO.create(newUser);

            Notification noti = new Notification("Success", "Thêm tài khoản nhân sự thành công.", "success");
            request.setAttribute("notify", noti);
            RequestDispatcher r1 = request.getRequestDispatcher("view-list");
            r1.forward(request, response);

        }
    }
}
