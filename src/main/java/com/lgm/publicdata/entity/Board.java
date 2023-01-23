package com.lgm.publicdata.entity;

import lombok.Data;

// @Data 를 사용하면 겟터와 셋터를 지정할 필요 없음
@Data
public class Board {

    private Long id;

    private String title;
    private String content;
}
