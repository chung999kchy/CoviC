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
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Người cách ly > Xem chi tiết</span>
        <div class="spacer2"></div>
    </div>

    <div class="content-header">
        <div class="content-header__info">
            <span>Mã người cách ly: ${nguoi.getIdNguoiCachLy()}</span>
            <span>Họ và tên: ${nguoi.getTenNguoiCachLy()}</span>
        </div>
        <div class="content-header__btn"><a href="<%=request.getContextPath()%>/NguoiCachLy/discharge?id=${nguoi.getIdNguoiCachLy()}"><i class="fas fa-sign-out-alt"></i> Ra viện</a></div>
        <div>
            <button id="ma_show">Lấy mã xác nhận </button>
            <strong id="ma_show_info" style="display: none">${code}</strong>
            <script>
                $("#ma_show").click(function () {
                    $("#ma_show_info").toggle(1000);
                });
            </script>
        </div>
    </div>
    <div class="content-middle"> 
        <div class="content-middle__lylich space3">
            <span class="info-label">Lý lịch cá nhân</span>
            <ul class="info-detail">
                <li>Tuổi: ${nguoi.getTuoi()}</li>
                <li>Giới tính: ${nguoi.getGioiTinh()}</li>
                <li>Mã căn cước: ${nguoi.getCmt()}</li>
                <li>Quốc tịch: ${nguoi.getQuocTich()}</li>
                <li>Đia chỉ: ${nguoi.getDiaChi()}</li>
                <li>Số điện thoại: ${nguoi.getSoDienThoai()}</li>
            </ul>
        </div>
        <div class="content-middle__cachly ">
            <span class="info-label">Thực hiện cách ly</span>
            <ul class="info-detail">
                <li>Mức độ nghi nhiễm: ${nguoi.getMucDoNghiNhiem()}</li>
                <li>Ngày vào: ${Utils.DATE_FORMATER.format(nguoi.getTgVaoCachLy())}</li>
                <c:if test="${empty nguoi.getTgRaCachLy()}"><li>Ngày ra: Chưa xác định</li></c:if>
                <c:if test="${not empty nguoi.getTgRaCachLy()}"><li><li>Ngày ra: ${Utils.DATE_FORMATER.format(nguoi.getTgRaCachLy())}</li></li></c:if>
                <li>Số ngày thực hiện: ${Utils.getDistanceTime(nguoi.getTgVaoCachLy(), nguoi.getTgRaCachLy()) + 1}</li>
                <li>Phòng số: ${nguoi.getPhong().getTenPhong()}</li>
            </ul>
        </div>
    </div>   
    <div class="content-history">
        <span class="info-label">Lịch sử xét nghiệm</span>
        <ul class="info-detail">
            <c:if test="${empty kqua}">
                <li>Chưa tham gia lần xét nghiệm nào!</li>
                </c:if>
                <c:if test="${not empty kqua}">
                    <c:forEach var="kq" items="${kqua}">

                    <li>Lần : Ngày ${Utils.DATE_FORMATER.format(kq.getTgXetNghiem())} ---- Tên xét nghiệm: ${kq.getTenLoaiXetNghiem()} ----- Kết quả: ${kq.getKqXetNghiem()}</li>
                    </c:forEach>
                </c:if>
        </ul>


    </div>

    <div class="content-btn">
        <a href="<%=request.getContextPath()%>/NguoiCachLy/add-xetnghiem.jsp?id=${nguoi.getIdNguoiCachLy()}" style="background-color: #6FCF97"><i class="fas fa-pen"></i> Thêm xét nghiệm</a>
        <a href="<%=request.getContextPath()%>/NguoiCachLy/update.jsp?id=${nguoi.getIdNguoiCachLy()}" style="background-color: #00AAFF"><i class="fas fa-user-edit"></i> Chỉnh sửa hồ sơ</a>
        <a href="<%=request.getContextPath()%>/NguoiCachLy/delete?id=${nguoi.getIdNguoiCachLy()}" style="background-color: red;"><i class="fas fa-trash-alt"></i> Xóa</a>
    </div>
</div>