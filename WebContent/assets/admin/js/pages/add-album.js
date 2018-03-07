/**
 * @author luog
 */

$('#song-detail').chosen({
	'placeholder_text_multiple' : 'Select song'
});

$('#singer-detail').chosen({
	'placeholder_text_multiple' : 'Select singer'
});

var videoPhotoArea = $('#video-photo');
isVideoCheckbox.change(function() {
	if (this.checked) {
		isVideoContent.html('this is a video.');
		videoPhotoArea.removeClass('hidden');
	} else {
		isVideoContent.html('this is not a video.');
		videoPhotoArea.addClass('hidden');
	}
});

$('#singer_detail_chosen').width('100%');
$('#song_detail_chosen').width('100%');
