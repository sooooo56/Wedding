package com.mobile.Wedding.guest;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message="이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message="비밀번호는 필수항목입니다.")
    @Column(length = 20)
    private String pw;

    @NotEmpty(message="내용은 필수항목입니다.")
    @Column(length = 100)
    private String txt;

    private LocalDateTime createDate;

}
