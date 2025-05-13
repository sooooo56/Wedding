package com.mobile.Wedding.guest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public String guestCreate(Model model) {
        model.addAttribute("write", new Guest()); // 필수!
        return "guestwrite";
    }

    @PostMapping("/write")
    public String questionCreate(@Valid @ModelAttribute("write") Guest guest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "guestwrite";
        }

        guestService.create(guest.getName(), guest.getPw(), guest.getTxt());
        return "redirect:/guest"; // 질문 저장 후 /guest로 이동
        // TODO 앵커포인트 설정 > 작성한 방명록 표시
    }

    // 방명록 삭제
    @PostMapping("/guest/delete")
    @ResponseBody
    public Map<String, Object> deleteGuest(@RequestBody Map<String, String> data) {
        int id = Integer.parseInt(data.get("id"));
        String pw = data.get("pw");

        boolean deleted = guestService.delete(id, pw);

        Map<String, Object> response = new HashMap<>();
        response.put("success", deleted);
        return response;
    }


}
