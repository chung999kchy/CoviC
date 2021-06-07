<%-- 
    Document   : login
    Created on : Apr 13, 2021, 11:25:54 AM
    Author     : CHUNG
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="<%=request.getContextPath()%>/assets/css/form.css" rel="stylesheet">

<div class="form-container">
    <form action="LoginServlet" method="POST" id="form-dn" class="form">
        <h3 class="heading">Đăng nhập</h3>
        <p class="desc">Đăng nhập để trải nghiệm toàn bộ tiện ích nào</p>

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

        <button class="form-submit">Đăng nhập</button>
    </form>
</div>

<script src="assets/js/validator.js"></script>
<script>
    Validator({
        form: "#form-dn",
        errorSelector: '.form-message',
        rules: [
            Validator.isRequired("#ten_dang_nhap"),
            Validator.minLength("#password", 6),
        ]
    });
</script>
