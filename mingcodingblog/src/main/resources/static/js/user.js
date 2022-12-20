

let index = {
	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});
		
		$("#btn--login").bind("click", () => {
			this.login();
		});
	},
	
	
	save: function(){
		
			let savedata = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			}
		$.ajax({
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(savedata),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			console.log(data);
			if(data.status == "OK"){
				alert("회원가입완료");
				location.href = "/";
			}
			
			
		}).fail(function(error){
			alert("회원가입 실패 : " + error.responseJSON.message);
		});		
		},
		
		
		login : function(){
			
			let loginData = {
				username: $("#username").val(),
				password: $("#password").val(),
			};
			
			$.ajax({
				type: "POST",
				url: "/api/user/login",
				data : JSON.stringify(loginData),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(data, textStatus, xhr){
				alert("로그인 성공");
				console.log(loginData);
				location.href = "/";
			}).fail(function(error){
				alert("로그인 실패");
			});
		}
		
	
	
}

index.init();