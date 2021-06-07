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
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Vật tư > Xem chi tiết phòng</span>
        <div class="spacer2"></div>
    </div>

    <div class="content-header">
        <div class="content-header__info">
            <span>Mã phòng: ${phong.getIdPhong()}</span>
            <span>Tên phòng: ${phong.getTenPhong()}</span>
        </div>
        
    </div>
    <div class="content-middle"> 
        <div class="content-middle__lylich space3">
            <span class="info-label">Thông tin</span>
            <ul class="info-detail">
                <li>Số giường tối đa: ${phong.getSoGiuong()}</li>
                <li>Số bệnh nhân hiện có: ${nguoiCachLys.size()}</li>
                <li>Ghi chú: ${phong.getGhiChu()}</li>
                
            </ul>
        </div>
        
    </div>   
    <div class="content-history">
        <span class="info-label">Bệnh nhân hiện có</span>
        <ul class="info-detail">
            <c:if test="${empty nguoiCachLys}">
                <li>Phòng trống!</li>
                </c:if>
                <c:if test="${not empty nguoiCachLys}">
                <style>
                    .info-detail li a:hover {
                        text-decoration: none;
                        opacity: 80%;
                    }
                </style>
                    <c:forEach var="nguoi" items="${nguoiCachLys}">
                        
                    <li><a href="<%=request.getContextPath()%>/NguoiCachLy/view-detail?id=${nguoi.getIdNguoiCachLy()}" style="color: var(--text-color)">
                            Bệnh nhân số ${nguoi.getIdNguoiCachLy()} : ${nguoi.getTenNguoiCachLy()}   -------  Tình trạng: ${nguoi.getMucDoNghiNhiem()}
                        </a></li>
                    </c:forEach>
                </c:if>
        </ul>
    </div>

    <div class="content-btn">
        
        <a href="<%=request.getContextPath()%>/Phong/update.jsp?id=${phong.getIdPhong()}" style="background-color: #00AAFF"><i class="fas fa-user-edit"></i> Cập nhật phòng</a>
        <a href="<%=request.getContextPath()%>/Phong/delete?id=${phong.getIdPhong()}" style="background-color: red;"><i class="fas fa-trash-alt"></i> Xóa</a>
    </div>
</div>