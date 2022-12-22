


let index = {
	init : function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});
		
		$("#btn--update").bind("click", () => {
			this.update();
		})
	},
	

	save : function(){
		let saveData = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		$.ajax({
			type : "POST",
			url : "/auth/joinProc",
			data : JSON.stringify(saveData),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(data){
			if(data.status == "OK"){
				alert("회원가입성공");
				location.href = "/"
			}
		}).fail(function(error){
			alert("회원가입실패");
		});
		
	},
	
	update: function(){
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type: "PUT",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; chartset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			if(data.status){
				alert("회원수정완료");
				location.href = "/";
			}
		}).fail(function(error){
			alert("회원수정실패");
		});
	},
}



index.init();