package top.wujinxing.starbook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.starbook.dao.DoubanBookDao;
import top.wujinxing.starbook.entity.DoubanBook;
import top.wujinxing.starbook.entity.SpiderBookReview;
import top.wujinxing.starbook.service.DoubanBookService;
import top.wujinxing.starbook.utils.DoubanBookReview;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:32
 * description
 */
@Service
@Transactional
public class DoubanBookServiceImpl implements DoubanBookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoubanBookServiceImpl.class);

    @Autowired
    private DoubanBookDao doubanBookDao;

    @Autowired
    private RedisTemplate redisTemplate;


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

    /**
     * 使用redis缓存爬虫获取的信息
     * @param num
     * @return List<SpiderBookReview>
     */
    @Override
    public List<SpiderBookReview> getReviewByNum(Integer num) {
        String key = num.toString();
        // 无法使用 StringRedisTemplate, 会导致下面的语句报错
        ValueOperations<String, List> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        List<SpiderBookReview> list = null;
        if (hasKey){
            list = operations.get(key);
            LOGGER.info("存缓存中获取了书评信息!");
            return list;
        }
        // 缓存中没有, 使用爬虫获取
        list = doubanBookReview.getListByNum(num);
        // 将得到的数据存入redis
        operations.set(num.toString(), list,10, TimeUnit.MINUTES);//设置为10分钟的有效期
        LOGGER.info("爬虫获取, 并存入缓存, 缓存值为: " + operations.get(key));
        return list;
    }

    @Override
    public Page<SpiderBookReview> findReviewPage(int start, int size) {
        Pageable pageable = PageRequest.of(start, size, Sort.by(Sort.Direction.ASC, "isUseful"));
        List<SpiderBookReview> list = doubanBookReview.getList();
        long totalCharacters = 10;
        Page<SpiderBookReview> page = new PageImpl<>(list, pageable, totalCharacters);
        return page;
    }
}
