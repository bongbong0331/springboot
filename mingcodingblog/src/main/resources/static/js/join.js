

$('#join--submit').on('click', function(){
	
	let data = {
		username : $('#username').val(),
		password : $('#password').val(),
		email : $('#email').val(),
	};
	
	console.log("data : " + data.username);
	console.log("data : " + data.password);
	console.log("data : " + data.email);



	$.ajax({
		type: 'post',
		url: '/dummy/signup2',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		dataType: 'json'
	}).done(function(response){
		console.log(response);
	}).fail(function(error){
		console.log(error);
	});














}); 



