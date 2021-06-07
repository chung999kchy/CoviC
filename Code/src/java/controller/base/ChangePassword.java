/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import java.io.IOException;
import java.util.Hashtable;
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
public class ChangePassword extends HttpServlet {

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
        String current_pass = request.getParameter("current_pass");
        String new_pass = request.getParameter("new_pass");
        String new2_pass = request.getParameter("new2_pass");
        HttpSession session = request.getSession();
        TaiKhoan user = (TaiKhoan) session.getAttribute("userLogin");
        String current_pass_md5= md5(current_pass);
        String new_pass_md5 = md5(new_pass);
        if(current_pass_md5 == null ? user.getPassword() == null : current_pass_md5.equals(user.getPassword())){
            Hashtable<String, String>my_dict = new Hashtable<>();
            my_dict.put("password", new_pass_md5);
            TaiKhoanDAO tkDAO = new TaiKhoanDAO();
            tkDAO.update(user, my_dict);
            session.setAttribute("userLogin", tkDAO.get(user.getIdTaiKhoan()));
            
            response.sendRedirect("../logout.jsp");
        }else {
            Notification noti = new Notification("Error", "Lỗi xảy ra.<br/> Vui lòng xem lại mật khẩu của bạn", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher r1 = request.getRequestDispatcher("ChangePassword.jsp");
            r1.forward(request, response);
        }
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
