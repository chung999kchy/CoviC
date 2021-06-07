<%-- 
    Document   : register
    Created on : Apr 14, 2021, 10:17:37 PM
    Author     : CHUNG
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="<%=request.getContextPath()%>/assets/css/form.css" rel="stylesheet">

<div class="form-container">
    <form action="RegisterServlet" method="POST" id="form-dk" class="form">
        <h3 class="heading">Đăng ký</h3>
        <p class="desc">Đăng ký ngay nào bạn ơi</p>

        <div class="spacer"></div>

        <div class="form-group">
            <label for="ten_dang_nhap" class="form-label">Tên đăng nhập</label>
            <input id="ten_dang_nhap" class="form-control" name="ten_dang_nhap" type="text" placeholder="VD: Chung123">
            <span class="form-message"></span>
        </div>

        <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" class="form-control" name="password" type="password" placeholder="VD: Chung123">
            <span class="form-message"></span>
        </div>
        
        <div class="form-group">
            <label for="fullname" class="form-label">Họ và tên chủ tài khoản</label>
            <input id="fullname" class="form-control" name="fullname" type="text" placeholder="VD: Chung123">
            <span class="form-message"></span>
        </div>
        
        <div class="form-group">
            <label for="phone" class="form-label">Số điện thoại của bạn</label>
            <input id="phone" class="form-control" name="phone" type="text" placeholder="VD: 0123456789">
            <span class="form-message"></span>
        </div>

        <button class="form-submit">Đăng ký</button>
    </form>
</div>

<script src="<%=request.getContextPath()%>/assets/js/validator.js"></script>
<script>
    Validator({
        form: "#form-dk",
        errorSelector: '.form-message',
        rules: [
            Validator.isRequired("#ten_dang_nhap"),
            Validator.minLength("#password", 6),
            Validator.isPhone("#phone"),
            Validator.isRequired("#fullname"),
        ]
    });
</script>
