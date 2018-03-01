/**
 * @author luog
 */

$(document).ready(
		function() {
			var base_url = $('audio').attr('baseUrl');
			var audioPlayer = $('#audio-player');
			var lyricElm = $('#lyric');
			var listenElm = $('#listen');
			var currentSong;
			var audio = audioPlayer[0];
			var listLink = $('.list-item li input[name="link"]');
			var ids = $('.list-item li input[name="id"]');
			var listItem = $('#list-song li');
			var player = plyr.setup('#audio-player');
			var increased = false;
			var canPlay = false;

			$('#list-song').css({
				'height' : '150px',
				'overflow' : 'auto'
			})

			play();

			function play() {
				currentSong = 0;
				audio.src = $(listLink[currentSong]).val()
				audio.play();
				$('.list-item li:eq(' + currentSong + ')').addClass(
						'playing-song');
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
				listItem.removeClass('playing-song');
				currentSong = listItem.index(item);
				item.addClass('playing-song');
				songId = $(ids[currentSong]).val();
				setSongInfo(songId, listenElm, lyricElm);
				clearTimeout(timeOut);
			}

			function nextSong() {
				currentSong++;
				if (currentSong == listLink.length) {
					currentSong = 0;
				}
				listItem.removeClass('playing-song');
				$('.list-item li:eq(' + currentSong + ')').addClass(
						'playing-song');
				audio.src = $(listLink[currentSong]).val();
				audio.play();
				increased = false;
				songId = $(ids[currentSong]).val();
				setSongInfo(songId, listenElm, lyricElm);
				clearTimeout(timeOut);
			}

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
