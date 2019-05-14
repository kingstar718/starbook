package top.wujinxing.starbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.starbook.entity.AuthorInfo;

/**
 * @author wujinxing
 * date 2019 2019/5/14 15:38
 * description
 */
public interface AuthorDao extends JpaRepository<AuthorInfo, Integer> {
    AuthorInfo deleteByAuthorId(Long authorId);
    AuthorInfo findByAuthorId(Long authorId);
}
