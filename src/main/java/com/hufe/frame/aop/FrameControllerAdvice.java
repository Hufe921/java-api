package com.hufe.frame.aop;

import com.hufe.frame.bean.po.exception.FrameValidationException;
import com.hufe.frame.bean.po.exception.InterErrorException;
import com.hufe.frame.bean.vo.common.FrameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class FrameControllerAdvice {

    @ExceptionHandler({BindException.class, ValidationException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public FrameResponse validationExceptionHandler(Exception exception) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("参数不合法：" + exception.toString())
                .build();
    }

    @ExceptionHandler(FrameValidationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public FrameResponse frameValidationExceptionHandler(FrameValidationException frameValidationException) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("非法访问：" + frameValidationException.toString())
                .build();
    }

    @ExceptionHandler(InterErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FrameResponse interErrorExceptionHandler(InterErrorException interErrorException) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("内部服务异常：" + interErrorException.toString())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public FrameResponse exceptionHandler(Exception exception) {
        return FrameResponse.builder()
                .success(false)
                .errorDetail("未经处理的异常：" + exception.toString())
                .build();
    }

}
