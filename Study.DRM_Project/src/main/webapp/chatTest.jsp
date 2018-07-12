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
<script src="<c:url value="/resources/js/youtubeJs.js" />"></script>    

<script type="text/javascript">
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
    	
    	parent.frames["youtubeFrame"].playMusic(index);
    }
    
    function sendMessage(){
        
            //websocket으로 메시지를 보내겠다.
            sock.send($("#message").val());
        
    }        
    //evt 파라미터는 websocket이 보내준 데이터다.
    function onMessage(evt){  //변수 안에 function자체를 넣음.
        var data = evt.data;
        $("#data").append(data+"<br/>");
        if(selectItem == false){
        	console.log($('#player', parent.frames["youtubeFrame"].document));
			parent.frames["youtubeFrame"].searchAjax($("#message").val());
			$("#data").append("곡을 선택하세요<br />");
			console.log("searchResult");
		selectItem = true;
        }else{
        	selectMusic(data);
        	selectItem = false;
        }
		/* sock.close(); */
    }
    
    function onClose(evt){
        $("#data").append("연결 끊김");
    }
    function appendData(data){
		$("#data").append(data+"<br/>");
		
	}
</script>
</head>
<body>
 	<div>
    	<input type="text" id="message"/>
    	<input type="button" id="sendBtn" value="전송"/>
    </div>
    <div id="data"></div>
 
</body>
<script>
	
	
</script>
</html>


