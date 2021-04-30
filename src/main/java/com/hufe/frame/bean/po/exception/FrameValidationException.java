package com.hufe.frame.bean.po.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
@Getter
public class FrameValidationException extends RuntimeException {

    private BindingResult result;

}
