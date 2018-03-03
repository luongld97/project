var searchBox;
var base_url;

$(document).ready(function(){
	searchBox = $('#search-box');
	base_url = searchBox.attr('baseUrl');
	
	var options = {
			url : base_url + '/api/song/search?keyword='
					+ searchBox.val().split(' ').join('-'),
			getValue : 'name',
			list : {
				match : {
					enabled : true
				},
				onClickEvent : function() {
					var item = searchBox.getSelectedItemData();
					window.location = base_url + '/admin/song/updatesong.html?id=' + item.id;
				}
			}
		};
		searchBox.easyAutocomplete(options);
});
