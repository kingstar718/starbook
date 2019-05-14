package top.wujinxing.starbook.service;

import top.wujinxing.starbook.entity.AuthorInfo;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/14 15:41
 * description
 */
public interface AuthorService {
    List<AuthorInfo> findAll();
    AuthorInfo insert(AuthorInfo authorInfo);
    AuthorInfo update(AuthorInfo authorInfo);
    AuthorInfo delete(Long authorId);
    AuthorInfo findById(Long authorId);
}
