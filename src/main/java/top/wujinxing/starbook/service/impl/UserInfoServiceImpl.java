package top.wujinxing.starbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.starbook.dao.UserInfoDao;
import top.wujinxing.starbook.entity.UserInfo;
import top.wujinxing.starbook.service.UserInfoService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 14:30
 * description
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> getUserList() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findByUserid(long userid) {
        return userInfoDao.findByUserid(userid);
    }

    @Override
    public void deleteByUserid(Long userid) {
        userInfoDao.deleteByUserid(userid);
    }

    @Override
    public void insert(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    public Page<UserInfo> findByPage(Pageable pageable) {
        return userInfoDao.findAll(pageable);
    }
}
