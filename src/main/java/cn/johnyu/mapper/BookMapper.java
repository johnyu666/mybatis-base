package cn.johnyu.mapper;

import cn.johnyu.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Select("select * from book where id=#{id}")
    Book selectBook(@Param(value = "id") int id);

    @Select("select * from book")
    List<Book> findAllBooks();

    @Insert(value = "insert into book (name) values(#{name})")
    @SelectKey(before = false,keyProperty = "id",keyColumn = "id", statement = "select max(id) from book",resultType = Integer.class)
    int save(Book book);

    @Update("update book set name=#{name} where id=#{id}")
    int update(Book book);

    @Delete("delete from book where id=#{id}")
    int delete(int id);

}
