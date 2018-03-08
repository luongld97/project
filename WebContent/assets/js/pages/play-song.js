/**
 * @author luog
 */
var page_info,
    song_id,
    is_video,
    base_url,
    can_play,
    time_out,
    increased,
    comment_page,
    comment_area,
    listen_area,
    btn_show_more,
    btn_post,
    comment_box,
    username,
    list_comments,
    player;

$(document).ready(function () {
    //
    initVariable();
    //
    getSongComments(base_url, song_id, comment_page, getComments);
});

function initVariable() {
    page_info = $('#page-info');
    song_id = page_info.attr('song-id');
    base_url = page_info.attr('base-url');
    is_video = page_info.val() == 'video' ? true : false;
    can_play = false;
    increased = false;
    comment_page = 0;
    comment_area = $('#comment-area');
    btn_show_more = $('#show-more-button');
    btn_post = $('#post-button');
    listen_area = $('#listen');
    comment_box = $('#comment-box');
    username = comment_box.attr('username');
    list_comments = [];
    //
    player = plyr.setup({ autoplay: 'true' })[0];
    player.on('canplay', playerCanPlay);
    player.on('play', playerPlay);
    player.on('pause', playerPause);
    player.on('ended', playerEnded);
    //
    btn_show_more.click(btnShowMoreClicked);
    btn_post.click(btnPostClick);
}

function playerCanPlay() {
    can_play = true;
    if (!increased) {
        time_out = initTimeout(base_url, song_id, is_video, listen_area);
        increased = true;
    }
}

function playerPlay() {
    if (can_play && !increased) {
        time_out = initTimeout(base_url, song_id, is_video, listen_area);
    }
}

function playerPause() {
    clearTimeout(time_out);
}

function playerEnded() {
    clearTimeout(time_out);
    increased = false;
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
    postComment(base_url, comment, function (comment) {
        list_comments = [comment].concat(list_comments);
        showComments(base_url, list_comments, comment_area);
        comment_box.val('');
    });
}