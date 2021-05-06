package com.hufe.frame.service.impl;

import com.hufe.frame.bean.dto.user.UserOrderDTO;
import com.hufe.frame.bean.vo.user.UserOrderShowVO;
import com.hufe.frame.bean.vo.user.UserShowVO;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.repository.UserRepository;
import com.hufe.frame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserShowVO> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserShowVO> result = null;
        if (userEntities != null) {
            result = userEntities.stream().map(u ->
                    UserShowVO.builder()
                            .id(u.getId())
                            .name(u.getName())
                            .build()
            ).collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public UserOrderShowVO getOrderListByUserId(Long userId) {
        // 判断用户是否存在
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            return null;
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
