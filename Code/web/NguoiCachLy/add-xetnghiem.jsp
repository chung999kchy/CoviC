<%-- 
    Document   : add-xetnghiem
    Created on : May 8, 2021, 10:48:26 PM
    Author     : CHUNG
--%>
<%@page import="utils.Utils"%>
<%@page import="entity.NguoiCachLy"%>
<%@page import="dao.NguoiCachLyDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<%  String id = request.getParameter("id");
    int idNguoi = Integer.parseInt(id);
    NguoiCachLyDAO dao = new NguoiCachLyDAO();
    NguoiCachLy nguoi = dao.get(idNguoi);
%>
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Ngưới cách ly > Cập nhật xét nghiệm</span>
        <div class="spacer2"></div>
    </div>



    <div class="form-container">
        <form action="add-xetnghiem" method="POST" id="form-xn" class="form">
            <div class="form-header">
                <div class="content-header__info">
                    <span class="content-one">Mã người cách ly:  <%=nguoi.getIdNguoiCachLy()%></span>
                    <span class="content-two">Họ và tên: <%=nguoi.getTenNguoiCachLy()%></span>
                </div>
                <input id="id" name="id" type="text" value="<%=nguoi.getIdNguoiCachLy()%>" style="display: none">

            </div>
            <span class="form-span">Xét nghiệm</span>
            <div class="form-group">
                <label for="tg" class="form-label">Thời gian:</label>
                <input type="datetime-local" id="tg" class="form-control"
                       name="tg" value="${Utils.getToday()}"
                       min="<%=nguoi.getTgVaoCachLy()%>">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="loai_xet_nghiem" class="form-label">Loại xét nghiệm:</label>
                <input id="loai_xet_nghiem" class="form-control" name="loai_xet_nghiem" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="ket_qua" class="form-label">Kết quả</label>
                <input id="ket_qua" class="form-control" name="ket_qua" type="text" required>
                <span class="form-message"></span>
            </div>
            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>