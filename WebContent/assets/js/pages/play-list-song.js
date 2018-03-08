var base_url, song_id, media_player, lyric_area, current_song, media, time_out, links, ids, items, player, increased, can_play, comment_page, list_comments, comment_area, listen_area, btn_show_more, btn_post, comment_box, username;
$(document).ready(function() {
	initVariable();
	//
	media.plyr.on('canplay', mediaCanPlay);
	media.plyr.on('play', mediaPlay);
	media.plyr.on('pause', mediaPause);
	media.plyr.on('ended', mediaEnded);
	items.click(function(e) {
		itemsClicked(e, $(this));
	});
	media_player.on('ended', nextSong);
	//
	btn_show_more.click(btnShowMoreClicked);
	btn_post.click(btnPostClick);
	//
	mediaAutoPlay();
	// 
	getSongComments(base_url, song_id, comment_page, getComments);

});

function initVariable() {
	base_url = $('#page-info').attr('base-url');
	player = plyr.setup('#media-player');
	media_player = $('#media-player');
	media = media_player[0];
	lyric_area = $('#lyric');
	listen_area = $('#listen');
	list_comments = [];
	comment_area = $('#comment-area');
	comment_box = $('#comment-box');
	username = comment_box.attr('username');
	items = $('#list-song .play-this-song');
	links = $('.list-item li input[name="link"]');
	ids = $('.list-item li input[name="id"]');
	btn_show_more = $('#show-more-button');
	btn_post = $('#post-button');
	increased = false;
	can_play = false;
	comment_page = 0;
}

function mediaAutoPlay() {
	current_song = 0;
	$('.list-item li:eq(' + current_song + ')').addClass('playing-song');
	media.src = $(links[current_song]).val();
	media.play();
	//
	song_id = $(ids[current_song]).val();
	getSongInfo(base_url, song_id, showSongInfo);
}

function mediaCanPlay() {
	can_play = true;
	if (!increased) {
		song_id = $(ids[current_song]).val();
		time_out = initTimeout(base_url, song_id, false, listen_area);
		increased = true;
	}
}

function mediaPlay() {
	if (can_play && !increased) {
		song_id = $(ids[current_song]).val();
		time_out = initTimeout(base_url, song_id, false, listen_area);
		increased = true;
	}
}

function mediaPause() {
	clearTimeout(time_out);
}

function mediaEnded() {
	increased = false;
	can_play = false;
	clearTimeout(time_out);
}

function nextSong() {
	current_song++;
	if (current_song == links.length)
		current_song = 0;
	//
	increased = false;
	list_comments = [];
	items.removeClass('playing-song');
	media.src = $(links[current_song]).val();
	media.play();
	song_id = $(ids[current_song]).val();
	//
	getSongInfo(base_url, song_id, showSongInfo);
	list_comments = [];
	comment_page = 0;
	getSongComments(base_url, song_id, comment_page, getComments);
	//
	if (time_out != null)
		clearTimeout(time_out);
}

function itemsClicked(e, item) {
	e.preventDefault();
	increased = false;
	list_comments = [];
	items.closest('li').removeClass('playing-song');
	item.closest('li').addClass('playing-song');
	current_song = items.index(item);
	media.src = $(links[current_song]).val();
	media.play();
	//
	song_id = $(ids[current_song]).val();
	getSongInfo(base_url, song_id, showSongInfo);
	list_comments = [];
	comment_page = 0;
	getSongComments(base_url, song_id, comment_page, getComments);
}

function getSongInfo(base_url, song_id, success) {
	var options = {
		method : 'post',
		url : base_url + '/api/song/getsong',
		contentType : 'application/json',
		data : song_id,
		success : success
		/**
		 * Use this function to debug Delete when release
		 */
		,
		error : function(err) {
			console.log(err);
		}
	};
	$.ajax(options);
}

function showSongInfo(song) {
	var lyric = song.lyric != null ? song.lyric : 'No have lyric now!';
	var listen = song.listen;
	lyric_area.html(lyric);
	listen_area.html(listen);
}

function getComments(comments) {
	if (typeof (comments) == 'object') {
		list_comments = list_comments.concat(comments);
		showComments(base_url, list_comments, comment_area);
	}
}

function btnShowMoreClicked() {
	comment_page++;
	getSongComments(base_url, song_id, comment_page, getComments);
}

function btnPostClick() {
	var comment = {};
	comment.username = username;
	comment.content = comment_box.val();
	comment.songId = parseInt(song_id);
	postComment(base_url, comment, function(cmt) {
		list_comments = [ cmt ].concat(list_comments);
		showComments(base_url, list_comments, comment_area);
		comment_box.val('');
	});
}