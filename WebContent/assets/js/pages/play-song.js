/**
 * @author luog
 */
var song_id, base_url, canPlay, timeOut, increased, player, commentPage, commentArea, buttonShowMore, buttonPost, commentBox, username;

$(document).ready(function() {
	song_id = $('audio').attr('songId');
	base_url = $('audio').attr('baseUrl');
	canPlay = false;
	increased = false;
	commentPage = 0;
	commentArea = $('#comment-area');
	buttonShowMore = $('#show-more-button');
	buttonPost = $('#post-button');
	commentBox = $('#comment-box');
	username = commentBox.attr('username');
	player = plyr.setup({
		autoplay : 'true'
	});

	player[0].on('canplay', songCanPlay);

	player[0].on('play', function() {
		if (canPlay && !increased) {
			timeOut = initTimeout(song_id, base_url);
			increased = true;
		}
	});

	player[0].on('pause', function() {
		clearTimeout(timeOut);
	});

	player[0].on('ended', songEnded);
	
	buttonShowMore.click(btnShowMoreClicked);
	buttonPost.click(btnPostClicked);
	
	getSongComments(base_url, song_id, commentPage, showComments);
});

function songCanPlay() {
	canPlay = true;
	if (!increased) {
		timeOut = initTimeout(song_id, base_url);
		increased = true;
	}
}

function songEnded() {
	clearTimeout(timeOut);
	increased = false;
}

function showComments(result) {
	if (typeof(result) == 'object'){
		for (var i = 0; i < result.length; i ++){
			commentArea.append(commentHTML(result[i]))
		}
	} else {
		commentPage = result;
	}
}

function  btnShowMoreClicked() {
	commentPage ++;
	getSongComments(base_url, song_id, commentPage, showComments);
}

function  btnPostClicked() {
	var comment = {};
	comment.username = username;
	comment.content = commentBox.val();
	comment.songId = parseInt(song_id);
	postComment(base_url, comment);
	comment.created = formatDate(new Date());
	commentArea.append(commentHTML(comment));
}


