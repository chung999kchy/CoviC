/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Phong;

import dao.NguoiCachLyDAO;
import dao.PhongDAO;
import entity.NguoiCachLy;
import entity.Phong;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;

/**
 *
 * @author CHUNG
 */
public class deletePhong extends HttpServlet {

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
        String id = request.getParameter("id");

        PhongDAO dao = new PhongDAO();
        NguoiCachLyDAO ngDAO = new NguoiCachLyDAO();

        Phong phong = dao.get(Integer.parseInt(id));
        List<NguoiCachLy> list = ngDAO.getListInPhong(Integer.parseInt(id), phong.getKhuCachLy().getIdKhuCachLy());
        if (list.size() > 0) {
            Notification noti = new Notification("Warning", "Không thể xóa phòng cách ly khi trong đó vẫn còn người ở.", "warning");
            request.setAttribute("notify", noti);
            RequestDispatcher r1 = request.getRequestDispatcher("view-list");
            r1.forward(request, response);
        }else {
            dao.delete(phong);
            Notification noti = new Notification("Success", "Xóa phòng cách ly thành công.", "success");
            request.setAttribute("notify", noti);
            RequestDispatcher r1 = request.getRequestDispatcher("view-list");
            r1.forward(request, response);
        }

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
