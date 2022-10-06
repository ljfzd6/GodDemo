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
public class GodReply {
Integer id,toid,fromuserid;
String reply;
Date time;


    @Override
    public String toString() {
        return "GodReply{" +
                "id=" + id +
                ", toid=" + toid +
                ", fromuserid=" + fromuserid +
                ", reply='" + reply + '\'' +
                ", time=" + time +
                '}';
    }
}
