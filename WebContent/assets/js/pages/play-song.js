/**
 * @author luog
 */
var song_id, isVideo, base_url, canPlay, timeOut, increased, player, commentPage, listenArea, commentArea, buttonShowMore, buttonPost, commentBox, username, listComments;

$(document).ready(function() {
	song_id = $('audio').attr('songId');
	isVideo = $('audio').attr('video') != null;
	base_url = $('audio').attr('baseUrl');
	canPlay = false;
	increased = false;
	commentPage = 0;
	commentArea = $('#comment-area');
	buttonShowMore = $('#show-more-button');
	buttonPost = $('#post-button');
	commentBox = $('#comment-box');
	username = commentBox.attr('username');
	listenArea = $('#listen');
	listComments = [];
	player = plyr.setup({
		autoplay : 'true'
	});

	player[0].on('canplay', songCanPlay);

	player[0].on('play', function() {
		if (canPlay && !increased) {
			timeOut = initTimeout(song_id, base_url, listenArea);
			increased = true;
		}
	});

	player[0].on('pause', function() {
		clearTimeout(timeOut);
	});

	player[0].on('ended', songEnded);

	buttonShowMore.click(btnShowMoreClicked);
	buttonPost.click(btnPostClicked);
	getSongComments(base_url, song_id, commentPage, allComments);
});

function songCanPlay() {
	canPlay = true;
	if (!increased) {
		timeOut = initTimeout(song_id, base_url, listenArea);
		increased = true;
	}
}

function songEnded() {
	clearTimeout(timeOut);
	increased = false;
}

function allComments(comments) {
	if (typeof (comments) == 'object') {
		listComments = listComments.concat(comments);
		showComments(listComments);
	}
}

function showComments(result) {
	var html = '';
	for (var i = 0; i < result.length; i++) {
		html += commentHTML(result[i]);
	}
	commentArea.html(html)
}

function btnShowMoreClicked() {
	commentPage++;
	getSongComments(base_url, song_id, commentPage, allComments);
}

function btnPostClicked() {
	var comment = {};
	comment.username = username;
	comment.content = commentBox.val();
	comment.songId = parseInt(song_id);
	postComment(base_url, comment);
	comment.created = formatDate(new Date());
	comment.userPhoto = $('#user-avatar').attr('src').replace(
			base_url + '/assets/images/', '');
	listComments = [ comment ].concat(listComments);
	showComments(listComments);
	commentBox.val('');
}

//function getListen(base_url, id, is_video) {
//	var getUrl = base_url + '/api/song/getlisten?id=' + id;
//	if (is_video)
//		getUrl += '&video';
//	$.ajax({
//		method : 'get',
//		url : getUrl,
//		contentType : 'text/plain',
//		success : function(res) {
//			$('#listen').html(res);
//		},
//		error : function(err) {
//			console.log('GET_LISTEN_ERROR: ' + err.responseText);
//		}
//	});
//}
