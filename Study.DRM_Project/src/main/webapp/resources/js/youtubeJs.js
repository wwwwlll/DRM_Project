var tag;
var firstScriptTag;
var player;
var videUrl;


function addPlayList(){
    	
    }
    function searchAjax(){
    	$.ajax({
    	type : "GET",
		url : "https://www.googleapis.com/youtube/v3/search?",
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		data : {
			"key" : "AIzaSyCTCudM7wDn8R6kZnW3m7dwe2fdV-t48eQ",
			"part" : "snippet",
			"order" : "viewCount",
			"q" : $("#query").val(),
		},success : function(data) {
			console.log(data);
			console.log(data.items[0].id.videoId);
			videoUrl = data.items[0].id.videoId;
			player.loadVideoById({'videoId': videoUrl,
	               'startSeconds': 5,
	               'suggestedQuality': 'large'});
			addListAjax();
		
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
