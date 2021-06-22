/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Don;

import dao.DonDAO;
import entity.Don;
import entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
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
public class updateDon extends HttpServlet {

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
        int id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String action = request.getParameter("action");
        System.out.println(action);
        Hashtable<String, String> my_dict = new Hashtable<>();
        HttpSession ss = request.getSession();
        TaiKhoan tk = (TaiKhoan) ss.getAttribute("userLogin");
        System.out.println(tk.getTenDangNhap());
        DonDAO dao = new DonDAO();
        Don don = dao.get(id);
        System.out.println("id la" + don.getIdNguoiXacNhan());
        if (don.getIdNguoiXacNhan() != null && don.getIdNguoiXacNhan() != 0) {
            System.out.println("vao null");
            Notification noti = new Notification("Warning", "Đơn này đã được xử lý. Bạn không thể xử lý được nữa.", "warning");
            request.setAttribute("notify", noti);
        } else {
            Notification noti = null;
            my_dict.put("id_nguoi_xac_nhan", tk.getIdTaiKhoan().toString());
            my_dict.put("tg_xac_nhan", Utils.getToday());
            switch (action) {
                case "accept":
                    my_dict.put("kq_xac_nhan", "Chấp nhận");
                    noti = new Notification("Success", "Đơn này đã được chấp nhận thành công", "success");
                    break;
                case "decline":
                    my_dict.put("kq_xac_nhan", "Từ chối");
                    noti = new Notification("Success", "Đơn này đã được từ chối thành công", "success");
                    break;
                case "cancel":
                    my_dict.put("kq_xac_nhan", "Hủy bỏ");
                    noti = new Notification("Success", "Đơn này đã được hủy bỏ thành công", "success");
                    break;
            }
            System.out.println("khong vao null");
            dao.update(don, my_dict);
            request.setAttribute("notify", noti);

        }
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
