package com.mobile.Wedding.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;
    private final GuestRepository guestRepository;

    // 방명록 리스트
    @GetMapping("/guest")
    public String guestbookList(Model model) {

        List<Guest> guestList = this.guestService.getList();
        model.addAttribute("guestList", guestList);
        return "guestbook";
    }


}
