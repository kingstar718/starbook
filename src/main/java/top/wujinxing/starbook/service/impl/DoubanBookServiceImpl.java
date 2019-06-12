package top.wujinxing.starbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.starbook.dao.DoubanBookDao;
import top.wujinxing.starbook.entity.DoubanBook;
import top.wujinxing.starbook.entity.SpiderBookReview;
import top.wujinxing.starbook.service.DoubanBookService;
import top.wujinxing.starbook.utils.DoubanBookReview;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:32
 * description
 */
@Service
@Transactional
public class DoubanBookServiceImpl implements DoubanBookService {

    @Autowired
    private DoubanBookDao doubanBookDao;

    @Override
    public Page<DoubanBook> findPage(Pageable pageable) {
        Page<DoubanBook> doubanBooks = doubanBookDao.findAll(pageable);
        List<DoubanBook> list = doubanBooks.getContent();
        for (DoubanBook d: list
             ) {
            String bookAuthor = d.getBookAuthor();
            String[] author = bookAuthor.split(" / ");
            d.setBookAuthor(author[0]);
        }
        return doubanBookDao.findAll(pageable);
    }

    @Override
    public DoubanBook findById(Integer bookId) {
        return doubanBookDao.findByBookId(bookId);
    }


    @Autowired
    DoubanBookReview doubanBookReview;
    /**
     * 豆瓣书评获取
     * @return
     */
    @Override
    public List<SpiderBookReview> getListBookReview() {
        return doubanBookReview.getList();
    }

    @Override
    public List<SpiderBookReview> getFirstList() {
        return doubanBookReview.getFirstList();
    }
}
