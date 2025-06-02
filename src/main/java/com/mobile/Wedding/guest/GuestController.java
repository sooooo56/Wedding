package com.mobile.Wedding.guest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String guestbookList(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {

        Pageable pageable = PageRequest.of(page - 1, 4); // 한 페이지에 4개
        Page<Guest> guestPage = guestService.getPageList(pageable);

        int currentPage = guestPage.getNumber() + 1;
        int totalPages = guestPage.getTotalPages();
        int startPage = Math.max(currentPage - 2, 1);
        int endPage = Math.min(currentPage + 2, totalPages);

        model.addAttribute("guestList", guestPage.getContent()); // 실제 목록
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "SeojunHaeun";
    }

    // 방명록 작성
    @GetMapping("/write")
    public String guestCreate(Model model) {
        model.addAttribute("write", new Guest()); // 필수!
        return "guestwrite";
    }

    @PostMapping("/write")
    @ResponseBody
    public Map<String, Object> write(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String pw = body.get("pw");
        String txt = body.get("txt");

        guestService.saveGuest(name, pw, txt);

        return Map.of("success", true);
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

    @GetMapping("/guest/fetch")
    @ResponseBody
    public Map<String, Object> guestbookFetch(@RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 4);
        Page<Guest> guestPage = guestService.getPageList(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("guestList", guestPage.getContent());
        return response;
    }




}
