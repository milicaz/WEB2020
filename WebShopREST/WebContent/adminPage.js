$(document).ready(function(){
	
	
	$('#registration').submit(function(event){
		
		alert("Usao u submit");
		
		let uname = $('input[name="username"]').val();
		let pass = $('input[name="password"]').val();
		let fname = $('input[name="firstName"]').val();
		let lname = $('input[name="lastName"]').val();
		let g = $('input[name="gender"]').val();
		
		alert("Username je: " + uname);
		alert("Gender je:" + g);
		
	$.ajax ({
		url: "rest/users/hostRegistration",
		type: "POST",
		data: JSON.stringify({
			username: $('input[name="username"]').val(),
			password: $('input[name="password"]').val(), 
			firstName: $('input[name="firstName"]').val() ,
			lastName: $('input[name="lastName"]').val() ,
			gender: $('input[name="gender"]').val() ,  
		}),
		contentType:"application/json",
		dataType:"json",
		success: function(data){
			alert("Uspesno ste se registrovali");
			var url = "http://localhost:8080/WebShopREST/adminPage.html";
			window.location.replace(url);
			
		}
	});
	});
	
	$('#logout').click(function(event){
		alert("Usao je u click");
		$.ajax({
			url:"rest/users/logout",
			type:"POST",
			complete: function(data){
				alert("Usao je u complete");
				var url = "http://localhost:8080/WebShopREST/";
				window.location.replace(url);
			}
		});
	});
	
});