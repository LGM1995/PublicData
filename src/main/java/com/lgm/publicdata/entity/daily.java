package com.lgm.publicdata.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class daily {
    // JPA를 사용하면 인덱스 값을 생성하기 위해 ID 값을 지정해줘야 한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    private Long count;

    private Date first_vi;

}
