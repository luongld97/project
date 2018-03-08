/**
 * @author luog
 */
function initTimeout(base_url, song_id, listen_area, is_video) {
    return setTimeout(function () {
        increaseListen(base_url, song_id, listen_area, is_video);
    }, 30000);
}

function increaseListen(base_url, song_id, is_video, listen_area) {
    var options = {
        method: 'post',
        url: base_url + '/api/song/changelisten' + (is_video ? '?video' : ''),
        contentType: 'text/plain',
        data: song_id,
        success: function (res) {
            if (typeof (parseInt(res)) == 'number')
                listen_area.html(res);
        }
        /*
         * Use this method to debug
         * Delete when release 
         */
        ,
        error: function (err) {
            console.log(err);
        }
    };
    $.ajax(options);
}

