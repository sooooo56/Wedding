package com.mobile.Wedding;

import com.mobile.Wedding.guest.Guest;
import com.mobile.Wedding.guest.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final GuestService guestService;

    @GetMapping("/SeojunHaeun")
    public String SeojunHaeun(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
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

    @GetMapping("/")
    public String root(){
        return "redirect:/SeojunHaeun";
    }

}
