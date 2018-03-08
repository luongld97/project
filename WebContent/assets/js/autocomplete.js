/**
 * @author luog
 */
var searchBox, base_url, btn_save;

$(document).ready(
		function() {
			btn_save = $('#btn-add-play-list');
			searchBox = $('#search-box');
			base_url = searchBox.attr('base-url');
			var options = {
				url : base_url + '/api/search/searchname?keyword='
						+ searchBox.val().split(' ').join('-'),
				getValue : 'name',
				list : {
					match : {
						enabled : true
					},
					onClickEvent : function() {
						var toUrl = base_url;
						var item = searchBox.getSelectedItemData();
						if (item.link == null && item.lyric == null
								&& item.listen == null && item.isVideo == null
								&& item.isShow == null)
							toUrl += '/artist/singer/info.html?id=' + item.id;
						if (item.nickName == null && item.dateOfBirth == null
								&& item.gender == null)
							toUrl += '/song/play.html?id=' + item.id;
						window.location = toUrl;
					}
				}
			};
			searchBox.easyAutocomplete(options);

		});

btn_save.click(function() {
	alert(1)
})

function addToClick(id) {
	song_id = id;
	$.ajax({
		method : 'get',
		url : base_url + '/song/tolist.html',
		contentType : 'text/html',
		success : function(res) {
			$('#modal-add-play-list').html('');
			$('#modal-add-play-list').html(res);
		}
	});
}

function quickAdd() {
	var name_box = $('#play-list-name');
	var options = {
		method : 'post',
		url : base_url + '/api/playlist/quickadd',
		data : name_box.val(),
		contentType : 'application/json',
		success : function(res) {
			hideErrMsg();
			$('#create-play-list-modal').modal('hide').data('modal', null);
			window.location = base_url + '/account/playlist/update.html?id=' + res;
		},
		error : function(err) {
			var errMsg = err.responseText;
			$('#name-box-error').text(errMsg);
			$('#name-box-error').removeClass('hidden');
		}
	};
	$.ajax(options);
}

$('#create-play-list-modal').on('hidden.bs.modal', function() {
	hideErrMsg();
});

function hideErrMsg() {
	$('#name-box-error').addClass('hidden');
	$('#name-box-error').text('');
	$('#name-box').val('');
}