/**
 * @author luog
 */

function initTimeout(song_id, base_url, listenArea, video) {
	return setTimeout(function() {
		increaseListen(song_id, base_url, listenArea, video);
	}, 30000);
}

function increaseListen(song_id, base_url, listenArea, video) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/song/changelisten'
				+ (video != null ? '?video' : ''),
		contentType : 'text/plain',
		data : song_id,
		success : function(res) {
			if (typeof (parseInt(res)) == 'number')
				listenArea.html(res);
			console.log('Increase listen for song-ID [' + song_id
					+ '] result: ' + res);
			return;
		},
		error : function(err) {
			console.log(err);
			return;
		}
	});
}
