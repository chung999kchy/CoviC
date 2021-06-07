/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nguoiCachLy;

import dao.NguoiCachLyDAO;
import dao.PhongDAO;
import entity.KhuCachLy;
import entity.NguoiCachLy;
import entity.Phong;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
public class addNgCachLy extends HttpServlet {

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
        String ho_ten = request.getParameter("ho_ten");
        String phan_loai = request.getParameter("phan_loai");
        String tuoi = request.getParameter("tuoi");
        int tuoi_int = Integer.parseInt(tuoi);
        String gioi_tinh = request.getParameter("gioi_tinh");
        String ma_can_cuoc = request.getParameter("ma_can_cuoc");
        String quoc_tich = request.getParameter("quoc_tich");
        String dia_chi = request.getParameter("dia_chi");
        String sdt = request.getParameter("so_dien_thoai");
        int sdt_int = Integer.parseInt(sdt);
        String so_phong = request.getParameter("phong");
        PhongDAO phongDAO = new PhongDAO();
        Phong phong = phongDAO.get(Integer.parseInt(so_phong));
        String tg_vao = Utils.getToday();
        Date Tg_vao = null;
        try {
            Tg_vao = Utils.DATE_FORMATER.parse(tg_vao);
        } catch (ParseException ex) {
            Tg_vao = new Date();
        }
        HttpSession ss = request.getSession();
        KhuCachLy khu = (KhuCachLy) ss.getAttribute("khuCachLy");

        // Tao doi tuong NguoiCachLy
        NguoiCachLy nguoi = new NguoiCachLy();
        nguoi.setTenNguoiCachLy(ho_ten);
        nguoi.setMucDoNghiNhiem(phan_loai);
        nguoi.setCmt(ma_can_cuoc);
        nguoi.setDiaChi(dia_chi);
        nguoi.setGioiTinh(gioi_tinh);
        nguoi.setPhong(phong);
        nguoi.setQuocTich(quoc_tich);
        nguoi.setSoDienThoai(sdt_int);
        nguoi.setTuoi(tuoi_int);
        nguoi.setTgVaoCachLy(new java.sql.Timestamp(Tg_vao.getTime()));
        nguoi.setKhuCachLy(khu);

        NguoiCachLyDAO dao = new NguoiCachLyDAO();
        dao.create(nguoi);
        Notification noti = new Notification("Success", "Thêm người cách ly thành công", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-list");
        r1.forward(request, response);
      
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
