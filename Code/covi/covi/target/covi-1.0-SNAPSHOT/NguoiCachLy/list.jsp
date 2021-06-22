<%-- 
    Document   : list
    Created on : Apr 27, 2021, 11:12:15 PM
    Author     : CHUNG
--%>
<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Người cách ly </span>
        <div class="spacer2"></div>
    </div>
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/NguoiCachLy/add.jsp"><i class="fas fa-plus-circle"></i>
            <span>Thêm</span>
        </a>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="7%">Mã BN</th>
                <th width="23%">Họ tên</th>
                <th width="7%">Tuổi</th>
                <th width="7%">Phòng</th>
                <th width="16%">Cách ly</th>
                <th width="20%">Mức độ nghi nhiễm</th>
                <th width="20%">Hành động</th>
            </tr>
            <c:forEach var="nguoiCachly" items="${ngCachLyList}">
                <tr>
                    <td>${nguoiCachly.getIdNguoiCachLy()}</td>
                    <td>${nguoiCachly.getTenNguoiCachLy()}</td>
                    <td>${nguoiCachly.getTuoi()}</td>
                    <td>${nguoiCachly.getPhong().getTenPhong()}</td>
                <c:if test="${empty nguoiCachly.getTgRaCachLy()}"><td>${Utils.getDistanceTime(nguoiCachly.getTgVaoCachLy(), nguoiCachly.getTgRaCachLy()) + 1} ngày</td></c:if>
                <c:if test="${not empty nguoiCachly.getTgRaCachLy()}"><td style="color: red; font-weight: 500;">Đã ra</td></c:if>
                <td data-filetype="${nguoiCachly.getMucDoNghiNhiem()}">${nguoiCachly.getMucDoNghiNhiem()}</td>
                <td class="td-action">
                    <a href="<%=request.getContextPath()%>/NguoiCachLy/view-detail?id=${nguoiCachly.getIdNguoiCachLy()}"><i class="far fa-calendar-alt"></i></a>
                    <a href="<%=request.getContextPath()%>/NguoiCachLy/update.jsp?id=${nguoiCachly.getIdNguoiCachLy()}"><i class="fas fa-pen"></i></a>
                    <a href="<%=request.getContextPath()%>/NguoiCachLy/delete?id=${nguoiCachly.getIdNguoiCachLy()}" style="background-color: red"><i class="fas fa-trash-alt"></i></a>
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
                <a href="<%=request.getContextPath()%>/NguoiCachLy/view-list?page=${currentPage - 1}"> < </a>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/NguoiCachLy/view-list?page=${i}"> ${i} </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test = "${currentPage lt noOfPages}">
                <a href="<%=request.getContextPath()%>/NguoiCachLy/view-list?page=${currentPage+1}"> > </a>
            </c:if>
        </div>
    </div>
</div>

<script>
    $('td[data-filetype="F1"]').css({'color': 'red', 'font-weight': '500'});
    $('td[data-filetype="F2"]').css({'color': '#FFC806', 'font-weight': '500'});
    $('td[data-filetype="F3"]').css({'color': 'blue', 'font-weight': '500'});
    $('td[data-filetype="F4"]').css({'color': 'black', 'font-weight': '500'});
</script>
