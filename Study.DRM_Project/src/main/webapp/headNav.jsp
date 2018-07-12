<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sockjs.min.js"/>"></script>
<link rel="stylesheet"	href="<c:url value="/resources/css/htmlStudyPage.css" />">
<script type="text/javascript">
    
</script>
</head>
<body style="overflow:hidden;">
 <div  class="headNav">
			<button type="button" class="homeBtn" style="border:none;background:none;float:left;" onclick="location.href='mainPageJsp'">
				<img src="<c:url value="/resources/img/myphoto.png"/>" style="width : 100px; height:60px;">
			</button>
			<input type="button" class="headNavBtn" value="서류 작성">  
			<input type="button" class="headNavBtn" value="채팅룸">
			<input type="button" class="headNavBtn" value="menu3">
			<input type="button" class="headNavBtn" value="menu4">
			<input type="button" class="headNavBtn" value="menu5">
			<input type="button" class="headNavBtn" value="menu6">
			<input type="button" class="headNavBtn" value="menu7">
	</div>
</body>
</html>


