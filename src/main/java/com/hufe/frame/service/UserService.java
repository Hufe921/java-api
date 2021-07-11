package com.hufe.frame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hufe.frame.dataobject.vo.user.UserOrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
import com.hufe.frame.model.UserEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService extends IService<UserEntity> {

  CompletableFuture<List<UserShowVO>> findAll();

  UserOrderShowVO getOrderListByUserId(Long id);

}
