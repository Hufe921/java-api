package com.hufe.frame.service.impl;

import com.hufe.frame.dataobject.ao.user.UserAddAO;
import com.hufe.frame.dataobject.ao.user.UserRelationShipAO;
import com.hufe.frame.dataobject.po.exception.FrameMessageException;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.repository.UserRepository;
import com.hufe.frame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private MapperFactory mapperFactory;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void addUser(UserAddAO params) {
    UserEntity sourceUser = UserEntity.builder()
            .name(params.getName())
            .gender(params.getGender())
            .build();
    userRepository.save(sourceUser);
  }

  @Override
  public List<UserShowVO> getUser() {
    List<UserEntity> userEntities = userRepository.findAll();
    return mapperFactory
            .getMapperFacade()
            .mapAsList(userEntities, UserShowVO.class);
  }

  @Override
  public void saveRelationShip(UserRelationShipAO params) {
    Optional<UserEntity> source = userRepository.findById(params.getSourceId());
    Optional<UserEntity> target = userRepository.findById(params.getTargetId());
    if (!source.isPresent() || !target.isPresent()) {
      throw new FrameMessageException("未找到节点");
    }
    UserEntity sourceUser = source.get();
    if (sourceUser.getStakeholders() == null) {
      sourceUser.setStakeholders(Collections.singletonList(target.get()));
    } else {
      sourceUser.getStakeholders().add(target.get());
    }
    userRepository.save(sourceUser);
  }

}
