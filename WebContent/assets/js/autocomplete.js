/**
 * @author luog
 */
var searchBox, base_url;

$(document).ready(
		function() {
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