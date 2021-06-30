/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.BarcodeDAO;
import dao.KqXetNghiemDAO;
import dao.NguoiCachLyDAO;
import entity.Barcode;
import entity.KqXetNghiem;
import entity.NguoiCachLy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CHUNG
 */
public class ScanQR extends HttpServlet {

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
        String ma = request.getParameter("ma");
        NguoiCachLyDAO ngDao = new NguoiCachLyDAO();
        KqXetNghiemDAO kqDao = new KqXetNghiemDAO();
        NguoiCachLy nguoi = null;
        List<KqXetNghiem> list = null;
        BarcodeDAO barDao = new BarcodeDAO();
        Barcode barcode = barDao.findByMa(ma);
        if (barcode == null || barcode.getLan() != 0) {

        } else {
            // tang so lan cua barcode len 1
            Hashtable<String, String> my_dict = new Hashtable<>();
            my_dict.put("lan", String.valueOf(barcode.getLan() + 1));
            barDao.update(barcode, my_dict);
            barDao.deleteQRByTime(barcode.getNgCachLy().getIdNguoiCachLy());
            nguoi = ngDao.get(barcode.getNgCachLy().getIdNguoiCachLy());
            list = kqDao.findByIdNgCachLy(nguoi.getIdNguoiCachLy());
            request.setAttribute("nguoi", nguoi);
            request.setAttribute("list2", list);
            RequestDispatcher view = request.getRequestDispatcher("history.jsp");
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
