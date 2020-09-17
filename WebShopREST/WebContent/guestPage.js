$(document).ready(function(){
	$('#logout').click(function(event){
		$.ajax({
			url: "rest/users/logout",
			type: "POST",
			complete: function(data) {
				alert("ucao je u complete");
				var url = "http://localhost:8080/WebShopREST/";
				window.location.replace(url);
			}
		});
	});
		
	$('#profil').click(function(event){
		
		
		$.get({
			url: "rest/users/getLogged",
			contentype : "application/json",
			success: function(data){
			alert("Usao je u success");
			alert("data.username je:" + data.username);
			alert("data.password je: " + data.password);
			alert("data.firstName je: " + data.firstName);
			alert("data je: "+ data);
			
			let tbody = $('#profil tbody');
			
			if(data.role == 'guest'){
				let username = $('<td>' + data.username + '</td>');
				let password = $('<td>' + data.password + '</td>');
				let firstName = $('<td>' + data.firstName + '</td>');
				let lastName = $('<td>' + data.lastName + '</td>');			
				let gender = $('<td>' + data.gender + '</td>');
				let role = $('<td>' + data.role + '</td>');
				
				let tr = $('<tr></tr>');
				tr.append(username)
				.append(password)
				.append(firstName)
				.append(lastName)
				.append(gender)
				.append(role);
				
				tbody.append(tr);
				
			}
			
		}
		
	});
	
	});
});