/**
 * @author luog
 */

var base_url, audioPlayer, lyricElm, currentSong, audio, timeOut, listLink, ids, listItem, player, increased, canPlay, commentPage, commentArea, listenArea, buttonShowMore, buttonPost, commentBox, username;

$(document).ready(function() {
	base_url = $('audio').attr('baseUrl');
	audioPlayer = $('#audio-player');
	lyricElm = $('#lyric');
	audio = audioPlayer[0];
	listLink = $('.list-item li input[name="link"]');
	ids = $('.list-item li input[name="id"]');
	listItem = $('#list-song .play-this-song');
	listenArea = $('#listen');
	player = plyr.setup('#audio-player');
	increased = false;
	canPlay = false;

	commentPage = 0;
	commentArea = $('#comment-area');
	buttonShowMore = $('#show-more-button');
	buttonPost = $('#post-button');
	commentBox = $('#comment-box');
	username = commentBox.attr('username');

	$('#list-song').css({
		'height' : '150px',
		'overflow' : 'auto'
	})

	play();

	buttonShowMore.click(btnShowMoreClicked);
	buttonPost.click(btnPostClicked);

	audio.plyr.on('canplay', function() {
		canPlay = true;
		if (!increased) {
			increased = true;
			var song_id = $(ids[currentSong]).val();
			timeOut = initTimeout(song_id, base_url, listenArea, false);
		}
	});

	audio.plyr.on('play', function() {
		if (canPlay && !increased) {
			increased = true;
			var song_id = $(ids[currentSong]).val();
			timeOut = initTimeout(song_id, base_url, listenArea, false);
		}
	});

	audio.plyr.on('pause', function() {
		clearTimeout(timeOut);
	});

	audio.plyr.on('ended', function() {
		increased = false;
		canPlay = false;
		clearTimeout(timeOut);
	});
});
function setSongInfo(id, lyricElm) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/song/getsong',
		contentType : 'application/json',
		data : id,
		success : function(song) {
			var lyric = song.lyric !== null ? song.lyric
					: 'Hiện chưa có lời bài hát!';
			lyricElm.html(lyric);
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function nextSong() {
	currentSong++;
	if (currentSong == listLink.length) {
		currentSong = 0;
	}
	listItem.removeClass('playing-song');
	$('.list-item li:eq(' + currentSong + ')').addClass('playing-song');
	audio.src = $(listLink[currentSong]).val();
	audio.play();
	increased = false;
	songId = $(ids[currentSong]).val();
	//
	setSongInfo(songId, listenElm, lyricElm);
	getListen(songId, base_url, listenArea, false);
	//
	if (timeOut != null)
		clearTimeout(timeOut);
	getSongComments(base_url, songId, commentPage, showComments);
}

function play() {
	currentSong = 0;
	audio.src = $(listLink[currentSong]).val()
	audio.play();
	$('.list-item li:eq(' + currentSong + ')').addClass('playing-song');
	listItem.click(function(e) {
		listItemClicked(e, $(this));
	});
	audioPlayer.on('ended', nextSong);
	songId = $(ids[currentSong]).val();
	//
	setSongInfo(songId, lyricElm);
	getListen(songId, base_url, listenArea, false);
	//
	getSongComments(base_url, songId, commentPage, showComments);
}

function listItemClicked(e, item) {
	e.preventDefault();
	increased = false;
	audio.src = item.find('input[name="link"]').val();
	audio.play();
	listItem.closest('li').removeClass('playing-song');
	currentSong = listItem.index(item);
	item.closest('li').addClass('playing-song');
	songId = $(ids[currentSong]).val();
	//
	setSongInfo(songId, lyricElm);
	getListen(songId, base_url, listenArea, false);
	//
	if (timeOut != null)
		clearTimeout(timeOut);
	getSongComments(base_url, songId, commentPage, showComments);
}

function showComments(result) {
	var comments = '';
	if (typeof (result) == 'object') {
		for (var i = 0; i < result.length; i++) {
			comments += commentHTML(result[i]);
		}
		commentArea.html(comments);
	} else {
		commentPage = result;
	}
}

function btnShowMoreClicked() {
	var song_id = $(ids[currentSong]).val();
	commentPage++;
	getSongComments(base_url, song_id, commentPage, showComments);
}

function btnPostClicked() {
	var comment = {};
	comment.username = username;
	comment.content = commentBox.val();
	var song_id = $(ids[currentSong]).val();
	comment.songId = parseInt(song_id);
	postComment(base_url, comment);
	comment.created = formatDate(new Date());
	commentArea.append(commentHTML(comment));
}
