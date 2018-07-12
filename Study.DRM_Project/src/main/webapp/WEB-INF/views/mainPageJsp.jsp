<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<c:url value="/resources/js/customJS.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sockjs.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.form.min.js" />"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://apis.google.com/js/client.js?onload=googleApiClientReady"></script>

<link rel="stylesheet"	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet"	href="<c:url value="/resources/css/htmlStudyPage.css" />">
<meta name="viewport" content="initial-scale=1, width=device-width"/> 

	<title>Home</title>
</head>
<body>
<div id="youtubeDiv" style="display:none;">
    <div id="player"></div>
</div>
	<div class="page">
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
		<div>
			<div id="loginBox">
				<input type="text" id="userId" class ="loginText" style="margin-top:20px;" placeholder="아이디"/>
				<input type="button" class="loginBtn" style="margin-top:20px;" value = "login" onclick="login()">
				<br />
				<input type="password" id="userPwd" class ="loginText" style="margin-top:10px" placeholder="패스워드"/>
				<br />
				<input type='text' style='margin-top:10px;display:none;' class ='loginText' id='accessKey' placeholder='인증키를 입력하세요'>
				<br />
				<div style="font-size:15px;text-align:right;">
					<input type="checkbox">아이디 저장
				</div>
			</div>
			<div class="loginBtnDiv">
			<hr class="loginBtnHr">
				<div style="border-right: 1px solid #d6d6d6;border-left:1px solid #d6d6d6;display: inline-block;">
					<input type="button" class="loginSubBtn" style = "border-right: none;" value="회원가입" onClick = "movePage('registUserJsp')" />
				</div>
				<div style="border-right: 1px solid #d6d6d6;display: inline-block;">
					<input type="button" class="loginSubBtn" value="아이디/패스워드 찾기" />
				</div>
			</div>
		</div>


		<!-- ====================로그인박스================ -->
		<!-- <div>
			<div id="loginBox">
				<input type="text" id="userId" class ="loginText" style="margin-top:20px;" placeholder="아이디"/>
				<input type="button" class="loginBtn" style="margin-top:20px;" value = "login" onclick="login()">
				<br />
				<input type="password" id="userPwd" class ="loginText" style="margin-top:10px" placeholder="패스워드"/>
				<br />
				<input type='text' style='margin-top:10px;display:none;' class ='loginText' id='accessKey' placeholder='인증키를 입력하세요'>
				<br />
				<div style="font-size:15px;text-align:right;">
					<input type="checkbox">아이디 저장
				</div>
			</div>
			<div class="loginBtnDiv">
			<hr class="loginBtnHr">
				<div style="border-right: 1px solid #d6d6d6;border-left:1px solid #d6d6d6;display: inline-block;">
					<input type="button" class="loginSubBtn" style = "border-right: none;" value="회원가입" onClick = "movePage('registUserJsp')" />
				</div>
				<div style="border-right: 1px solid #d6d6d6;display: inline-block;">
					<input type="button" class="loginSubBtn" value="아이디/패스워드 찾기" />
				</div>
			</div>
		</div> -->
		<!-- ==================================== -->
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
		<input type="text" name="" id ="" />
		
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
		<div class="chatDiv" style="">
			<div>
				<input type="text" id="message" onkeypress="if(event.keyCode==13) {$('#sendBtn').click()}"/> <input type="button"	id="sendBtn" value="전송"/>
			</div>
			<div id="data" class="chatDataDiv" style="overflow-y:scroll;"></div>
		</div>
	</li>
	<li class="mainContentLi lastMainContetLi">
	<div>
	<input type="button" value ="파일 업로드" data-toggle="modal" data-target="#add_project"><br />
		<input type="text" name="" id ="" />
		
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
function downloadDoc(){
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
var selectItem = false;
   $(document).ready(function(){
       $("#sendBtn").click(function(){
           sendMessage();
           
           
       });
   });
   
   //websocket을 지정한 URL로 연결
   var sock= new SockJS("<c:url value="/echo"/>");
   //websocket 서버에서 메시지를 보내면 자동으로 실행된다.
   sock.onmessage = onMessage;
   //websocket 과 연결을 끊고 싶을때 실행하는 메소드
   sock.onclose = onClose;
   function selectMusic(index){
   	console.log("index : "+index);
   	playMusic(index);
   }
   
   function sendMessage(){
	   var message = $("#message").val().trim();
   		
           //websocket으로 메시지를 보내겠다.
	       sock.send(message);
       
   }        
   //evt 파라미터는 websocket이 보내준 데이터다.
   function onMessage(evt){  //변수 안에 function자체를 넣음.
       var data = evt.data;
       $("#data").append(data+"<br/>");
       var order ="";
       var order_val = "";
       var splitMessage;
       var message = data.replace("echo:","").trim(); 
       if(message.substring(0,3)=="^^^"){
    	   splitMessage = message.split(":");
    	   order = splitMessage[0].replace();
    	   order_val = splitMessage[1];
		
    	   if(order=="^^^find"){
    			searchAjax(order_val);
           		$("#message").val("");
    			$("#data").append("곡을 선택하세요<br />");
    			     		   
    	   }else if(order=="^^^sel"){
    	       	selectMusic(order_val);
    	       	selectItem = false;
    	        
    	        $("#message").val("");
    	   }else if(order=="^^^now"){
    		  $("#data").append("Now Playing >> "+player.getVideoData().title);
    	   }else if(order=="^^^stop"){
    		  player.stopVideo(); 
    	   }else if(order=="^^^start"){
    		  player.startVideo();
    	   }
    	   
       }
       $("#data").scrollTop( $("#data").get(0).scrollHeight);
       $("#message").val("");
/*        if(selectItem == false){
       		searchAjax($("#message").val());
       		$("#message").val("");
			$("#data").append("곡을 선택하세요<br />");
			console.log("searchResult");
			 $("#data").scrollTop( $("#data").get(0).scrollHeight);

		selectItem = true;
       }else{
       	selectMusic(data);
       	selectItem = false;
        $("#data").scrollTop( $("#data").get(0).scrollHeight);
        $("#message").val("");

       } */
		/* sock.close(); */
   }
   
   function onClose(evt){
       $("#data").append("연결 끊김");
       $("#data").scrollTop( $("#data").get(0).scrollHeight);

   }
   function appendData(data){
		$("#data").append(data+"<br/>");
		 $("#data").scrollTop( $("#data").get(0).scrollHeight);

		
	}
   var tag;
   var firstScriptTag;
   var player;
   var videUrl;
	var selectItem = false;
	var item ;
	
	
   function playMusic(index){
   	index = index.replace("echo:","");
		videoUrl = item.items[index-1].id.videoId;
		player.loadVideoById({'videoId': videoUrl,
              'startSeconds': 0,
              'suggestedQuality': 'small'});
       }
       function searchAjax(keyWord){
       	$.ajax({
       	type : "GET",
   		url : "https://www.googleapis.com/youtube/v3/search?",
   		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
   		async : false,
   		data : {
   			"key" : "AIzaSyCTCudM7wDn8R6kZnW3m7dwe2fdV-t48eQ",
   			"part" : "snippet",
   			"order" : "viewCount",
   			"q" : keyWord,
   			"vq":"small",
   		},success : function(data) {
   			item = data;
/*     			videoUrl = data.items[0].id.videoId;
   			player.loadVideoById({'videoId': videoUrl,
   	               'startSeconds': 0,
   	               'suggestedQuality': 'small'});
   			addListAjax(); */
   			for(var i = 0 ; i < data.items.length ; i++){
   				console.log(data.items[i].snippet.title);
   				appendData(i+1+")"+data.items[i].snippet.title+  "<br />");
   				}
   		},error:function(data){
   			console.log(data);
   		}
   		
       });
       }
       function addListAjax(){
       	$.ajax({
       		type:"GET",
       		url:"addList",
       		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
       		data:{
       			"command" : "testCommand"
       		},
       		success: function(data){
       			console.log(data);
       		},error:function(data){
       			console.log(data);
       		}
       		
       	});
       }

     // 2. This code loads the IFrame Player API code asynchronously.
     tag = document.createElement('script');

     tag.src = "https://www.youtube.com/iframe_api";
     firstScriptTag = document.getElementsByTagName('script')[0];
     firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

     // 3. This function creates an <iframe> (and YouTube player)
     //    after the API code downloads.
     player;
     videoUrl = "R3DbYFoqGr8";
     function onYouTubeIframeAPIReady() {
       player = new YT.Player('player', {
         height: '360',
         width: '640',
         videoId: videoUrl,
         events: {
           'onReady': onPlayerReady,
           'onStateChange': onPlayerStateChange
         }
       });
     }

     // 4. The API will call this function when the video player is ready.
     function onPlayerReady(event) {
       event.target.playVideo();
     }

     // 5. The API calls this function when the player's state changes.
     //    The function indicates that when playing a video (state=1),
     //    the player should play for six seconds and then stop.
     var done = false;
     function onPlayerStateChange(event) {
       if (event.data == YT.PlayerState.PLAYING && !done) {
/*         	done = true;
*/        }
     }
     function stopVideo() {
  /*      player.stopVideo();
   */   }
     var intevalVal = setInterval(function(){
   	  console.log(player.getPlayerState());
     },3000);
  
</script>
</html>
