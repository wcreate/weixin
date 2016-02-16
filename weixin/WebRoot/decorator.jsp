<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
  <head>
    <title><sitemesh:write property='title'/></title>
    
    <meta charset="UTF-8">
   	<!-- 此时表示根据设备的大小调整页面的显示宽度 -->
   	<meta name="viewport" content="width=device-width,initial-scale=1">
   	<!-- bootstrap需要jquery的支持，所以要导入jquery包 -->
   	<script type="text/javascript" src="e2e/js/jquery.min.js"></script>
    <!-- bootstrap需要的一些组件 *.js -->
   	<script type="text/javascript" src="e2e/bootstrap/js/bootstrap.min.js"></script>
   	<!-- bootstrap需要的一些基础样式 *.js -->
   	<link rel="stylesheet" type="text/css" href="e2e/bootstrap/css/bootstrap.min.css">
   	
   	<!-- head front -->
    <sitemesh:write property='head'/>
    <!-- head end -->
  </head>
  <body>
    <div style="padding:20px;">
    	<a href="http://www.tengshengwei.com" class="btn btn-primary">滕声威 body 头部</a> <br/>
    </div>
    
    <sitemesh:write property='body'/> 
    
    <div style="padding:20px;">
    	<a href="http://www.tengshengwei.com" class="btn btn-primary">滕声威 body 底部</a> <br/>
    </div>
    
  </body>
</html>
