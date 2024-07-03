function loadBooks(){
	
	//如果点击变更了，虽然是笔记本，而不是笔记，也要把title和body清空吧？
	
	var title = $("#input_note_title").empty();
	
	var body = $("#myEditor").empty();
	
	
	
	//获取参数-cookie中保存的id
	var userId=getCookie("userId");
	console.log("userId:"+userId);
	
	if(userId==null){  //未能获取到userId
		window.location.href="log_in.html";
	}else{ //不为空则向服务器发送请求
		$.ajax({
			url:path+"/book/loadbooks.do",
			type:"post",
			dataType:"json",
			data:{"userId":userId},
			success:function(result){
				if(result.state==0){  //成功
					//获取笔记本的集合
					var books = result.data;
					//循环将笔记本集合数据加入到book_ul
					for(var i=0;i<books.length;i++){
						//获取笔记本id
						var bookId=books[i].NotebookId;
						//获取笔记本名称
						var bookName=books[i].NotebookName;
						//将笔记本li加载到book_ul
						createBookLi(bookId,bookName);
						
						
					}
				}else if(result.state==1){   //失败。id为空或无用户
					
				}
				
			},
			error:function(){
				alert("笔记本加载失败了");
			}
			
		});
	}
	
}
//创建一个笔记本li，添加到book-ul中
function createBookLi(bookId,bookName){
	var sli ='<li class="online"><a> '+
	'<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'+bookName+'</a></li>'

	var $li=$(sli); //将sli字符串转成jquery对象li元素
	//将bookId绑定到元素中.data为数据缓存
	$li.data("bookId",bookId);
	
	//将li元素添加到笔记本列表book_ul
	$("#book_ul").append($li);
	
}

//function loadNotes(){
//	var bookId=getCookie("bookId");
//	var bookId2=data("bookId");
//	$("li").on("click",function(){
//		console.log($(this).html());
//		console.log(bookId);
//	});
//}	
//	



//以下方法拼接明显太麻烦
//function createBookLi(bookId,bookName){
//	var sli ="";
//		sli+='<li class="online"><a  class="checked"> ';
//		sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
//		sli+='</i>'
//		sli+=bookName;
//		sli+='</a></li>';
//
//	var $li=$(sli); //将sli字符串转成jquery对象li元素
//	
//	//将li元素添加到笔记本列表book_ul
//	$("#book_ul").append($li);
//}




function addBookAction(){
	//获取用户名和bookName
	var userId = getCookie("userId");
	var bookName =$("#input_notebook").val().trim();
	//判断
	var ok=true;
	if(userId==null){
		//登录超时，要求重新登录
		ok=false;
		window.location.href="log_in.html";
	}
	if(bookName==""){
		ok=false;
		$("#addbook_span").html("笔记本名称不能为空");
	}
	//验证通过
	if(ok){
		$.ajax({
			url:path+"/book/add.do",
			type:"post",
			dataType:"json",
			data:{"userId":userId,"bookName":bookName},
			success:function(result){
				if(result.state==0){
					//取消创建窗口
					cancelAlertWindow();
					var book = result.data;
					var bookName = book.NotebookName;
					var bookId = book.NotebookId;
					console.log(bookName);
					console.log(bookId);
					//调用方法插入
					createBookLi(bookId, bookName);
					//提示成功
					alert("笔记本创建成功");
				}
			},
			error:function(){
				alert("笔记本创建失败");
			}
			
			
			
		});
	}
	
	
	
	
}












