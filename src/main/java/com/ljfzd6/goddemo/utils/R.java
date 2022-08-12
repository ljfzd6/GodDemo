package com.ljfzd6.goddemo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class R {
    Integer flag;
    Object data;

    @Override
    public String toString() {
        return "R{" +
                "flag=" + flag +
                ", data='" + data + '\'' +
                '}';
    }
}
