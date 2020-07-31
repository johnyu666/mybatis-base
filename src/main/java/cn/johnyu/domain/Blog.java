package cn.johnyu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Blog {
    private Integer id;
    private String title;
    private Author author;
    private List<Post> posts=new ArrayList<>();
}
