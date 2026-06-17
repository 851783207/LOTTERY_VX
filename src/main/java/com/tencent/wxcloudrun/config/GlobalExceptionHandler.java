package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.model.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVO handleIllegalArgumentException(IllegalArgumentException e) {
        return ResultVO.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResultVO handleRuntimeException(RuntimeException e) {
        return ResultVO.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        return ResultVO.error("服务器内部错误：" + e.getMessage());
    }
}
