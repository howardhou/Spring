package com.example.service;

import org.springframework.stereotype.Component;

// 指定 Bean的实例名(id)为axe
@Component("axe")
public class StoneAxe implements Axe {

    @Override
    public String chop() {
        return "石头做的斧子砍柴很慢";
    }
}
