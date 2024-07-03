function cancelAlertWindow(){
	$("#can").html("");
	//隐藏
	$(".opacity_bg").hide();
}


function addAlertWindow(){
	
	//弹出创建页面
	$("#can").load("alert/alert_notebook.html");
	//显示背景
	$(".opacity_bg").show();

}

function addNoteAlertWindow(){
	//先判断，点击获取到了bookid才弹出窗口
	var $bookLi= $("#book_ul a.checked").parent();
	//获取的只是点击，每一个li都缓存了bookId，因此需要取出当前的缓存
	var bookId=$bookLi.data("bookId");
	console.log("bookID 是： "+bookId);
	if($bookLi.length==0){   //等于0说明没选中
		alert("请选择笔记本");
	}else{
		//弹出创建页面
		$("#can").load("alert/alert_note.html");
		//显示背景
		$(".opacity_bg").show();
	}
	
	

}

