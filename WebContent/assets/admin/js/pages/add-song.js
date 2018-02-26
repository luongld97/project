/**
 * @author luog
 */

$('#singer-detail').chosen({
	'placeholder_text_multiple' : 'Select singer'
});

$('#category-detail').chosen({
	'placeholder_text_multiple' : 'Select category'
});
$('#author-detail').chosen({
	'placeholder_text_multiple' : 'Select author'
});
var isVideoCheckbox = $('#is-video');
var isVideoContent = $('#is-video-content');
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
$('#author_detail_chosen').width('100%');
$('#category_detail_chosen').width('100%');