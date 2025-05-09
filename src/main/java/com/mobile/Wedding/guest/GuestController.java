package com.mobile.Wedding.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
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

//    @GetMapping("/write")
//    public String createGuest() {
//        return "guestwrite";
//    }


    // 방명록 작성
    @PostMapping("/guest")
    public String createGuest(@ModelAttribute Guest guest) {
        guest.setCreateDate(LocalDateTime.now());
        guestRepository.save(guest);
        return "redirect:/guest";
    }


}
