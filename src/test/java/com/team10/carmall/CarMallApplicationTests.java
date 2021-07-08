package com.team10.carmall;

import com.team10.settings.service.DicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class CarMallApplicationTests {
    @Autowired
    private DicService dicService;

    @Test
    void contextLoads() {
        Map<String, Object> goodsType = dicService.getGoodsType(true);
        System.out.println(goodsType.size());
    }

}
