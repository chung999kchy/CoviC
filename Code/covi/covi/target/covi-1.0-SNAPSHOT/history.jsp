<%-- 
    Document   : history
    Created on : May 14, 2021, 3:03:42 AM
    Author     : CHUNG
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/assets/css/accountDetail.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/list/list.css" rel="stylesheet">
<div class="user-container">
    <c:if test = "${not empty userLogin}">
        <div class="menu">
            <ul>
                <li><div><img class="menu-img" src="<%=request.getContextPath()%>/${initParam.imgPath}${userLogin.getAvatar()}"/></div>
                    <div style="margin-left: 24px;"><h3>${userLogin.getTenDangNhap()}</h3>
                        <a href=""><i class="fas fa-pen"></i>Sửa hồ sơ</a>
                    </div>
                <li class="spacer"></li>

                <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/accountDetail.jsp" class="menu-item"><i class="far fa-user-circle"></i> Tài khoản của tôi</a></li>
                <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/accountDetail.jsp" class="menu-item depend"> Hồ sơ</a></li>
                <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/ChangePassword.jsp" class="menu-item depend"> Đổi mật khẩu</a></li>
                <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/checkAccount.jsp" class="menu-item active"><i class="fas fa-user-check"></i> Xác minh thuộc khu cách ly</a></li>
                <li class="menu-li"><a href="<%=request.getContextPath()%>/Don/view-list" class="menu-item"><i class="far fa-check-circle"></i> Đơn của tôi</a></li>
            </ul>
        </div>
    </c:if>
    <div class="menu-detail">
        <h1 style="color: black">${nguoi.getTenNguoiCachLy()}</h1>
        <h2>${nguoi.getMucDoNghiNhiem()}</h2>
        <div class="table-list">
            <table class="table-list__user">
                <tr>
                    <th width="40%">Đơn vị</th>
                    <th width="30%">Thời gian</th>
                    <th width="30%">Kết quả</th>   
                </tr>
                <c:forEach var="kq" items="${list2}">
                    <tr>
                        <td>${kq.getTenLoaiXetNghiem()}</td>
                        <td>${kq.getTgXetNghiem()}</td>
                        <td>${kq.getKqXetNghiem()}</td>
                    </tr>

                    <tr>
                        <td>Trung tâm cách ly Đống Đa</td>
                        <td>2021/05/10 12:13:14</td>
                        <td>Sức khỏe tốt</td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
</div>