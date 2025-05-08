package com.mobile.Wedding.guest;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String pw;

    @Column(length = 100)
    private String txt;

    private LocalDateTime createDate;

}
