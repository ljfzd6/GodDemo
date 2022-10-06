package com.ljfzd6.goddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GodUserImage {
public Integer id,userid;
public String identitycard,usericon;

    @Override
    public String toString() {
        return "GodUserImage{" +
                "id=" + id +
                ", userid=" + userid +
                ", identitycard='" + identitycard + '\'' +
                ", usericon='" + usericon + '\'' +
                '}';
    }
}
