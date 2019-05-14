package top.wujinxing.starbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.starbook.entity.UserInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 14:26
 * description
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long>, Serializable {

    public UserInfo findByUserid(long userid);
    public void deleteByUserid(Long userid);
}
