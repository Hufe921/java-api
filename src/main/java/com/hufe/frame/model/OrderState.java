package com.hufe.frame.model;

public enum OrderState {

  INIT(0),
  DOING(1),
  ERROR(2),
  SUCCESS(3);

  private Integer value;

  OrderState(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
