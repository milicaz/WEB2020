$(document).ready(function(){
	
	$.ajax({
		url: "rest/users/allUsers",
		type: "GET",
		contentType: "application/json",
		success: function(user){
		$('#registration').submit(function(event){
		
		alert("Usao u submit");
		
		let uname = $('input[name="username"]').val();
		let pass = $('input[name="password"]').val();
		let rpass = $('input[name="repeatPass"]').val();
		let fname = $('input[name="firstName"]').val();
		let lname = $('input[name="lastName"]').val();
		let g = $('input[name="gender"]').val();
		
		alert("Username je " +uname);
		alert("Lozinka je : " + pass);
		alert("Ponovljena lozinka je: " + rpass);
		
		for(let u in user){
			
			if(user[u].username == uname){
				alert("Usao je u proveru usera.");
				alert("Vec postoji korisnik sa ovim korisnickim imenom!");
				return;
			}else if(pass!=rpass){
				alert("Usao je u proveru pasworda.");
				alert("Neispravna lozinka!");
				return;
			}else if((uname=='') || (pass=='') || (rpass=='') || (fname=='') || (lname=='') || (g=='')){
				alert("Usao je u proveru ili.");
				alert("Sva polja moraju biti popunjena");
				return;
			}else if((uname=='') && (pass=='') && (rpass=='') && (fname=='') && (lname=='') && (g=='')){
				alert("Usao je u proveru i.");
				alert("Sva polja moraju bili popunjena");
				return;
			}
		}
		
	$.ajax ({
		url: "rest/users/registration",
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
		
		success: function (data) {
			alert("usao je u succes");
							if(data != null){
								console.log(data);
								window.location = "http://localhost:8080/WebShopREST/";
							}else{
								alert("Postoji korisnik sa tim Username!")
							}
			            }
	});
	});
	}
	});
});