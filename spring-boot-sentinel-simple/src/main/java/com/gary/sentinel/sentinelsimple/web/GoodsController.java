package com.gary.sentinel.sentinelsimple.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.gary.sentinel.sentinelsimple.service.GoodsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsQueryService goodsQueryService;

    /**
     * 代码不加任何限流 熔断
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    @SentinelResource("test")
    public String test() {
        return "test";
    }

    @RequestMapping("/queryGoodsInfo")
    @ResponseBody
    public String queryGoodsInfo(@RequestParam("spuId") String spuId) {
        String res = goodsQueryService.queryGoodsInfo(spuId);
        return res;
    }
}
