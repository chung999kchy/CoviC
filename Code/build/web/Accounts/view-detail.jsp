<%-- 
    Document   : view-detail
    Created on : May 8, 2021, 11:38:08 PM
    Author     : CHUNG
--%>

<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản > Xem chi tiết</span>
        <div class="spacer2"></div>
    </div>
    <div class="content-body">
        <div>
            <div class="content-header__info content-header__account">
                <span>Mã tài khoản: ${account.getIdTaiKhoan()}</span>
                <span>Họ và tên: ${account.getTenNguoiDung()}</span>
            </div>

            <div class="content-middle"> 
                <div class="content-middle__lylich">
                    <span class="info-label">Lý lịch cá nhân</span>
                    <ul class="info-detail">
                        <li>Số điện thoại: ${account.getSoDienThoai()}</li>
                        <li>Loại tài khoản: ${account.getLoaiTaiKhoan().getTenLoaiTaiKhoan()}
                    </ul>
                </div>
            </div>
        </div>
        <div><img class="content-img" src="<%=request.getContextPath()%>/${initParam.imgPath}${account.getAvatar()}"/></div>
    </div>

    <div class="content-btn">

        <a href="<%=request.getContextPath()%>/NguoiCachLy/delete?id=${nguoi.getIdNguoiCachLy()}" style="background-color: red;">
            <i class="fas fa-trash-alt"></i> Xóa
        </a>
    </div>
</div>
