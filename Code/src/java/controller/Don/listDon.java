/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Don;

import dao.DonDAO;
import entity.Don;

import entity.KhuCachLy;
import entity.NguoiCachLy;
import entity.TaiKhoan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class listDon extends HttpServlet {

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
        int page = 1;
        int recordsPerPage = 10;
        HttpSession ss = request.getSession();
        TaiKhoan tk = (TaiKhoan) ss.getAttribute("userLogin");
        KhuCachLy khu = (KhuCachLy) ss.getAttribute("khuCachLy");

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        DonDAO dao = new DonDAO();
        List<Don> list = null;
        if (tk.getLoaiTaiKhoan().getIdLoaiTaiKhoan() != 3) {
            list = dao.getList((page - 1) * recordsPerPage, recordsPerPage, khu.getIdKhuCachLy());
            int noOfRecords = dao.getNoOfRecord(khu.getIdKhuCachLy());
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("noOfRecords", noOfRecords);
            request.setAttribute("donList", list);
            
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            RequestDispatcher view = request.getRequestDispatcher("list.jsp");
            view.forward(request, response);
        } else {
            list = dao.getListById(tk.getIdTaiKhoan(), (page - 1) * recordsPerPage, recordsPerPage);
            int noOfRecords = dao.getNoOfRecordById(tk.getIdTaiKhoan());
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("noOfRecords", noOfRecords);
            request.setAttribute("donList", list);
            
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            RequestDispatcher view = request.getRequestDispatcher("listByUser.jsp");
            view.forward(request, response);
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
