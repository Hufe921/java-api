package com.hufe.frame.service;

import com.hufe.frame.dataobject.ao.user.UserAddAO;
import com.hufe.frame.dataobject.ao.user.UserRelationShipAO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;

import java.util.List;

public interface UserService {

    void addUser(UserAddAO params);

    List<UserShowVO> getUser();

    void saveRelationShip(UserRelationShipAO params);

}
