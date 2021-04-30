package com.hufe.frame.bean.vo.common;

import com.hufe.frame.bean.vo.user.UserShowVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FrameResponse<T> {

    private T data;

    private String errorDetail = null;

    private Boolean success = true;

    public FrameResponse(T data) {
        this.data = data;
    }
}
