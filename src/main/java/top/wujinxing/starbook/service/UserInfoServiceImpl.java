package top.wujinxing.starbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.starbook.dao.UserInfoDao;
import top.wujinxing.starbook.entity.UserInfo;

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
}
