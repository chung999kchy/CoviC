/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nguoiCachLy;

import dao.NguoiCachLyDAO;
import entity.NguoiCachLy;
import entity.Phong;
import java.io.IOException;
import java.util.Hashtable;
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
public class updateNgCachLy extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Hashtable<String, String> my_dict = new Hashtable<>();
        NguoiCachLyDAO dao = new NguoiCachLyDAO();
        NguoiCachLy nguoi = dao.get(Integer.parseInt(request.getParameter("idNguoi")));

        //check tung thuoc tinh xem co thay doi khong
        
        if(!request.getParameter("ho_ten").equals(nguoi.getTenNguoiCachLy())){
            my_dict.put("ten_nguoi_cach_ly", request.getParameter("ho_ten"));
        }
        if(!request.getParameter("phan_loai").equals(nguoi.getMucDoNghiNhiem())){
            my_dict.put("muc_do_nghi_nhiem", request.getParameter("phan_loai"));
        }
        if(Integer.parseInt(request.getParameter("tuoi")) != nguoi.getTuoi()){
            my_dict.put("tuoi", request.getParameter("tuoi"));
        }
        if(!request.getParameter("gioi_tinh").equals(nguoi.getGioiTinh())){
            my_dict.put("gioi_tinh", request.getParameter("gioi_tinh"));
        }
        if(!request.getParameter("ma_can_cuoc").equals(nguoi.getCmt())){
            my_dict.put("cmt", request.getParameter("ma_can_cuoc"));
        }
        if(!request.getParameter("quoc_tich").equals(nguoi.getQuocTich())){
            my_dict.put("quoc_tich", request.getParameter("quoc_tich"));
        }
        if(!request.getParameter("dia_chi").equals(nguoi.getDiaChi())){
            my_dict.put("dia_chi", request.getParameter("dia_chi"));
        }
        if(Integer.parseInt(request.getParameter("so_dien_thoai")) != nguoi.getSoDienThoai()){
            my_dict.put("so_dien_thoai", request.getParameter("so_dien_thoai"));
        }
        if(Integer.parseInt(request.getParameter("phong")) != nguoi.getPhong().getIdPhong()){
            my_dict.put("id_phong", request.getParameter("phong"));
        }
        
        //update
        dao.update(nguoi, my_dict);
        Notification noti = new Notification("Success", "Cập nhật thành công", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-detail?id="+request.getParameter("idNguoi"));
        r1.forward(request, response);
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
