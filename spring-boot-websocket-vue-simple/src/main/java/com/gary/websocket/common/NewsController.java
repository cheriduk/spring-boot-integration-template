package com.gary.websocket.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/send")
    public String send() {
        Websocket.sendMessage("这是websocket群发消息！");
        return "发送消息成功";
    }

}
