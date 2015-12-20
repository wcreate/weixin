<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
    <head>
    	<title>传统企业咨询</title>
    		   
    	<meta charset="UTF-8">
    	<!-- 此时表示根据设备的大小调整页面的显示宽度 -->
    	<meta name="viewport" content="width=device-width,initial-scale=1">
    	<!-- bootstrap需要jquery的支持，所以要导入jquery包 -->
    	<script type="text/javascript" src="${ctx }/e2e/js/jquery.min.js"></script>
    	<script type="text/javascript" src="${ctx }/e2e/js/jqBootstrapValidation.js"></script>
        <!-- bootstrap需要的一些组件 *.js -->
    	<script type="text/javascript" src="${ctx }/e2e/bootstrap/js/bootstrap.min.js"></script>
    	<!-- bootstrap需要的一些基础样式 *.js -->
    	<link rel="stylesheet" type="text/css" href="${ctx }/e2e/bootstrap/css/bootstrap.min.css">
    </head>
    <body>
    	<!-- 此处进行所有代码的编写 -->
        <form action="${ctx }/tblConsult/companyConsult.html" method="post">
          <div class="form-group">
            <label>公司名称</label>
            <input type="text" class="form-control" name="companyName" id="companyName" required >
          </div>
          <div class="form-group">
            <label>主营业务</label>
            <textarea type="" class="form-control" name="mainBusiness" id="mainBusiness" required ></textarea>
          </div>
          <div class="form-group">
            <label>咨询问题</label>
            <textarea type="" class="form-control" name="consultProblem" id="consultProblem" required ></textarea>
          </div>
          <div class="form-group">
            <label>联系方式</label>
            <input type="text" class="form-control" name="contactInformation" id="contactInformation" placeholder="联系人、电话" required >
          </div>
          <button type="submit" class="btn btn-default btn-lg btn-block" onclick="return checkForm()">确定</button>
        </form>
    </body>
    <script type="text/javascript">
        
        $(function () { $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); } );
    
    </script>
</html>
