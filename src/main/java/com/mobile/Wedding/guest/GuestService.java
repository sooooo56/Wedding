package com.mobile.Wedding.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    // 리스트
    public List<Guest> getList(){
        return this.guestRepository.findAll();
    }

    // 방명록 작성
    public void create(String name, String pw, String txt) {
        Guest guest = Guest.builder()
                .name(name)
                .pw(pw)
                .txt(txt)
                .createDate(LocalDateTime.now())
                .build();

        this.guestRepository.save(guest);
    }

}
