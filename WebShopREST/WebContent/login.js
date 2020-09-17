$(document).ready(function(){	
	/*$.ajax({
			url: "rest/users/login",
			type: "POST",
			contentType: "application/json",
			complete: function(data){				
			$('#login').submit(function(event) {
		
			let uname = $('input[name="username"]').val();
			let pass = $('input[name="password"]').val();
			
			if((uname == '') && (pass == '')) {
					alert("Morate uneti vase korisnicko ime i lozinku");
					
					let allTds = $('td');
					
					allTds[1].append("Polje mora ne sme biti prazno!");
					$(allRds[1]).css("color", "red");*/
					/*let input1 = document.getElementById("input1");
					alert("Input1 je: " + input1);
					let text1 = document.createTextNode("Polje ne sme biti prazno!");
					alert("Text1 je: " + text1);
					input1.after("Polje ne sme biti prazno!");
					return;
					
					let input2 = document.getElementById("input2");
					return;
					//input2.after(text1);
					let i = document.createElement("i");
					i.setAttribute("id" , "text");
					
					let text = document.createTextNode("Polje ne sme biti prazno!");
					
					i.append(text);
					
					document.getElementById("input1").after(i);
					
					return;
				}else if((uname!='') && (pass=='')){
					alert("Morate uneti vasu lozinku!");
					return;
				}else if((uname=='') && (pass!='')){
					alert("Morate uneti vase korisnicko ime!");
					return;
				}
			
			
			for(let u in data){
				alert("Usao je u for");
				alert("Uname je " + uname);
				alert(u);
				if((data[u]!=null) && (data[u].username==uname) && (data[u].password==pass)){
					let role = data[u].role;
					alert("usao je u if");
					alert("Uloga je: " + role);
					if(role == 'admin'){
						var url = "http://localhost:8080/WebShopREST/adminPage.html";
							history.pushState({}, null, url);
							return;
					}else if(role == "host"){
						var url="http://localhost:8080/WebShopREST/hostPage.html" + "?username=" + u.uname;
							history.pushState({}, null, url);
							return;
					}else if(role=="guest") {
						var url="http://localhost:8080/WebShopREST/guestPage.html" + "?username=" + u.uname;
							history.pushState({}, null, url);
							return;
					}
				}
				
	}
	
	alert("Niste dobro uneli korisnicko ime i lozinku");

	});
	}
		});*/
		$.ajax({
			url: "rest/users/allUsers",
			type: "GET",
			contentType: "application/json",
			success: function(user){
				//alert("Korisnici: " + user);
				
				$('#login').submit(function(event){
					event.preventDefault();
					let username = $('input[name="username"]').val();
					let password = $('input[name="password"]').val();
					
					alert("Username je: " + username);
					alert("Password je: " + password);
					
					if(username == ''){
						alert("Unesite svoje korisnicko ime!");
						return;
					}else if(password == ''){
						alert("Usesite svoju lozinku!");
						return;
					}
					
					/*for(let u in user){
						alert("Username je: " + user[u].username);
						alert("Password je: " + user[u].password);
						if((user[u].username!=username)||(user[u].password!=password)){
							alert("Niste dobro uneli korisnicko ime i lozinku!");
							return;
						}
					}*/
					
					
					$.post({
						url: "rest/users/login",
						data: JSON.stringify({username, password}),
						contentType: "application/json",
						success: function(data) {
							alert("Usao je u complete");
							alert("data je: " + data);
							//alert("Username je: " + data.value)
							
								//alert("data[d].username: " + data.username);
								if(data == null){
									alert("Ne postoji korisnik sa ovim korisnickim imenom i lozinkom!");
								}else if(data!=null){
									alert("Usao je u else if");
							
									$.get({
										url: "rest/users/getLogged",
										contentType: "application/json",
										success: function(user){
											alert("Usao je u success");
											if(user.role == 'admin'){
												window.location = './adminPage.html';
											}else if(user.role == 'guest'){
												window.location = './guestPage.html';
											}else {
												window.location = './hostPage.html';
											}
									
										}
								
									});
								}
						}
							
					});
				});
			}
		});
});
