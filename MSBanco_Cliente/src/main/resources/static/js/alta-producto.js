(function($){
	$.isBlank = function(obj){
		return(!obj || $.trim(obj) === "");
	};
	
	$.getUrlParameter = function getUrlParameter(sParam) {
	    var sPageURL = window.location.search.substring(1),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
	        }
	    }
	};
})(jQuery);

$(document).ready(function(){
	
	var USER_API_HOST = "http://localhost:8081";
	var USER_API_BASE_PATH = USER_API_HOST+"/beto_banco_usuario/usuario/solicitud";
	
	$("#name").val("");
	$("#email").val("");
	
	var validateUserForm = function(new_user){
		var valid = true;
		if($.isBlank(new_user.nombre)){
			valid = false;
			$("#name_error").text("Name is mandatory");
		}else{
			$("#name_error").text("");
		}
		if($.isBlank(new_user.correo)){
			valid = false;
			$("#email_error").text("Email is mandatory");
		}else{
			$("#email_error").text("");
		}
		return valid;
	}
	
	$("#alta_productor").on("click", function(event){
		event.preventDefault();
		
		var new_user = {
			nombre: $("#name").val().trim(),
			apellidoPaterno: $("#apPaterno").val().trim(),
			apellidoMaterno: $("#apMaterno").val().trim(),
			direccion: $("#domicilio").val().trim(),
			telefonoCelular: $("#telefono").val().trim(),
			correo: $("#email").val().trim(),
			claveProducto: $("#producto").val().trim(),
			rfc: $("#rfc").val().trim()
		}
		
		if(validateUserForm(new_user)){
		
			$.ajax({
				url: USER_API_BASE_PATH+"/alta",
				method: "POST",
				contentType: "application/json; charset=UTF-8",
				dataType: "json",
				data: JSON.stringify(new_user),
				success: function( result ) {
					window.location.href = "/";
				},
				error: function( jqXHR, textStatus, errorThrown ) {
					console.log(jqXHR);
				}
				
			});
		}
	});
});