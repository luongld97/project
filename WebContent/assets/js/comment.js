/**
 * @author luog
 */
function getSongComments(base_url, song_id, page, success) {
    var options = {
        method: 'post',
        url: base_url + '/api/comment/getallsongcomments?page=' + page,
        contentType: 'application/json',
        data: song_id,
        success: success
        /**
         * Use this function to debug
         * Delete when release
         */
        ,
        error: function (err) {
            console.log(err);
        }
    };
    $.ajax(options);
}

function getUserComments(base_url, username, page, success) {
    var options = {
        method: 'post',
        url: base_url + '/api/comment/getallusercomments?page=' + page,
        contentType: 'application/json',
        data: username,
        success: success
        /**
         * Use this function to debug
         * Delete when release
         */
        ,
        error: function (err) {
            console.log(err);
        }
    };
}

function postComment(base_url, comment, success) {
    var options = {
        method: 'post',
        url: base_url + '/api/comment/postcomment',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(comment),
        success: success
        /**
         * Use this function to debug
         * Delete when release
         */
        ,
        error: function (err) {
            console.log(err);
        }
    };
    $.ajax(options);
}

function commentHTML(base_url, comment) {
    var commentHTML =
        '<li class="mb-3">'
        + '<div class="row">'
        + '<div class="col-md-2">'
        + '<img	src="' + base_url + '/assets/images/' + comment.userPhoto + '" class="avatar">'
        + '</div>'
        + '<div class="col-md-10">'
        + '<div class="top-read">'
        + '<b>' + comment.username + '</b>'
        + '<i class="float-right">' + comment.created + '</i>'
        + '</div>'
        + '<div class="text-justify">' + comment.content + '</div>'
        + '</div>'
        + '</div>'
        + '</li>';
    return commentHTML;
}

function showComments(base_url, comments, comment_area) {
    var result = '';
    var comments_length = comments.length;
    for (var i = 0; i < comments_length; i++) {
        result += commentHTML(base_url, comments[i]);
    }
    comment_area.html(result);
}