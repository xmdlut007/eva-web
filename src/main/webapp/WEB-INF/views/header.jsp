<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 前端调试开关，调试请取消注释
<%
  String uri = request.getRequestURI();
  pageContext.setAttribute("uri", uri, pageContext.REQUEST_SCOPE);
%>
<jsp:include page="/testData/common.jsp" />
 --%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%-- <script type="text/javascript" src="<%=basePath %>assets/js/jquery-3.1.0.min.js"></script>
 --%>
<script type="text/javascript" src="/assets/js/jquery-3.1.0.min.js"></script>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<script src="/assets/js/bootstrap.min.js"></script>
<base href="<%=request.getScheme()%>://<%=request.getServerName()%>" />