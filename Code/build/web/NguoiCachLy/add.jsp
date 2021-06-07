<%-- 
    Document   : add-nguoiCachLy
    Created on : May 6, 2021, 6:24:46 PM
    Author     : CHUNG
--%>
<%@page import="entity.Phong"%>
<%@page import="java.util.List"%>
<%@page import="dao.PhongDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Ngưới cách ly > Thêm người cách ly</span>
        <div class="spacer2"></div>
    </div>

    <% 
    HttpSession ss = request.getSession();
    KhuCachLy khu = (KhuCachLy)ss.getAttribute("khuCachLy");
    PhongDAO phongDAO = new PhongDAO();
    List<Phong> phongs = phongDAO.getAllInKhu(khu.getIdKhuCachLy());
    %>

    <div class="form-container">
        <form action="add" method="POST" id="form-dn" class="form">
            <div class="form-header">
                <div class="form-group form-group__special">
                    <label for="ho_ten" class="form-label">Họ và tên:</label>
                    <input id="ho_ten" class="form-control" name="ho_ten" type="text" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phan_loai" class="form-label">Phân loại:</label>
                    <select name="phan_loai" id="phan_loai">
                        <option value="F1">F1</option>
                        <option value="F2">F2</option>
                        <option value="F3">F3</option>
                        <option value="F4" selected="selected">F4</option>
                    </select>
                </div>
            </div>
            <span class="form-span">Lý lịch cá nhân</span>
            <div class="form-group">
                <label for="tuoi" class="form-label">Tuổi:</label>
                <input id="tuoi" class="form-control" name="tuoi" type="text" pattern="[0-9]{1,2}" title="Vui lòng nhập đúng số tuổi">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="gioi_tinh" class="form-label">Giới tính:</label>
                <select name="gioi_tinh" id="gioi_tinh" class="form-control">
                    <option value="Nam" selected="selected">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ma_can_cuoc" class="form-label">Mã căn cước:</label>
                <input id="ma_can_cuoc" class="form-control" name="ma_can_cuoc" type="text" >
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="quoc_tich" class="form-label">Quốc tịch:</label>
                <input id="quoc_tich" class="form-control" name="quoc_tich" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="dia_chi" class="form-label">Địa chỉ:</label>
                <input id="dia_chi" class="form-control" name="dia_chi" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="so_dien_thoai" class="form-label">Số điện thoại:</label>
                <input id="so_dien_thoai" class="form-control" name="so_dien_thoai" type="text" pattern="[0-9]{8,11}" title="Vui lòng nhập đúng số điện thoại">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="phong" class="form-label">Xếp vào phòng số</label>
                <select name="phong" id="phong" class="form-control" required>
                    <% for(Phong phong : phongs){ %>
                    <option value="<%=phong.getIdPhong()%>"><%=phong.getTenPhong()%></option>
                    <% } %>
                </select>
            </div>
            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>
