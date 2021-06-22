/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.DonDAO;
import dao.NguoiCachLyDAO;
import dao.PhongDAO;
import dao.TaiKhoanDAO;
import entity.KhuCachLy;
import entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;
import static utils.Utils.md5;

/**
 *
 * @author CHUNG
 */
public class home extends HttpServlet {

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
        HttpSession ss = request.getSession();
        TaiKhoan user = (TaiKhoan)ss.getAttribute("userLogin");
        int idKhu = 1;
        try {
            idKhu = user.getKhuCachLy().getIdKhuCachLy();
        }catch(Exception e){}
        
        //phan nay cho thong ke va bao cao
        //nguoi cach ly
        NguoiCachLyDAO ngDAO = new NguoiCachLyDAO();
        int countNgCachLyToday = ngDAO.getCountToday(idKhu);
        int countNgCachLyThisMonth = ngDAO.getCountThisMonth(idKhu);
        request.setAttribute("countNgCachLyToday", countNgCachLyToday);
        request.setAttribute("countNgCachLyThisMonth", countNgCachLyThisMonth);
        
        //don tu
        DonDAO donDAO = new DonDAO();
        int countDonToday = donDAO.getCountToday(idKhu);
        int countDonThisMonth = donDAO.getCountThisMonth(idKhu);
        request.setAttribute("countDonToday", countDonToday);
        request.setAttribute("countDonThisMonth", countDonThisMonth);
        
        //suc chua
        PhongDAO phongDAO = new PhongDAO();
        int countNgCachLyNotOut = ngDAO.getCountNotOut(idKhu);
        
        int countInclude = phongDAO.getCountInclude(idKhu);
        request.setAttribute("countNgCachLyNotOut", countNgCachLyNotOut);
        request.setAttribute("countInclude", countInclude);
        
        Notification noti = null;
        RequestDispatcher rt = null;
        int id = user.getLoaiTaiKhoan().getIdLoaiTaiKhoan();
        switch (id){
            case 1: //manager 
                noti = new Notification("Success", "Chào mừng bạn đến với hệ thống với vai trò là Manager", "success");
                request.setAttribute("notify", noti);
                rt = request.getRequestDispatcher("home.jsp");
                rt.forward(request, response);
                break;
            case 2: // staff
                noti = new Notification("Success", "Chào mừng bạn đến với hệ thống với vai trò là Staff", "success");
                request.setAttribute("notify", noti);
                rt = request.getRequestDispatcher("home.jsp");
                rt.forward(request, response);
                break;
            case 3: // user
                noti = new Notification("Success", "Chào mừng bạn đến với hệ thống của chúng tôi", "success");
                request.setAttribute("notify", noti);
                rt = request.getRequestDispatcher("home.jsp");
                rt.forward(request, response);
                break;
            case 4:
                noti = new Notification("Success", "Chào mừng bạn đến với hệ thống với vai trò là Admin", "success");
                request.setAttribute("notify", noti);
                rt = request.getRequestDispatcher("home.jsp");
                rt.forward(request, response);
                break;
            default :
                
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
