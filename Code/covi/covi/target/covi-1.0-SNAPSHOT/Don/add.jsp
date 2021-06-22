<%-- 
    Document   : add-nguoiCachLy
    Created on : May 6, 2021, 6:24:46 PM
    Author     : CHUNG
--%>
<%@page import="dao.KhuCachLyDAO"%>
<%@page import="entity.LoaiDon"%>
<%@page import="java.util.List"%>
<%@page import="dao.LoaiDonDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Đơn từ > Tạo đơn từ</span>
        <div class="spacer2"></div>
    </div>


    <div class="form-container">
        <form action="add" method="POST" id="form-dn" class="form">

            <div class="form-group">
                <label for="loai_don" class="form-label">Loại đơn:</label>
                <select name="loai_don" id="loai_don" class="form-control">
                    <% LoaiDonDAO loaiDonDAO = new LoaiDonDAO();
                        List<LoaiDon> listLoaiDon = loaiDonDAO.getAll();
                        for (LoaiDon loai : listLoaiDon) {%>
                    <option value="<%=loai.getIdLoaiDon()%>"><%=loai.getTenLoaiDon()%></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="khu_cach_ly" class="form-label">Gửi đến khu cách ly:</label>
                <select name="khu_cach_ly" id="khu_cach_ly" class="form-control">
                    <% KhuCachLyDAO khuCachLyDAO = new KhuCachLyDAO();
                        List<KhuCachLy> listKhuCachLy = khuCachLyDAO.getAll();
                        for (KhuCachLy khu : listKhuCachLy) {%>
                    <option value="<%=khu.getIdKhuCachLy()%>"><%=khu.getTenKhuCachLy()%></option>
                    <% }%>
                </select>
            </div>

            <div class="form-group">
                <label for="noi_dung" class="form-label">Nội dung</label>
                <textarea id="noi_dung" class="form-control" name="noi_dung" type="text" ></textarea>
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>

    </div>
</div>