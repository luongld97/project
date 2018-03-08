var base_url, dropbox, errorBox, btnAdd, btnToggle, btnSave, addForm, isOpen, nameBox;

$(document).ready(function() {
	initialize();
	btnToggle.click(btnToggleClicked);
	btnAdd.click(btnAddClicked);
	btnSave.click(btnSaveClicked)
});

function btnSaveClicked() {
	$.ajax({
		method : 'post',
		url : base_url + '/api/song/tolist?id=' + song_id,
		contentType : 'application/json',
		data : JSON.stringify(dropbox.val()),
		success : function(res) {
			var modalAdd = $('#modalAddPlaylist');
			modalAdd.html('');
			modalAdd.modal('hide').data('modal', null);
		},
		error : error
	})
}

function btnAddClicked() {
	nameBox = $('#play-list-name');
	base_url = nameBox.attr('base-url');
	$.ajax({
		method : 'post',
		url : base_url + '/api/playlist/quickadd',
		data : nameBox.val(),
		contentType : 'application/json',
		success : response,
		error : error
	});
}

function response(id) {
	dropbox.append($('<option>', {
		value : id,
		text : nameBox.val()
	}));
	dropbox.trigger('chosen:updated');
	nameBox.val('');
	errorBox.addClass('hidden');
	toggleForm();
}

function error(err) {
	var errMsg = err.responseText;
	errorBox.text(errMsg);
	errorBox.removeClass('hidden');
}

function btnToggleClicked() {
	toggleForm();
}

function toggleForm() {
	var span = btnToggle.find('span');
	if (!isOpen) {
		span.removeClass('glyphicon-plus');
		span.addClass('glyphicon-remove');
		nameBox = $('#play-list-name');
		isOpen = !isOpen;
	} else {
		span.removeClass('glyphicon-remove');
		span.addClass('glyphicon-plus');
		nameBox = null;
		isOpen = !isOpen;
	}
	addForm.toggle(300);
}

function initialize() {
	dropbox = $('#play-list-dropbox');
	errorBox = $('#name-box-error');
	btnAdd = $('#btn-add');
	btnToggle = $('#btn-toggle');
	btnSave = $('#btn-save');
	addForm = $('#add-form');
	isOpen = false;
	dropbox.chosen({
		'placeholder_text_multiple' : 'Select playlist'
	});
	$('#play_list_dropbox_chosen').width('100%');
}