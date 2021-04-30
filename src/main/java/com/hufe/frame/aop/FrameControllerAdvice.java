package com.hufe.frame.aop;

import com.hufe.frame.bean.po.exception.FrameValidationException;
import com.hufe.frame.bean.po.exception.InterErrorException;
import com.hufe.frame.bean.vo.common.FrameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FrameControllerAdvice {

    @ExceptionHandler(FrameValidationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public FrameResponse frameValidationExceptionHandler(FrameValidationException frameValidationException) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("非法访问")
                .build();
    }

    @ExceptionHandler(InterErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FrameResponse interErrorExceptionHandler(InterErrorException interErrorException) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("未经处理的异常")
                .build();
    }

}
