package com.hufe.frame.bean.vo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FrameResponse<T> {

    private T data;

    private String errorDetail = null;

    private Boolean success = true;

    public FrameResponse(T data) {
        this.data = data;
    }
}
