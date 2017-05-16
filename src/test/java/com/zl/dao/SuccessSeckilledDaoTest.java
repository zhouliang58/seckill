package com.zl.dao;

import com.zl.entity.SuccessSeckilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhouliang on 2017-05-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessSeckilledDaoTest {
    @Resource
    private SuccessSeckilledDao successSeckilledDao;

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        //第一次测试返回1，第二次测试返回0
        Long seckillId = 1000L;
        Long userPhone = 15243616117L;
        int i = successSeckilledDao.insertSuccessKilled(seckillId, userPhone);
        System.out.println(i);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        Long seckillId = 1000L;
        Long userPhone = 15243616117L;
        SuccessSeckilled successSeckilled = successSeckilledDao.queryByIdWithSeckill(seckillId, userPhone);
        System.out.println(successSeckilled);
        System.out.println(successSeckilled.getSeckill());
    }

}