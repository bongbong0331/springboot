

let index = {
	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
			console.log("ㅁㄴㅇㅁㄴㅇㄴㅁㅇ");
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
	}
	
}

index.init();