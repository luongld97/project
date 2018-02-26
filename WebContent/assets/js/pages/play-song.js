/**
 * @author luog
 */

var song_id = $('audio').attr('songId');
var base_url = $('audio').attr('baseUrl');

var canPlay = false;
var timeOut;
var increased = false;
//
var player = plyr.setup({
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