<%-- 
    Document   : list
    Created on : Apr 27, 2021, 11:12:15 PM
    Author     : CHUNG
--%>

<%@page import="dao.NguoiCachLyDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<% NguoiCachLyDAO ngDAO = new NguoiCachLyDAO();
KhuCachLy khuCachLy2 = (KhuCachLy)session.getAttribute("khuCachLy"); 
%>
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Vật tư > Phòng </span>
        <div class="spacer2"></div>
    </div>
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/Phong/add.jsp"><i class="fas fa-plus-circle"></i>
            <span>Thêm</span>
        </a>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="10%">Mã phòng</th>
                <th width="25%">Tên phòng</th>
                <th width="35%">Sức chứa</th>   
                <th width="30%">Hành động</th>
            </tr>
            <c:forEach var="phong" items="${phongList}">
                <tr>
                    <td>${phong.getIdPhong()}</td>
                    <td>${phong.getTenPhong()}</td>
                    <td>${phong.getSoGiuong()}</td>
                    <td class="td-action">
                        <a href="<%=request.getContextPath()%>/Phong/view-detail?id=${phong.getIdPhong()}"><i class="far fa-calendar-alt"></i></a>
                        <a href="<%=request.getContextPath()%>/Phong/update.jsp?id=${phong.getIdPhong()}"><i class="fas fa-pen"></i></a>
                        <a href="<%=request.getContextPath()%>/Phong/delete?id=${phong.getIdPhong()}" style="background-color: red"><i class="fas fa-trash-alt"></i></a>
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
                <a href="<%=request.getContextPath()%>/Phong/view-list?page=${currentPage - 1}"> < </a>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/Phong/view-list?page=${i}"> ${i} </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test = "${currentPage lt noOfPages}">
                <a href="<%=request.getContextPath()%>/Phong/view-list?page=${currentPage+1}"> > </a>
            </c:if>
        </div>
    </div>
</div>
