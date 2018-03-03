function getSongComments(base_url, song_id, page, success) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/comment/getallsongcomments?page=' + page,
		contentType : 'application/json',
		data : song_id,
		success : function(res) {
			success(res);
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function getUserComments(base_url, username, page, success) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/comment/getallusercomments?page=' + page,
		contentType : 'application/json',
		data : username,
		success : function(res) {
			success(res);
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function postComment(base_url, comment) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/comment/postcomment',
		contentType : 'application/json',
		dataType : 'json',
		data : JSON.stringify(comment),
		success : function(res) {
			console.log(res)
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function commentHTML(comment) {
	var commentHTML = 
		'<li class="mb-3">' 
			+ '<div class="row">'
				+ '<div class="col-md-2">' 
					+ '<img	src="' + base_url + '/assets/images/' + comment.userPhoto + '" alt="" class="avatar">' 
				+ '</div>' 
				+ '<div class="col-md-10">'
					+ '<div class="top-read">' 
						+ '<b>' + comment.username + '</b>'
						+ '<i class="float-right">' + comment.created + '</i>' 
					+ '</div>'
					+ '<div class="text-justify">' + comment.content + '</div>'
				+ '</div>' 
			+ '</div>' 
		+ '</li>';
	return commentHTML;
}

function formatDate(date){
	var dateTimeString = '';
	var day = date.getDate();
	day = day.toString().length == 1 ? '0' + day : day;
	var month = date.getMonth() + 1;
	month = month.toString().length == 1 ? '0' + month : month;
	var hour = date.getHours();
	hour = hour.toString().length == 1 ? '0' + hour : hour;
	var minute = date.getMinutes();
	minute = minute.toString().length == 1 ? '0' + minute : minute;
	var second = date.getSeconds();
	second = second.toString().length == 1 ? '0' + second : second;
	dateTimeString += date.getFullYear()
		+ '-' + month
		+ '-' + day
		+ ' ' + hour
		+ ':' + minute
		+ ':' + second
	return dateTimeString;
}

