package com.example.listener;

import com.example.event.EmailEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof EmailEvent){
            EmailEvent emailEvent = (EmailEvent)applicationEvent;

            System.out.println("需要发送邮件的接收地址 ： "+ emailEvent.getAddress());
            System.out.println("需要发送邮件的正文 ： "+ emailEvent.getText());
        }
        else {
            System.out.println("容器本身的事件 ："+applicationEvent);
        }
    }
}
