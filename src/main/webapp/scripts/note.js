function addNoteAction(){
	//获取参数
	var bookId=$("#book_ul a.checked").parent().data("bookId");
	var userId = getCookie("userId");
	var noteTitle= $("#input_note").val().trim();
	console.log(bookId);
	console.log(userId);
	console.log(noteTitle);
	//判断
	var ok=true;
	if(noteTitle==""){
		$("#note_span").html("笔记名称不能为空！");
		ok=false;
	}
	//还需要判断userId，预防超时
	if(userId==null){
		window.location.href="log_in.html";
	}
	if(ok){ //开始向服务器发送请求
		$.ajax({
			url:path+"/note/add.do",
			type:"post",
			data:{"bookId":bookId,"userId":userId,"noteTitle":noteTitle},
			dataType:"json",
			success : function(result) {
				if(result.state==0){
					//取消创建界面
					cancelAlertWindow();
					var note = result.data;
					var noteId=note.id;
					var noteTitle=note.title;
					//创建li
					createNoteLi(noteId, noteTitle);
					//提示成功
					alert("笔记创建成功");
					
					console.log(noteId);
					console.log(noteTitle);
					console.log(note.bookId);
				}
				
				
			},
			error:function() {
				alert("创建笔记失败了");
			}
	
		});
	}
}










function loadNotes(){ 
			//获取参数bookId
			var bookId=$(this).data("bookId");
			//console.log("bookId是:"+bookId);
			//先清除
			$("#book_ul a").removeClass("checked");
			//$("#book_ul a").remove("checked");  
			//设置选中效果//选中当前的，找到a,加上属性Class
			$(this).find("a").addClass("checked");
			//下面这句的效果：鼠标移出之后就失去效果了，但是上面那句不会，效果会保留
			//$(this).find("a").addClass(".checked");
			//发送ajax请求
			$.ajax({
				url:path+"/note/list.do",
				type:"post",
				dataType:"json",
				data:{"bookId":bookId},
				success:function(result){
					if(result.state==0){
						var map = result.data;
						//获取id和title
						//console.log("result.data的长度："+map.length);
						//在开始本次之前把上一次的清除
						//$("#note_ul").empty();
						//上下两句效果相同
						$("#note_ul li").remove();	
						//每个bookid下的note数量不同，因此map的长度每次都不同
						for(var i=0;i<map.length;i++){
							//获取笔记id
							var noteId=map[i].id;
							//console.log("noteId是："+noteId);
							//获取笔记名称title
							var noteTitle=map[i].title;
							//console.log("noteTitle是： "+noteTitle);
							//将笔记li加载到book_ul
							createNoteLi(noteId,noteTitle);
						}	
						
					}
					
				},
				error:function(){
					alert("笔记加载失败");
				}
				
			});
			
		}



/*循环追加创建note的方法*/
function createNoteLi(noteId,noteTitle){

	var noteLi=
	'<li class="online"><a>'
	+'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '
	+noteTitle
	+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"> '
	+'<i class="fa fa-chevron-down"></i></button></a> '
	+'<div class="note_menu" tabindex="1">  '
	+'<dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt> ' 
	+'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt> '
	+'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt> '
	+'	</dl></div></li> '
	//将字符串转成jquery对象li元素
	var $noteLi=$(noteLi);
	
	//将noteId绑定到元素中.data为数据缓存
	$noteLi.data("noteId",noteId);
	//console.log("noteId:"+noteId);
	
	//追加节点
	$("#note_ul").append($noteLi);
	
	
}


function showNote(){
	
	var noteId = $(this).data("noteId");
	console.log("点击动作获取的noteId: "+noteId);
	//样式处理
	//先清除
	$("#note_ul a").removeClass("checked");
	//当前的点击，找到其a，然后加Class
	$(this).find("a").addClass("checked");
	
	//开始向服务器发送请求.调取note的内容和标题
	$.ajax({
		url:path+"/note/show.do",
		type:"post",
		dataType:"json",
		data:{"noteId":noteId},
		success:function(result){
			
			if(result.state==0){ //成功返回数据
				//获取title和body
				//根据noteId获取的note，只能有一个，因此不是数组，而只是一个note对象						
				var title = result.data.title;
				var body = result.data.body;
				//console.log(title);
				//console.log("笔记内容是:"+body);
				//title显示的地方
				$("#input_note_title").val(title);
				//body显示的地方
				//$("#myEditor").html(body);
				um.setContent(body);  //这一句跟上一句效果等同
				//加载完成，把noteId存进cookie
				addCookie("noteId",noteId);
			}
			
		},
		error:function(){
			alert("Opps!笔记加载失败了!");
		}

	});

	//笔记显示函数结束位置
}


//save note
function saveNote(){
	//alert("savenote");
	
	//获取当前noteId
	//var noteId = $(this).data("noteId");
	
	
	//可以不用Cookie
	var noteId =getCookie("noteId");
	//获取title
	var title = $("#input_note_title").val().trim();
	//获取body
	var $li = $("#note_ul a.checked").parent()
	//获取body
	var body = $("#myEditor").html().trim();
	//console.log("从Cookie获取的noteId是："+noteId);
	//console.log("title是："+title);
	//console.log("body是："+body);
	//获取title和id
	var ok=true;
	if(title==null){
		alert("笔记标题不能为空");
		ok=false;
	}
	if(noteId==null){
	
		ok=false;
	}
	//执行发送请求，发给服务器进行保存
	$.ajax({
		url:path+"/note/save.do",
		type:"post",
		dataType:"json",
		data:{"noteId":noteId,"title":title,"body":body},
		success:function(result){
			if(result.state==0){
				//获取到有checked的a，然后刷新a即可
				//$("#note_ul a.checked").parent().parent().load(); //不行啊
				//好吧，重写a
				var str=
					+'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '
					+title
					+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"> '
					+'<i class="fa fa-chevron-down"></i></button></a> '
	;
				//找到li找到a
				$li.find("a").html(str);
				console.log(result.message);
				
			}
		
		},
		error:function(){
			console.log("笔记保存失败");
		}
		
	});
	
}






