package com.hufe.frame.service.impl;

import com.hufe.frame.dataobject.dto.user.UserOrderDTO;
import com.hufe.frame.dataobject.po.exception.FrameMessageException;
import com.hufe.frame.dataobject.vo.user.UserOrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
import com.hufe.frame.mapper.UserMapper;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.repository.UserRepository;
import com.hufe.frame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<UserShowVO>> findAll() {

        List<UserEntity> userEntities = userMapper.selectList(null);
        return CompletableFuture.completedFuture(mapperFactory.getMapperFacade()
                .mapAsList(userEntities, UserShowVO.class));
    }

    @Override
    public UserOrderShowVO getOrderListByUserId(Long userId) {
        // 判断用户是否存在
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new FrameMessageException("用户不存在");
        }
        List<UserOrderDTO> userOrderList = userRepository.getOrderListByUserId(userId);
        if (!userOrderList.isEmpty()) {
            return UserOrderShowVO.builder()
                    .id(user.get().getId())
                    .name(user.get().getName())
                    .userOrderDTOList(userOrderList)
                    .build();
        }
        return null;
    }

}
