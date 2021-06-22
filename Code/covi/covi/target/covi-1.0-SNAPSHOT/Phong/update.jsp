<%-- 
    Document   : update
    Created on : May 8, 2021, 12:21:39 AM
    Author     : CHUNG
--%>

<%@page import="entity.Phong"%>
<%@page import="dao.PhongDAO"%>
<%-- 
    Document   : add-nguoiCachLy
    Created on : May 6, 2021, 6:24:46 PM
    Author     : CHUNG
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<%  String id = request.getParameter("id");
    int idPhong = Integer.parseInt(id);
    PhongDAO dao = new PhongDAO();
    Phong phong = dao.get(idPhong);
%>
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Vật tư > Cập nhật phòng</span>
        <div class="spacer2"></div>
    </div>


    <div class="form-container">
        <form action="update" method="POST" id="form-dn" class="form">
            <input id="idPhong" class="form-control" name="idPhong" type="text" value="<%=phong.getIdPhong()%>" style="display: none">

            <div class="form-group form-group__special">
                <label for="ten" class="form-label">Tên phòng</label>
                <input id="ten" class="form-control" name="ten" type="text" value="<%=phong.getTenPhong()%>">
                <span class="form-message"></span>
            </div>


            <div class="form-group">
                <label for="giuong" class="form-label">Số giường tối đa:</label>
                <input value = "<%=phong.getSoGiuong()%>" id="giuong" class="form-control" name="giuong" type="text" pattern="[0-9]{1,2}" title="Vui lòng nhập đúng số giường">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="ghi_chu" class="form-label">Ghi chú</label>
                <% if(phong.getGhiChu()==null){ %>
                <input id="ghi_chu" class="form-control" name="ghi_chu" type="text">
                <% } else { %>
                <input id="ghi_chu" class="form-control" name="ghi_chu" type="text" value="<%=phong.getGhiChu()%>" >
                <% } %>
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>
