<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/jsp/base/taglibs.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Runner</title>

</head>
<body>
</body>
<%@include file="/WEB-INF/jsp/base/baselib.jspf" %>
<script type="text/javascript" src="${ctx }/resources/js/login/login.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/login/loginitem.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/login/loginlabel.js"></script>
<script type="text/javascript"> 
	Ext.onReady(function () {
		Ext.QuickTips.init();
		runner.login.initLoginPanel();
	});
</script>
</html>