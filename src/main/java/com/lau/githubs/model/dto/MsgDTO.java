package com.lau.githubs.model.dto;

import lombok.Data;

/**
 * @author bka
 * @date 2019-06-23 16:16
 */
@Data
public class MsgDTO {

    private String username;

    private Integer count;


    public MsgDTO(String username, Integer count) {
        this.username = username;
        this.count = count;
    }

    public MsgDTO() {
    }

}
