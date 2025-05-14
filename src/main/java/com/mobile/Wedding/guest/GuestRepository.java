package com.mobile.Wedding.guest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Integer> {

    Page<Guest> findAllByOrderByCreateDateDesc(Pageable pageable);

}
