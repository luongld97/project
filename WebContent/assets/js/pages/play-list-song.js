/**
 * @author luog
 */

var base_url, audioPlayer, lyricElm, listenElm, currentSong, audio, listLink, ids, listItem, player, increased, canPlay;

$(document).ready(function() {
	base_url = $('audio').attr('baseUrl');
	audioPlayer = $('#audio-player');
	lyricElm = $('#lyric');
	listenElm = $('#listen');
	audio = audioPlayer[0];
	listLink = $('.list-item li input[name="link"]');
	ids = $('.list-item li input[name="id"]');
	listItem = $('#list-song .play-this-song');
	player = plyr.setup('#audio-player');
	increased = false;
	canPlay = false;

	$('#list-song').css({
		'height' : '150px',
		'overflow' : 'auto'
	})

	play();
	audio.plyr.on('canplay', function() {
		canPlay = true;
		if (!increased) {
			increased = true;
			var song_id = $(ids[currentSong]).val();
			timeOut = initTimeout(song_id, base_url);
		}
	});

	audio.plyr.on('play', function() {
		if (canPlay && !increased) {
			increased = true;
			var song_id = $(ids[currentSong]).val();
			timeOut = initTimeout(song_id, base_url);
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
function setSongInfo(id, listenElm, lyricElm) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/song/getsong',
		contentType : 'application/json',
		data : id,
		success : function(song) {
			var lyric = song.lyric !== null ? song.lyric
					: 'Hiện chưa có lời bài hát!';
			lyricElm.html(lyric);
			listenElm.html(song.listen);
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
	setSongInfo(songId, listenElm, lyricElm);
	clearTimeout(timeOut);
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
	setSongInfo(songId, listenElm, lyricElm);
}

function listItemClicked(e, item) {
	e.preventDefault();
	increased = false;
	audio.src = item.find('input[name="link"]').val();
	audio.play();
	console.log(listItem.parent())
	listItem.closest('li').removeClass('playing-song');
	currentSong = listItem.index(item);
	item.closest('li').addClass('playing-song');
	songId = $(ids[currentSong]).val();
	setSongInfo(songId, listenElm, lyricElm);
	clearTimeout(timeOut);
}
