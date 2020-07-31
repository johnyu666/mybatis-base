package cn.johnyu.mapper;

import cn.johnyu.domain.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;

public class BlogMapperTest {
    static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //首先加载cn/johnyu/mapper/BookMapper.xml然后再加载cn.johnyu.mapper.BookMapper
        //此句与mybatis-config.xml中的<mapper class="cn.johnyu.mapper.BookMapper"/>相同
        sqlSessionFactory.getConfiguration().addMapper(BookMapper.class);
        SqlSession session = sqlSessionFactory.openSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
    }
    @Test
    public void testSelectBook(){

    }
    @Test public void testFindBlog(){
        SqlSession session = sqlSessionFactory.openSession();
        Blog blog=session.selectOne("cn.johnyu.mapper.BlogMapper.findBlog",1);
        System.out.println(blog.getAuthor().getUsername());
        blog.getPosts().forEach(post -> System.out.println(post.getTitle()));
        session.close();
    }
}
