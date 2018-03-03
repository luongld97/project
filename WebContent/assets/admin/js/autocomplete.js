var searchBox, base_url, request_url, target_url;

$(document).ready(function(){
	searchBox = $('#search-box');
	base_url = searchBox.attr('baseUrl');
	request_url = searchBox.attr('requestUrl');
	target_url = searchBox.attr('targetUrl');
	var options = {
			url : base_url + request_url +'?keyword='
					+ searchBox.val().split(' ').join('-'),
			getValue : 'name',
			list : {
				match : {
					enabled : true
				},
				onClickEvent : function() {
					var item = searchBox.getSelectedItemData();
					window.location = base_url + target_url + '?id=' + item.id;
				}
			}
		};
		searchBox.easyAutocomplete(options);
});
