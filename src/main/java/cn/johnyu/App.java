package cn.johnyu;

import cn.johnyu.domain.Blog;
import cn.johnyu.domain.Book;
import cn.johnyu.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //首先加载cn/johnyu/mapper/BookMapper.xml然后再加载cn.johnyu.mapper.BookMapper
        //此句与mybatis-config.xml中的<mapper class="cn.johnyu.mapper.BookMapper"/>相同
        sqlSessionFactory.getConfiguration().addMapper(BookMapper.class);
        SqlSession session = sqlSessionFactory.openSession();
        BookMapper mapper = session.getMapper(BookMapper.class);

        Blog blog=session.selectOne("cn.johnyu.mapper.BlogMapper.findBlog",1);
        System.out.println(blog.getAuthor().getUsername());
        blog.getPosts().forEach(post -> System.out.println(post.getTitle()));

//        Book book=new Book();
//        book.setName("john");
//        book.setId(1);

//        Map<String,Object> book=new HashMap<>();
//        book.put("id",1);
//        book.put("name","john");

//        List<Book> books=session.selectList("cn.johnyu.mapper.BookMapper.selectBook2",book);
//        books.forEach(b-> System.out.println(b.getName()));
//        session.select("cn.johnyu.mapper.BookMapper.selectBook2", book, resultContext ->{
//            System.out.println(resultContext.getResultCount());
//            System.out.println();
//        });



//        两种不同风格的查询方式

//        Book book = session.selectOne("cn.johnyu.mapper.BookMapper.selectBook2", 1);
//        Book book1 = mapper.selectBook(1);
//
//        System.out.println(book.getName());
//        System.out.println(book1.getName());


//        List<Book> books=mapper.findAllBooks();
//        books.forEach(book-> System.out.println(book.getName()));


//        Book book=new Book();
//        book.setName("tomson");
//        int rs=mapper.save(book);
//        session.commit();
//        System.out.println(book.getId());


//        Book b=mapper.selectBook(11);
//        b.setName("jackson");
//        int r=mapper.update(b);
//        session.commit();

//        mapper.delete(11);
//        session.commit();


        session.close();


//        纯Java代码方式加载，并生成SqlSessionFactory的方式
//================================================================================================
//        DataSource dataSource = DataSourceFactory.getDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BookMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);


    }
}
