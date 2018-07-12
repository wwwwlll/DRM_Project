function movePage(url){
	location.href=url;
}
function regist_User(){
	$.ajax({
		type : "POST",
		url : 'registUser',
		contType : "application/x-www-form-urlencoded; charset=utf-8",
		data :{
			"userId" : $("#regist_ID").val(),
			"userPwd" :  $("#regist_PWD").val()
		},
		success : function(data){
			alert(data);
		},
		error : function(e){
			alert(e);
		}
	});
}
function login(){
	$.ajax({
		type : "POST",
		url : "login",
		contType : "application/x-www-form-urlencoded; charset=utf-8",
		data :{
			"userId" : $("#userId").val(),
			"userPwd" : $("#userPwd").val(),
			"accessKey" : $("#accessKey").val()
		},
		success : function(data){
			if(data=="accessKey"){
				var str = "";
				$(".loginBtn").css("margin-top","40px");
				$("#accessKey").css("display","inline");
			}else if(data=="success"){
				alert("성공");
			}else{
				alert(data);
			}
		},
		error : function(e){
			alert(e);
		}
		
	});
}