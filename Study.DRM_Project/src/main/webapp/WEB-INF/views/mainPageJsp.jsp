<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.form.min.js" />"></script>
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
<div class="contentDiv" style="width: 100%;">
<div class ="mainContentDiv">
	<ul class ="mainContentUl ">
	<li class="mainContentLi firstMainContetLi">
	
		<div class="loginDiv" style="font-size:0px;">
		<h1>로그인</h1>
		<hr>
		<div >
		<p>12ed12d</p>
		</div>
		<div>
		<div>
		<input type="text" class ="loginText" style="margin-top:20px;" placeholder="아이디"/>
		<input type="button" class="loginBtn" style="margin-top:20px;" value = "login">
		<br />
		<input type="password" class ="loginText" style="margin-bottom:20px;margin-top:10px" placeholder="패스워드"/>
		<br />
		<div style="font-size:15px;text-align:right;">
		<input type="checkbox">아이디 저장
		</div>
		</div>
		<div class="loginBtnDiv">
		<hr class="loginBtnHr">
		<div style="border-right: 1px solid #d6d6d6;border-left:1px solid #d6d6d6;display: inline-block;">
		<input type="button" class="loginSubBtn" style = "border-right: none;" value="회원가입" />
		</div>
		<div style="border-right: 1px solid #d6d6d6;display: inline-block;">
		<input type="button" class="loginSubBtn" value="아이디/패스워드 찾기" />
		</div>
		</div>
		</div>
		</div>
	</li>
		
	<li class="mainContentLi firstMainContetLi">
	<div>
	<input type="button" value ="파일 업로드" data-toggle="modal" data-target="#add_project"><br />	
	<input type="text" name="encPath" id ="encPath" />
		
		<input type="button" value = "내려받기" onclick = "downladDoc()"/>
	
	<hr>	</div>
	</li>
	<li class="mainContentLi firstMainContetLi">
	<div>
		box5
	</div>
	</li>
	<li class="mainContentLi firstMainContetLi">
	<div>
		box6
	</div>
	</li>
	<li class="mainContentLi firstMainContetLi">
	<div>
		box7
	</div>
	</li>
	</ul>
	<ul class ="mainContentUl">
	
	<li class="mainContentLi secondMainContetLi">
	<div>

		<h2>최근 작성 문서.</h2>
		
		<c:forEach var="recentFileList" items="${recentFileList}" varStatus="status">
		<hr>
		<a href="#">${status.count}. | ${recentFileList.uploadDate} | ${recentFileList.fileName}</a>
		</c:forEach>
	</div>
	</li>
	<li class="mainContentLi secondMainContetLi">
	<div>
	<input type="button" value ="파일 업로드" data-toggle="modal" data-target="#add_project"><br />
		<input type="text" name="encPath" id ="encPath" />
		
		<input type="button" value = "경로다운로드" onclick = "downladDoc()"/>
		
	<hr>	</div>
	</li>
	<li class="mainContentLi secondMainContetLi">
	<div>
		box5
	</div>
	</li>
	<li class="mainContentLi secondMainContetLi">
	<div>
		box6
	</div>
	</li>
	<li class="mainContentLi ">
	<div>
		box7
	</div>
	</li>
	</ul>
	<ul class ="mainContentUl">
	<li class="mainContentLi lastMainContetLi">
	<div  class ="">
	<h2>서버 사용량.(2017-05-11 18시 기준.)</h2>
		<%-- <input type="image" src="<c:url value="/resources/img/graph_img.png" />"> --%>
		<p>BLUE : 영화</p>
		<P>ORANGE : 문서</P>
		<P>GREEN : 로그</P>
		<P>PURPLE : 기타</P>
	</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>

		<h2>작성중인 문서</h2>
		<hr>
		2번문서입니다.
		<hr>
		3번문서입니다.
		<hr>
		4번문서입니다.
		<hr>
		5번문서입니다.
	</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>
	<input type="button" value ="파일 업로드" data-toggle="modal" data-target="#add_project"><br />
		<input type="text" name="encPath" id ="encPath" />
		
		<input type="button" value = "다운로드" onclick = "downladDoc()"/>
		
	<hr>	</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>
		box5
	</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>
		box6
	</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>
		box7
	</div>
	</li>
	</ul>
</div>
</div>

    <div id="add_project" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header login-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Add Project</h4>
                </div>
                <div class="modal-body">
    <form class="form-horizontal" method="post" enctype="multipart/form-data" id="fileForm" name="fileForm"> 
        <!-- input type="file" 이라고 꼭 저어줘야 함 -->
  		문서를 선택해주세요  <input type="file" name="docFile" id="docFile" />
    </form>
           </div>
                <div class="modal-footer">
                    <input type="button" id ="sendData" class="add-project" data-dismiss="modal" value="전송" onclick="uploadDoc()">
                    <input type="button" id ="cancleData" class="cancel" data-dismiss="modal" value="취소">
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
<script>
function sideNavBtn(obj){
	$(".sideNavBtn").css("background-color","");
	$("#"+obj).css("background-color","rgb(30, 30, 30)");
	$("#"+obj).css("outline-color","rgb(30, 30, 30");
	return true;
	
}
function uploadDoc(){
	$('#fileForm').ajaxForm({
		url : "uploadDoc",
		type:"POST",
		success : function(data){
			$("#encPath").val(data);
			
		},error : function(e){
			console.log(e);
			
		}
	});
	$('#fileForm').submit();
	
}
function downladDoc(){
	$.ajax({
		url : "downloadDoc",
		type : "POST",
		data : {"encPath" : $("#encPath").val()},
		success : function(data){
			alert(data);
			window.location.assign('/drm/urlDownTest.jsp?path='+$("#encPath").val());
			
		},error : function(e){
			console.log(e);
			
		}
	});
}
</script>
</html>
