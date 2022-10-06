package com.ljfzd6.goddemo.entity.mongodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

//写入的集合名
@Document( "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Comment implements Serializable {
    //主键标识，会自动对应_id字段
    @Id
    private  String id;
    //属性值对应mongodb的字段名，如果一样，则无需该注解
    @Field("username")
    private  String fromuser;
    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", fromuser='" + fromuser + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
