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
	})
});