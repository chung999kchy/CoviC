<%-- 
    Document   : list
    Created on : Apr 27, 2021, 11:12:15 PM
    Author     : CHUNG
--%>


<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Đơn từ > Danh sách </span>
        <div class="spacer2"></div>
    </div>

    <div style="display: block; margin-bottom: 15px"></div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="7%">Mã đơn</th>
                <th width="25%">Loại đơn</th>
                <th width="23%">Tên người gửi</th>
                <th width="20%">Ngày gửi</th>
                <th width="10%">Kết quả</th>
                <th width="15%">Hành động</th>
            </tr>
            <c:forEach var="don" items="${donList}">
                <tr>
                    <td>${don.getIdDon()}</td>
                    <td>${don.getLoaiDon().getTenLoaiDon()}</td>
                    <td>${don.getNguoiTao().getTenNguoiDung()}</td>
                    <td>${don.getTgTao()}</td>
                    <c:if test="${empty don.getKqXacNhan()}">
                        <td>Chưa có</td>
                    </c:if>
                    <c:if test="${not empty don.getKqXacNhan()}">
                        <td>${don.getKqXacNhan()}</td>
                    </c:if>
                    <td class="td-action">
                        <a href="<%=request.getContextPath()%>/Don/view-detail?id=${don.getIdDon()}"><i class="far fa-calendar-alt"></i></a>   
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="content-pad">
        <c:if test="${currentPage * 10 > noOfRecords}">
            <div class="content-pad__label">Showing ${(currentPage-1)*10+1} to ${noOfRecords} of ${noOfRecords} entries</div>
        </c:if>
        <c:if test="${currentPage * 10 <= noOfRecords}">
            <div class="content-pad__label">Showing ${(currentPage-1)*10+1} to ${currentPage * 10} of ${noOfRecords} entries</div>
        </c:if>

        <div class="content-pad__info">
            <c:if test="${currentPage != 1}">
                <a href="<%=request.getContextPath()%>/Don/view-list?page=${currentPage - 1}"> < </a>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/Don/view-list?page=${i}"> ${i} </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test = "${currentPage lt noOfPages}">
                <a href="<%=request.getContextPath()%>/Don/view-list?page=${currentPage+1}"> > </a>
            </c:if>
        </div>
    </div>
</div>
