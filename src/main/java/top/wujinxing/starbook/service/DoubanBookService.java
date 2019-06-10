package top.wujinxing.starbook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.wujinxing.starbook.entity.DoubanBook;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:31
 * description
 */
public interface DoubanBookService  {

    Page<DoubanBook> findPage(Pageable pageable);

    DoubanBook findById(Integer bookId);
}
