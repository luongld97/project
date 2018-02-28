/**
 * @author luog
 */

var searchBox = $('#search-box');
var base_url = searchBox.attr('baseUrl');

var options = {
	url : base_url + '/api/search/searchname?keyword=' + searchBox.val(),
	getValue : 'name',
	list : {
		match : {
			enabled : true
		},
		onClickEvent : function() {
			var toUrl = base_url;
			var item = searchBox.getSelectedItemData();
			if (item.link == null && item.lyric && item.listen
					&& item.isVideo && item.isSideo)
				toUrl += '/';
			if (item.nickName == null && item.dateOfBirth == null
					&& item.gender == null)
				toUrl += '/song/play.html?id=' + item.id;
			window.location = toUrl;
		}
	}
};

searchBox.easyAutocomplete(options);