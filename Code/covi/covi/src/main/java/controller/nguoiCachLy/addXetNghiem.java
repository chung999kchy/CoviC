/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nguoiCachLy;

import dao.KqXetNghiemDAO;
import dao.NguoiCachLyDAO;
import entity.KqXetNghiem;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
@WebServlet(name = "addXetNghiem", urlPatterns = {"/NguoiCachLy/add-xetnghiem"})
public class addXetNghiem extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));

        // change format time
        String time = request.getParameter("tg");
        String time2 = time.replace("T", " ") + ":00";
        Date tg = null;
        try {
            tg = Utils.DATE_FORMATER.parse(time2);
        } catch (ParseException ex) {
            tg = new Date();
        }

        String loai = request.getParameter("loai_xet_nghiem");
        String kq = request.getParameter("ket_qua");
        KqXetNghiemDAO dao = new KqXetNghiemDAO();
        KqXetNghiem xetNghiem = new KqXetNghiem();
        xetNghiem.setKqXetNghiem(kq);
        xetNghiem.setTenLoaiXetNghiem(loai);
        NguoiCachLyDAO ngDAO = new NguoiCachLyDAO();
        xetNghiem.setNgCachLy(ngDAO.get(id));
        xetNghiem.setTgXetNghiem(new java.sql.Timestamp(tg.getTime()));
        dao.create(xetNghiem);
        Notification noti = new Notification("Success", "Đã thêm kết quả xét nghiệm thành công", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-detail?id=" + id);
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
