package com.ljfzd6.goddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GodComment {
Integer id,userid;
String comment;
Date time;

    @Override
    public String toString() {
        return "GodComment{" +
                "id=" + id +
                ", userid=" + userid +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}';
    }
}
