/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.NguoiCachLyDAO;
import dao.TaiKhoanDAO;
import entity.NguoiCachLy;
import entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
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
public class checkAccount extends HttpServlet {

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
        String code = request.getParameter("code").trim();
        if ("".equals(code)) {
            Notification noti = new Notification("Warning", "Vui lòng điền mã code vào chỗ trống", "warning");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("checkAccount.jsp");
            rt.forward(request, response);
        } else {
            NguoiCachLyDAO dao = new NguoiCachLyDAO();
            List<NguoiCachLy> list = dao.getAll();
            boolean check = false;
            for (NguoiCachLy nguoi : list) {
                int id = nguoi.getIdNguoiCachLy();
                String ids = "" + id;
                if (Utils.md5(ids).equals(code)) {
                    check = true;
                    HttpSession ss = request.getSession();
                    TaiKhoan tk = (TaiKhoan) ss.getAttribute("userLogin");
                    int idTK = tk.getIdTaiKhoan();
                    
                    Hashtable<String, String> my_dict = new Hashtable<>();
                    my_dict.put("id_ng_cach_ly", ids);
                    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
                    tkDAO.update(tk, my_dict);
                    
                    //update seession userLogin
                    TaiKhoan tk2 = tkDAO.get(idTK);
                    System.out.println("tk moi "+ tk2.getNgCachLy().getTenNguoiCachLy());
                    ss.setAttribute("userLogin", tk2);
                    break;
                }
            }
            if (check == true) {
                Notification noti = new Notification("Success", "Bạn đã nhập mã code thành công. Giờ đây, bạn đã là một thành viên trong khu cách ly.", "success");
                request.setAttribute("notify", noti);
                RequestDispatcher rt = request.getRequestDispatcher("checkAccount.jsp");
                rt.forward(request, response);
            } else {
                Notification noti = new Notification("Error", "Mã code không đúng. Vui lòng kiểm tra lại.", "error");
                request.setAttribute("notify", noti);
                RequestDispatcher rt = request.getRequestDispatcher("checkAccount.jsp");
                rt.forward(request, response);
            }
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
