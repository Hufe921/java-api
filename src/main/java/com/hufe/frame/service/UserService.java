package com.hufe.frame.service;

import com.hufe.frame.dataobject.vo.user.UserOrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    CompletableFuture<List<UserShowVO>> findAll();

    UserOrderShowVO getOrderListByUserId(Long id);

}
