<%-- 
    Document   : checkAccount
    Created on : May 11, 2021, 11:53:25 PM
    Author     : CHUNG
--%>
<%@page import="entity.NguoiCachLy"%>
<%@page import="utils.QR_CODE"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/assets/css/accountDetail.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/assets/js/qrcode.min.js"></script>
<div class=" user-container ">
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
        <h3 class="heading">Xác minh thuộc khu cách ly</h3>
        <p class="desc">Xác minh danh tính của bạn để biết thật nhiều thông tin hữu ích</p>
        <div class="spacer"></div>
        <div class="menu-check">
            <div class="menu-check__info"><i class="far fa-question-circle"></i>
                Xác minh danh tính của bạn hiện có trong khu cách ly, giúp bạn có thể xem được những thông tin bổ ích liên quan đến bản thân, tình hình sức khỏe và các thông tin liên quan
            </div>
            <c:if test="${empty userLogin.getNgCachLy()}">
                <form action="checkAccount" method="POST" id="form-user" class="form-user">
                    <label>Nếu chưa có mã xác nhận, vui lòng liên hệ với nhân viên y tế trong khu cách ly của bạn</label>
                    <div class="form-group">
                        <label id="form-info__check" for="code" class="form-label">Mã xác nhận</label>
                        <input id="code" class="form-control" name="code" type="text" >
                        <span class="form-message"></span>
                    </div>
                    <button class="form-submit" type="submit">Xác nhận</button>
                </form>
            </c:if>

            <c:if test="${not empty userLogin.getNgCachLy()}">
                <span>Bạn đã xác minh tài khoản rồi! </span>
                <a href ="<%=request.getContextPath()%>/history?id=${userLogin.getNgCachLy().getIdNguoiCachLy()}">Xem thông tin của bạn</a>
                <br/><button id="ma_show2">Mã barcode chia sẻ cho bạn bè</button>
                <%
                    TaiKhoan tk = (TaiKhoan) session.getAttribute("userLogin");
                    NguoiCachLy nguoi2 = tk.getNgCachLy();
                    QR_CODE code = new QR_CODE();
                    String link = code.addQR_CODE(nguoi2);
                %>
                <br/>
                <br/>
                <div id="id_qrcode" style="display: none;"></div>
                <script>
                    var qrcode = new QRCode("id_qrcode", {
                        text: "<%=link%>",
                        width: 150,
                        height: 150,
                        colorDark: "#000000",
                        colorLight: "#ffffff",
                        correctLevel: QRCode.CorrectLevel.H
                    });
                    $("#ma_show2").click(function () {
                        $("#id_qrcode").toggle(1000);
                    });
                </script>
            </c:if>
        </div>
    </div>
</div>
