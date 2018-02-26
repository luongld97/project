/**
 * @author luog
 */

function initTimeout(song_id, base_url) {
	return setTimeout(function() {
		increaseListen(song_id, base_url);
	}, 30000);
}

function increaseListen(song_id, base_url) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/song/changelisten',
		contentType : 'text/plain',
		data : song_id,
		success : function(res) {
			console.log('Increase listen for song-ID [' + song_id + '] result: ' + res);
			return;
		},
		error : function(err) {
			console.log(err);
			return;
		}
	});
}