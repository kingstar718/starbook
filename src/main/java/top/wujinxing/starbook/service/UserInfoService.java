package top.wujinxing.starbook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.wujinxing.starbook.entity.UserInfo;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 14:29
 * description
 */
public interface UserInfoService {

    public List<UserInfo> getUserList();

    public UserInfo findByUserid(long userid);

    public void deleteByUserid(Long userid);

    void insert(UserInfo userInfo);

    //分页查询
    Page<UserInfo> findByPage(Pageable pageable);
}
