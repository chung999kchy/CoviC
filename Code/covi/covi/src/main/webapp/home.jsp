<%-- 
    Document   : home
    Created on : Apr 15, 2021, 10:01:43 PM
    Author     : CHUNG
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/base/home.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Bảng điều khiển </span>
        <div class="spacer2"></div>
    </div>
    <div class="report">
        <div class="report__table">
            <label>Số lượng người cách ly mới</label>
            <div>
                <img class="bieudo" src="<%=request.getContextPath()%>/assets/img/thumb/bieudo.jpg" />
            </div>
        </div>
        <div class="report__info">
            <div class="report__info-class report__info-class__blue">
                <label class="report-label"><i class="fas fa-user"></i> Người cách ly</label>
                <ul class="report-label__info">
                    <li>Hôm nay <span>${countNgCachLyToday}</span></li>
                    <li>Tháng này <span>${countNgCachLyThisMonth}</span></li>
                </ul>
            </div>
            
            <div class="report__info-class report__info-class__green">
                <label class="report-label"><i class="fas fa-envelope"></i> Đơn từ</label>
                <ul class="report-label__info">
                    <li>Hôm nay <span>${countDonToday}</span></li>
                    <li>Tháng này <span>${countDonThisMonth}</span></li>
                </ul>
            </div>
            
            <div class="report__info-class report__info-class__orange">
                <label class="report-label"><i class="fas fa-bed"></i> Sức chứa</label>
                <ul class="report-label__info">
                    <li>Hiện tại <span>${countNgCachLyNotOut}</span></li>
                    <li>Còn trống <span>${countInclude - countNgCachLyNotOut}</span></li>
                    <li>Tổng <span>${countInclude}</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>

