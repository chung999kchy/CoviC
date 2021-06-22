/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Don;

import dao.DonDAO;
import dao.KhuCachLyDAO;
import dao.LoaiDonDAO;
import dao.NguoiCachLyDAO;
import dao.PhongDAO;
import entity.Don;
import entity.KhuCachLy;
import entity.NguoiCachLy;
import entity.Phong;
import entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class addDon extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String noi_dung = request.getParameter("noi_dung");
        int loaiDon = Integer.parseInt(request.getParameter("loai_don"));
        int idKhu = Integer.parseInt(request.getParameter("khu_cach_ly"));
        HttpSession ss= request.getSession();
        TaiKhoan tk = (TaiKhoan)ss.getAttribute("userLogin");
        LoaiDonDAO ldDAO = new LoaiDonDAO();
        KhuCachLyDAO khuDAO = new KhuCachLyDAO();
        
        String tg_vao = Utils.getToday();
        Date Tg_vao = null;
        try {
            Tg_vao = Utils.DATE_FORMATER.parse(tg_vao);
        } catch (ParseException ex) {
            Tg_vao = new Date();
        }
        

        // Tao doi tuong Don
        Don don = new Don();
        don.setKhuCachLy(khuDAO.get(idKhu));
        don.setNoiDung(noi_dung);
        don.setNguoiTao(tk);
        don.setLoaiDon(ldDAO.get(loaiDon));
        don.setTgTao(new java.sql.Timestamp(Tg_vao.getTime()));
        

        DonDAO dao = new DonDAO();
        dao.create(don);
        Notification noti = new Notification("Success", "Tạo đơn mới thành công", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-list");
        r1.forward(request, response);
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
