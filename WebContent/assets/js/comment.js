function getAllComments(base_url, song_id, success) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/comment/getallcomments',
		contentType : 'application/json',
		data : song_id,
		success : function(res) {
			success(res);
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function getAllComments(base_url, song_id, success) {
	$.ajax({
		method : 'post',
		url : base_url + '/api/comment/getallcomments',
		contentType : 'application/json',
		data : song_id,
		success : function(res) {
			success(res);
		},
		error : function(err) {
			console.log(err)
		}
	});
}

function test(base_url, song_id){
	getAllComments(base_url, song_id, success);
}


function success(res){
	console.log(res);
}