$(document).ready(function(){
	var loginTab = $("#login-tab");
	var registerTab = $("#register-tab");
	var bgLogin = $(".bg-login");
	var bgRegister = $(".bg-register");
	registerTab.hide();
	$(".pd-login").click(function(){
		loginTab.show();
		registerTab.hide();
		bgLogin.addClass("bg-is-selected");
		bgRegister.removeClass("bg-is-selected");
	});
	$(".pd-register").click(function(){
		loginTab.hide();
		registerTab.show();
		bgLogin.removeClass("bg-is-selected");
		bgRegister.addClass("bg-is-selected");
	});
});