var base_url, dropbox, error_box, btn_add, btn_toggle, btn_save, add_form, is_open, name_box, modal_add;

$(document).ready(function() {
	initVariable();
	//
	btn_add.click(btnAddClicked);
	btn_toggle.click(btnToggleClicked);
	btn_save.click(btnSaveClicked);
});

function initVariable() {
	modal_add = $('#modal-add-play-list');
	dropbox = $('#play-list-dropbox');
	error_box = $('#name-box-error');
	btn_add = $('#btn-add');
	btn_toggle = $('#btn-toggle');
	btn_save = $('#btn-save');
	add_form = $('#add-form');
	is_open = false;
	dropbox.chosen({
		'placeholder_text_multiple' : 'Select your playlist.'
	})
	$('#play_list_dropbox_chosen').css('width', '100%');
}

function btnSaveClicked() {
	var options = {
		method : 'post',
		url : base_url + '/api/song/tolist?id=' + song_id,
		contentType : 'application/json',
		data : JSON.stringify(dropbox.val()),
		success : saveSuccess,
		error : saveError
	};
	$.ajax(options);
}

function saveSuccess(res) {
	modal_add.html('');
	modal_add.modal('hide').data('modal', null);
}

function saveError(err) {
	var errMsg = err.responseText;
	error_box.text(errMsg);
	error_box.removeClass('hidden');
}

function btnAddClicked() {
	var options = {
		method : 'post',
		url : base_url + '/api/playlist/quickadd',
		data : name_box.val(),
		contentType : 'application/json',
		success : playListAddSuccess,
		error : saveError
	};
	$.ajax(options);
}

function btnToggleClicked() {
	toggleForm();
}

function playListAddSuccess(play_list_id) {
	dropbox.append($('<option>', {
		value : play_list_id,
		text : name_box.val()
	}));
	dropbox.trigger('chosen:updated');
	error_box.addClass('hidden');
	toggleForm();
}

function toggleForm() {
	var childrenSpan = btn_toggle.find('span');
	if (!is_open) {
		childrenSpan.removeClass('glyphicon-plus').addClass('glyphicon-remove');
		name_box = $('#play-list-name');
	} else {
		childrenSpan.removeClass('glyphicon-remove').addClass('glyphicon-plus');
		name_box = null;
	}
	is_open = !is_open;
	add_form.toggle(300);
}