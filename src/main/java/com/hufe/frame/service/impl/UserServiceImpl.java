package com.hufe.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hufe.frame.dataobject.dto.user.UserOrderDTO;
import com.hufe.frame.dataobject.po.exception.FrameMessageException;
import com.hufe.frame.dataobject.vo.user.UserOrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
import com.hufe.frame.mapper.UserMapper;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

  @Autowired
  private MapperFactory mapperFactory;

  @Autowired
  private UserMapper userMapper;

  @Override
  @Async("asyncExecutor")
  public CompletableFuture<List<UserShowVO>> findAll() {
    QueryWrapper<UserEntity> qw = new QueryWrapper<>();
    qw.eq("is_active", true);
    List<UserEntity> userEntities = this.list(qw);
    return CompletableFuture.completedFuture(mapperFactory.getMapperFacade()
            .mapAsList(userEntities, UserShowVO.class));
  }

  @Override
  public UserOrderShowVO getOrderListByUserId(Long userId) {
    QueryWrapper<UserEntity> qw = new QueryWrapper<>();
    qw.eq("is_active", true);
    UserEntity user = userMapper.selectOne(qw);
    if (user == null) {
      throw new FrameMessageException("用户不存在");
    }
    List<UserOrderDTO> userOrderList = userMapper.getOrderListByUserId(userId);
    if (!userOrderList.isEmpty()) {
      return UserOrderShowVO.builder()
              .id(user.getId())
              .name(user.getName())
              .userOrderDTOList(userOrderList)
              .build();
    }
    return null;
  }

}
