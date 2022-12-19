


let index = {
	init : function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});
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
			}
		}).fail(function(error){
			alert("회원가입실패");
		});
		
	}
}



index.init();