package top.wujinxing.starbook.service;

import com.sun.org.apache.xerces.internal.util.AugmentationsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wujinxing.starbook.dao.AuthorDao;
import top.wujinxing.starbook.entity.AuthorInfo;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/14 15:43
 * description
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AugmentationsImpl.class);

    @Autowired
    AuthorDao authorDao;

    @Override
    public List<AuthorInfo> findAll() {
        return authorDao.findAll();
    }

    @Override
    public AuthorInfo insert(AuthorInfo authorInfo) {
        LOGGER.info("新增作家: " + authorInfo.toString() );
        return authorDao.save(authorInfo);
    }

    @Override
    public AuthorInfo update(AuthorInfo authorInfo) {
        LOGGER.info("更新作家: " + authorInfo.toString() );
        return authorDao.save(authorInfo);
    }

    @Override
    public AuthorInfo delete(Long authorId) {
        AuthorInfo authorInfo = authorDao.deleteByAuthorId(authorId);
        authorDao.delete(authorInfo);
        LOGGER.info("删除作家: " + authorInfo.toString() );
        return authorInfo;
    }

    @Override
    public AuthorInfo findById(Long authorId) {
        LOGGER.info("通过作家ID查找："+ authorId);
        return authorDao.findByAuthorId(authorId);
    }
}
