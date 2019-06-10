package top.wujinxing.starbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.starbook.entity.DoubanBook;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:28
 * description
 */
public interface DoubanBookDao extends JpaRepository<DoubanBook, Integer> {

    DoubanBook findByBookId(Integer bookId);
}
