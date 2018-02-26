$(document).ready(function() {
	getPageHtml(BASE_URL + 'allsong.html');
});

// variables
var BASE_URL = document.URL.replace('.html', '/');

var areaListSong = $('#area-list-song');
var formAddSong = $('#form-add-song');
var btnFormAddSong = $('#btn-form-add-song');
// 
btnFormAddSong.click(btnFormAddSong_clicked);

function getPageHtml(url) {
	$.ajax({
		method : 'get',
		contentType : 'text/html',
		url : url,
		success : ajaxSuccess,
		error : ajaxError
	});
}

function pagination(url) {
	getPageHtml(url);
}

function ajaxSuccess(res) {
	areaListSong.html(res);
}

function ajaxError(err) {
	areaListSong.html(err.responseText)
}

function btnFormAddSong_clicked(){
	$.ajax({
		method: 'get',
		contentType: 'text/html',
		url : BASE_URL + 'addsong.html',
		success: function(res){
			formAddSong.html(res)
			console.log(res)
		},
		error: function(err){
			formAddSong.html(err.responseText)
		}
	})
}
