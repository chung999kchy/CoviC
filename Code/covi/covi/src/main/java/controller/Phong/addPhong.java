/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Phong;

import dao.PhongDAO;
import entity.KhuCachLy;
import entity.Phong;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;

/**
 *
 * @author CHUNG
 */
public class addPhong extends HttpServlet {

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
        HttpSession ss = request.getSession();
        KhuCachLy khu = (KhuCachLy) ss.getAttribute("khuCachLy");
        String ten = request.getParameter("ten");
        String giuong = request.getParameter("giuong");
        String ghiChu = request.getParameter("ghi_chu");

        // lay so id loai tai khoan
        PhongDAO dao = new PhongDAO();
        Phong phong = new Phong();
        phong.setTenPhong(ten);
        phong.setGhiChu(ghiChu);
        phong.setSoGiuong(giuong);
        phong.setKhuCachLy(khu);
        dao.create(phong);

        Notification noti = new Notification("Success", "Thêm phòng cách ly thành công.", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-list");
        r1.forward(request, response);
    }
}
