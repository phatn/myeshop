<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<div class="welcome">
	<div class="logo"><a href="<c:url value="/"/>"><img alt="Logo" src="<c:url value="/resources/images/my-eshop.png" />"></a></div>
	<div class="logoQuote"><spring:message code="logoQuote.label" /></div>
</div>
<div class="language">
	<a href="?language=en">English</a> | <a href="?language=vn">Tiếng Việt</a>
</div>
<div class="topBarInfo">
	<span>096 347 1583</span> |
	<a href="<c:url value="/chat"/>"><spring:message code="chat.label" /></a> |
	<a href="<c:url value="/help"/>"><spring:message code="help.label" /></a>
</div>
<div class="clearfix"></div>