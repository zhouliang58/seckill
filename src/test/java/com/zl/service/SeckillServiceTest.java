package com.zl.service;

import com.zl.dto.Exposer;
import com.zl.dto.SeckillExecution;
import com.zl.entity.Seckill;
import com.zl.exception.RepeatKillException;
import com.zl.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouliang on 2017-05-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
         "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("seckillList={}",seckillList);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill={}",seckill.toString());
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000L);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        String md5 = "b2bbca5b8f1c0107a6b6aff0e5fbac8c";
        SeckillExecution seckillExecution = seckillService.executeSeckill(1000L, 17673045085L, md5);
        logger.info("seckillExecution={}",seckillExecution);
    }

    //完整逻辑代码测试，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long seckillId = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            logger.info("exposer={}",exposer);
            long userPhone = 13476191876L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
            } catch (RepeatKillException e) {
                e.printStackTrace();
            } catch (SeckillCloseException e1) {
                e1.printStackTrace();
            }
        } else {
            //秒杀未开启
            logger.info("exposer={}",exposer);
        }
    }

}