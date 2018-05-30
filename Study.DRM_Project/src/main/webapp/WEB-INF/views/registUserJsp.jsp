<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.form.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.jqplot.min.js" />"></script>
<link class="include" rel="stylesheet" type="text/css" href="<c:url value="jquery.jqplot.min.css" />" />
<link rel="stylesheet"	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet"	href="<c:url value="/resources/css/htmlStudyPage.css" />">
<meta name="viewport" content="initial-scale=1, width=device-width"/> 

	<title>Home</title>
</head>
<body>
	<div class="page">
	<div  class="headNav">
			<button type="button" class="homeBtn" style="border:none;background:none;float:left;" onclick="location.href='mainPageJsp'">
				<img src="<c:url value="/resources/img/myphoto.png"/>" style="width : 100px; height:60px;">
			</button>
			<input type="button" class="headNavBtn" value="서류 작성">  
			<input type="button" class="headNavBtn" value="menu2">
			<input type="button" class="headNavBtn" value="menu3">
			<input type="button" class="headNavBtn" value="menu4">
			<input type="button" class="headNavBtn" value="menu5">
			<input type="button" class="headNavBtn" value="menu6">
			<input type="button" class="headNavBtn" value="menu7">
	</div>
	<!-- <div style="background: rgba(155,25,275,0.2); width : 100%; text-align: center;" >
		<h1>page Head</h1>
	</div> -->
<div class="contentDiv" style="width: 100%;height:80%;overflow:unset;">
	<div class ="mainContentDiv" style="text-align:center;">
			<h1>회원가입</h1>
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</div>
</div>

</body>
<script>
</script>
</html>
