package com.luog.onlinemusic.ws;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Comment;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.CommentEntity;
import com.luog.onlinemusic.helpers.EntityHelper;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.CommentService;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("comment")
public class CommentRestController {

	@Autowired
	private SongService songService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private AccountService accountService;

	private final int PAGE_SIZE = 2;

	/**
	 * @author luog
	 */
	@RequestMapping(value = "postcomment", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentEntity> postComment(HttpSession session,
			@RequestBody(required = false) CommentEntity commentEntity) {
		try {
			Account currentAccount = (Account) session.getAttribute("currentAccount");
			if (currentAccount != null) {
				Comment comment = toComment(commentEntity);
				boolean result = commentService.create(comment);
				if (result)
					return new ResponseEntity<>(EntityHelper.toCommentEntity(comment), HttpStatus.OK);
			}
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "getallusercomments", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAllUserComments(@RequestParam(value = "page", required = false) Integer page,
			@RequestBody(required = false) String username) {
		PagedListHolder<CommentEntity> pagedListHolder = null;
		Account currentAccount = username != null ? accountService.find(username) : null;
		pagedListHolder = currentAccount != null ? new PagedListHolder<>(commentService.getComments(currentAccount))
				: new PagedListHolder<>();
		return getCommentEntityResponse(pagedListHolder, page);
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "getallsongcomments", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAllSongComments(@RequestParam(value = "page", required = false) Integer page,
			@RequestBody(required = false) Integer songId) {
		PagedListHolder<CommentEntity> pagedListHolder = null;
		Song currentSong = songId != null ? songService.find(songId) : null;
		pagedListHolder = currentSong != null ? new PagedListHolder<>(commentService.getComments(currentSong))
				: new PagedListHolder<>();
		return getCommentEntityResponse(pagedListHolder, page);
	}

	/**
	 * @author luog
	 */
	private ResponseEntity<Object> getCommentEntityResponse(PagedListHolder<CommentEntity> pagedListHolder, int page) {
		ResponseEntity<Object> responseEntity = null;
		try {
			pagedListHolder.setPageSize(PAGE_SIZE);
			pagedListHolder.setPage(page);
			int lastPage = pagedListHolder.getLastLinkedPage();
			responseEntity = lastPage < page ? new ResponseEntity<Object>(lastPage, HttpStatus.OK)
					: new ResponseEntity<Object>(pagedListHolder.getPageList(), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	private Comment toComment(CommentEntity commentEntity) {
		Comment comment = null;
		try {
			comment = new Comment();
			comment.setAccount(accountService.find(commentEntity.getUsername()));
			comment.setSong(songService.find(commentEntity.getSongId()));
			comment.setContent(commentEntity.getContent());
			comment.setCreated(new Date());
		} catch (Exception e) {
			comment = null;
		}
		return comment;
	}
}
