package top.wujinxing.starbook.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.wujinxing.starbook.entity.AuthorInfo;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wujinxing
 * date 2019 2019/5/14 16:41
 * description
 */
public class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @Test
    public void findAll() {
        List<AuthorInfo> list = authorService.findAll();
        for (AuthorInfo a: list
             ) {
            System.out.println(a.toString());
        }
    }

    @Test
    public void insert() {
        AuthorInfo author = new AuthorInfo();
        long id = 2;
        author.setAuthorId(id);
        author.setAuthorName("周树人");
        author.setAuthorAlias("鲁迅");
        Date date = new Date();
        author.setAuthorBirth(date);
        author.setAuthorMagnumopus("狂人日记");
        author.setAuthorNationality("中国");
        authorService.insert(author);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }
}