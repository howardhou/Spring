package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class SteelAxe implements Axe {

    @Override
    public String chop() {
        return "钢斧砍柴很快";
    }
}
