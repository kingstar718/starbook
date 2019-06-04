package top.wujinxing.starbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.wujinxing.starbook.dao.BookReviewDao;
import top.wujinxing.starbook.entity.BookReview;
import top.wujinxing.starbook.service.BookreviewService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:51
 * description
 */
@Service
public class BookreviewServiceImpl implements BookreviewService {

    @Autowired
    private BookReviewDao bookReviewDao;

    @Override
    public List<BookReview> getBookReviewList() {
        return bookReviewDao.findAll();
    }

    @Override
    public BookReview findByReviewid(long reviewid) {
        BookReview bookReview = bookReviewDao.findByReviewid(reviewid);
        String rs = bookReview.getReviewcontent();
        //System.out.println(rs);
        String[] s = rs.split("。");
        StringBuffer rc = new StringBuffer();
        for (String c: s
             ) {
            StringBuffer sb = new StringBuffer(c);
            sb.insert(0,"<p>");
            sb.append("。</p>");
            rc.append(sb);  //更改逻辑,将文字内容以句号结尾的算分行, 重新设置内容, 前端thymeleaf使用th:utext解析字符串内的标签
        }
        bookReview.setReviewcontent(String.valueOf(rc));
        //System.out.println(rs);
        return bookReview;
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<BookReview> findPage(Pageable pageable) {
        return bookReviewDao.findAll(pageable);
    }
}
