<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page session="false" %>
<html>
  <body>
   <div id="buttons">
    </div>
    <div id="search-container">
    </div>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="https://apis.google.com/js/client.js?onload=googleApiClientReady"></script>
    <div>
    <!-- <input type="text" id="query" style="width:200px;"> <br /> -->
    <!-- <input type="button" id="search-button" value="search-button" onclick="searchAjax()"> -->
	    
    </div>
    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
    <div id="player"></div>

    <script>
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
    			console.log(data);
    			item = data;
    			console.log(data.items[0].id.videoId);
/*     			videoUrl = data.items[0].id.videoId;
    			player.loadVideoById({'videoId': videoUrl,
    	               'startSeconds': 0,
    	               'suggestedQuality': 'small'});
    			addListAjax(); */
    			for(var i = 0 ; i < data.items.length ; i++){
    				console.log(data.items[i].snippet.title);
    				parent.frames["chatFrame"].appendData(i+1+")"+data.items[i].snippet.title+  "<br />");
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
  </body>
</html>