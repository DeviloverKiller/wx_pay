package com.wzh.wx_pay;

import com.wzh.wx_pay.entity.ProductCategory;
import com.wzh.wx_pay.repository.ProductCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WxPayApplicationTests {


    @Test
    public void contextLoads() {

        log.debug("logger日志， debug");
        log.info("logger日志, info级别");
        log.error("logger日志, error级别");
    }

}
