<%-- 
    Document   : view-detail
    Created on : May 6, 2021, 12:57:08 AM
    Author     : CHUNG
--%>

<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Đơn từ > Xem chi tiết đơn</span>
        <div class="spacer2"></div>
    </div>

    <div class="content-header">
        <div class="content-header__info">
            <span>Tên người gửi: ${don.getNguoiTao().getTenNguoiDung()}</span>
            <span>Loại đơn: ${don.getLoaiDon().getTenLoaiDon()}</span>
            <span style="font-size: 1.5rem;">Tới khu cách ly: ${don.getKhuCachLy().getTenKhuCachLy()}</span>
        </div>

    </div>
    <div class="content-middle"> 
        <div class="content-middle__lylich space3">
            <span class="info-label">Thông tin</span>
            <ul class="info-detail">
                <li>Kết quả xác nhận: ${don.getKqXacNhan()}</li>
                    <c:if test="${not empty ngXacNhan}">
                    <li>Người xác nhận: ${ngXacNhan.getTenNguoiDung()}</li>
                    <li>Thời gian tạo: ${Utils.DATE_FORMATER.format(don.getTgTao())} </li>
                    <li>Thời gian xác nhận: ${Utils.DATE_FORMATER.format(don.getTgXacNhan())} </li>
                    </c:if>

                <c:if test="${empty ngXacNhan}">
                    <li>Người xác nhận: Chưa rõ</li>
                    <li>Thời gian tạo: ${Utils.DATE_FORMATER.format(don.getTgTao())} </li>
                    <li>Thời gian xác nhận: Chưa rõ </li>
                    </c:if>


            </ul>
        </div>

    </div>   
    <div class="content-history">
        <span class="info-label">Nội dung đơn</span>
        <p style="font-size: 1.5rem;">${don.getNoiDung()}</p>
    </div>

    <div class="content-btn">
        <c:if test="${not empty taiKhoan}">
            <a href="<%=request.getContextPath()%>/Don/update?action=accept&id=${don.getIdDon()}" style="background-color: #00e6e6"><i class="fas fa-check"></i> Chấp nhận</a>
            <a href="<%=request.getContextPath()%>/Don/update?action=decline&id=${don.getIdDon()}" style="background-color: red"><i class="fas fa-times"></i> Từ chối</a>
        </c:if>
        <c:if test="${empty taiKhoan}">
            <a href="<%=request.getContextPath()%>/Don/update?action=cancel&id=${don.getIdDon()}" style="background-color: #001a00"><i class="fas fa-power-off"></i> Hủy đơn</a>
        </c:if>


    </div>
</div>