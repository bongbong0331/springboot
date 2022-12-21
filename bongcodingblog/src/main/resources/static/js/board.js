

let index = {
	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
			console.log("ㅁㄴㅇㅁㄴㅇㄴㅁㅇ");
		});
	
		$("#btn--delete").bind("click", () => {
			this.deleteById();
			console.log("삭제오냐");
		});
		
		$("#btn--update").bind("click", () => {
			this.update();
			console.log("수정오냐");
		});
		
		
		
		
	},
	save: function(){
		
		let saveData ={
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type:"POST",
			url:"/api/board",
			contentType: "application/json; charset=utf-8",
			data : JSON.stringify(saveData),
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			console.log(data);
			if(data.status == "OK"){
				alert("글쓰기성공했다잉");
				location.href = "/";
			}
		}).fail(function(error){
			alert("등록실패 ㅠㅠㅠ" + error.responseJSON.message);
		});
	},
	
	deleteById: function(){
		let id = $('#board-id').text();
		alert("id" + id);
		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id
		}).done(function(data, textStatus, xhr){
			if(data.status == "OK"){
			alert("글 삭제가 완료되었씁니다");
			location.href = "/";
			}
		}).fail(function(error){
			alert("글 삭제 실패");
		});
	},
	
	update : function(){
		let boardId = $("#board-id").attr("data-id");
		
		let data = {
			title : $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
			type: "PUT",
			url: "/api/board/" + boardId,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
			
		}).done(function(data, textStatus, xhr){
			if(data.status){
				alert('수정이 완료되따');
				location.href = "/";
			}
		}).fail(function(error) {
			alert("수정실퍀ㅋㅋ");
			console.log(error);
		});
	}
	
	
}

index.init();



