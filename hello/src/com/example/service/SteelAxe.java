package com.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class SteelAxe implements Axe {

    @Override
    public String chop() {
        return "钢斧砍柴很快";
    }
}
