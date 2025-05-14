package com.mobile.Wedding.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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


    // 삭제
//    public boolean delete(int id, String pw) {
//        Optional<Guest> guestOpt = guestRepository.findById(id);
//        if (guestOpt.isPresent()) {
//            Guest guest = guestOpt.get();
//            if (guest.getPw().equals(pw)) {
//                guestRepository.delete(guest);
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean delete(int id, String pw) {
        Optional<Guest> guestOpt = guestRepository.findById(id);
        if (guestOpt.isPresent() && guestOpt.get().getPw().equals(pw)) {
            guestRepository.delete(guestOpt.get());
            return true;
        }
        return false;
    }

    public Page<Guest> getPageList(Pageable pageable) {
        return guestRepository.findAllByOrderByCreateDateDesc(pageable);
    }

}
