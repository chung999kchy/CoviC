/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nguoiCachLy;

import dao.KqXetNghiemDAO;
import dao.NguoiCachLyDAO;
import entity.KqXetNghiem;
import entity.NguoiCachLy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
public class viewDetailNgCachLy extends HttpServlet {

    

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = 0;
        if(request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        NguoiCachLyDAO dao = new NguoiCachLyDAO();
        NguoiCachLy nguoi = dao.get(id);
        KqXetNghiemDAO kqDAO = new KqXetNghiemDAO();
        List<KqXetNghiem> kq = kqDAO.findByIdNgCachLy(id);
        String ids=id+"";
        request.setAttribute("code", Utils.md5(ids));
        request.setAttribute("nguoi", nguoi);
        request.setAttribute("kqua", kq);
        RequestDispatcher view = request.getRequestDispatcher("../NguoiCachLy/view-detail.jsp");
        view.forward(request, response);
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
        doGet(request, response);
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
