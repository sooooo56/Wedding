package com.mobile.Wedding.guest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    // 방명록 리스트
    @GetMapping("/guest")
    public String guestbookList(Model model) {

        List<Guest> guestList = this.guestService.getList();
        model.addAttribute("guestList", guestList);
        return "guestbook";
    }

    // 방명록 작성
    @GetMapping("/write")
    public String guestCreate(@Valid Guest guest) {
        return "guestwrite";
    }

    @PostMapping("/write")
    public String questionCreate(@Valid Guest guest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "guestwrite";
        }

        guestService.create(guest.getName(), guest.getPw(), guest.getTxt());
        return "/guest"; // 질문 저장 후 /guest로 이동
        // TODO 앵커포인트 설정 > 작성한 방명록 표시
    }


}
