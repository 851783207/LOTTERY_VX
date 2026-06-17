package com.tencent.wxcloudrun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer code;
    private String message;
    private Object data;

    public static ResultVO success(String message) {
        return new ResultVO(200, message, null);
    }

    public static ResultVO success(Object data) {
        return new ResultVO(200, "成功", data);
    }

    public static ResultVO error(String message) {
        return new ResultVO(500, message, null);
    }
}
