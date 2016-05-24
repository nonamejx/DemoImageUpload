<%@page import="com.demoupload.bean.Image"%>
<%@page import="com.demoupload.service.ImageService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="./templates/main-template.jsp" >

	<tiles:putAttribute name="content">
	
		<div class="col-lg-12">
            <h1 class="page-header">Vietnam Travel Gallery</h1>
        </div>
		
		<%
		ImageService imgService = new ImageService();
		ArrayList<Image> images = imgService.getImages();
		
		if (images != null && images.size() > 0) {
			for (Image img : images) {	
		
		%>

        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
            <a class="thumbnail" href="#">
            	<!-- http://placehold.it/400x300 -->
                <img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/<%=img.getName() %>" alt="<%=img.getDescription()%>">
            </a>
        </div>
        
        <%
			}} else {
        %>
        <div class="col-md-12"> Hiện tại chưa có dữ liệu </div>
        <%
			}
        %>
        
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	
	</tiles:putAttribute>
	
</tiles:insertTemplate>