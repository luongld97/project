var checkbox_background, image_form;

$(document).ready(function() {
	initVariable();
	checkbox_background.change(checkboxBackgroundChange);
});

function initVariable() {
	checkbox_background = $('input[type="checkbox"]');
	image_form = $('#image-form');
}

function checkboxBackgroundChange() {
	image_form.toggle(300);
}

function deleteSongInPlayList(base_url, play_list_id, song_id) {
	var result = confirm('Are you sure?');
	var postData = [ play_list_id, song_id ];
	if (result) {
		var options = {
			method : 'post',
			url : base_url + '/api/playlist/removesong',
			data : play_list_id + ':' + song_id,
			contentType : 'application/json',
			success : function(res) {
				window.location = base_url
						+ '/account/playlist/update.html?id=' + play_list_id;
			},
			error : function(err) {
				alert(err.responseText);
			}
		};
		$.ajax(options);
	}
}