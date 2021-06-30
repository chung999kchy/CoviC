/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.accountManager;

import dao.TaiKhoanDAO;
import entity.KhuCachLy;

import entity.TaiKhoan;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CHUNG
 */
public class viewAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int page = 1;
        int recordsPerPage = 10;
        HttpSession ss = request.getSession();
        KhuCachLy khu = (KhuCachLy)ss.getAttribute("khuCachLy");
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        TaiKhoanDAO dao = new TaiKhoanDAO();
        
        List<TaiKhoan> list = dao.getList((page - 1) * recordsPerPage, recordsPerPage, khu.getIdKhuCachLy());
        int noOfRecords = 0;
        try {
            noOfRecords = dao.getNoOfRecord(khu.getIdKhuCachLy());
        } catch (SQLException ex) {
            Logger.getLogger(viewAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfRecords", noOfRecords);
        request.setAttribute("accountList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("../Accounts/list.jsp");
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
