package com.brew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brew.domain.User;
import com.brew.service.BoardService;
import com.brew.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/userpage")
	public String userPage(HttpSession session) {
		return "view/user/userpage";
	}

	@RequestMapping("/modify")
	public String userModifyPage() {
		return "view/user/usermodifypage";
	}

	@RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
	public String userUpdate(HttpSession session, @ModelAttribute User user) {
		userService.userUpdate(user);

		User newuser = userService.findByUserId(user.getUserId());

		session.setAttribute("user", newuser);
		return "view/user/userpage";
	}

	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String userDelete(String userId, HttpSession session) {
		User user = userService.findByUserId(userId);
		userService.deleteAllBoardInUser(user.getBoard());
	 	userService.deleteAllReviewInUser(user.getReview());
	 	boardService.deleteAllReplyInBoard(user.getReply());
		userService.deleteUser(userId);
		
		session.removeAttribute("user");
		return "view/index";
	}

// 예외처리 예시
//	@PostMapping("/sign-up.act")
//	public ResponseEntity<DataResponse> signUp(@RequestBody Map<String, String> params) {		
//		DataResponse dataResponse = new DataResponse();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//
//		User user = User.builder().userEmail(params.get("userEmail")).userPassword(params.get("userPassword"))
//				.userName(params.get("userName")).userNickname(params.get("userNickname")).build();
//		
//		if(userService.findByUserEmail(params.get("userEmail")) != null) {
//			ErrorResponse.CustomFieldError customFieldError = new ErrorResponse.CustomFieldError("User", params.get("userEmail"), "아이디 중복");
//			throw new DuplicateIdException(customFieldError);
//		}
//		
//		if (userService.insertUser(user) != null) {
//			dataResponse.setStatus(StatusCode.OK.getStatus());
//			dataResponse.setCode(StatusCode.OK.getCode());
//			dataResponse.setData(user);
//			
//			return new ResponseEntity<DataResponse>(dataResponse, headers, HttpStatus.OK);
//		} else {
//			dataResponse.setStatus(StatusCode.NOT_FOUND.getStatus());
//			dataResponse.setCode(StatusCode.NOT_FOUND.getCode());
//			
//			return new ResponseEntity<DataResponse>(dataResponse, headers, HttpStatus.NOT_FOUND);
//		}
//	}
}
