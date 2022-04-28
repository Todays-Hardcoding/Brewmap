package com.brew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brew.domain.ChatRoom;
import com.brew.domain.ChatRoomForm;
import com.brew.domain.User;
import com.brew.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("/chatting")
    public String rooms(Model model){
        model.addAttribute("rooms",chatRoomRepository.findAllRoom());
        System.out.println(chatRoomRepository.findAllRoom());
        return "view/chat/rooms";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model, HttpServletRequest req){
        ChatRoom room = chatRoomRepository.findRoomById(id);
        User user = (User)req.getSession().getAttribute("user");
        
        model.addAttribute("room",room);
//        model.addAttribute("user", user);
//        model.addAttribute("userName", "1111");
//        model.addAttribute("userNickName", "22222");
//        model.addAttribute("userName", user.getUserName());
        if(user.getUserNickName() != null)
        	model.addAttribute("userNickName", user.getUserNickName());
        else
        	model.addAttribute("userNickName", "nullUserNickname");
        System.out.println(user);
        return "view/chat/room";
    }

    @GetMapping("/new")
    public String make(Model model){
        ChatRoomForm form = new ChatRoomForm();
        model.addAttribute("form",form);
        return "view/chat/newRoom";
    }

    @PostMapping("/room/new")
    public String makeRoom(ChatRoomForm form){
        chatRoomRepository.createChatRoom(form.getName());

        return "redirect:/chatting";
    }

}
