package com.hufe.frame.dataobject.po.exception;

import lombok.Data;

@Data
public class FrameMessageException extends RuntimeException {

  private String message;

  public FrameMessageException(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return this.message;
  }

}
