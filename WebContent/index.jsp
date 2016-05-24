<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="./templates/main-template.jsp" >

	<tiles:putAttribute name="content">
	
		<div class="col-lg-12">
            <h1 class="page-header">Thumbnail Gallery</h1>
        </div>

        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
            <a class="thumbnail" href="#">
                <img class="img-responsive" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	
	</tiles:putAttribute>
	
</tiles:insertTemplate>