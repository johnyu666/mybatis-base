package cn.johnyu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private Integer id;
    private String username;
    private String password;
    private String bio;
}
