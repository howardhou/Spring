package com.example.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

// 使用 @Component 标注一个普通的 Spring Bean 类
// 未指定 id 时， 会使用默认的 id, 即：chinese
@Component
public class Chinese implements Person {
    // @Resource 也可以直接用在 Field 上
    private Axe axe;

    // 使用 @Resource 配置依赖，将 steelAxe 注入到 setter 方法
    @Resource(name = "steelAxe")
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

}
