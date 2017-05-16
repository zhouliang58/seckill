package com.zl.dao;

import com.zl.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouliang on 2017-05-16.
 */

/**
 * 配置spring和junit整合，在junit启动时加载spring ioc容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceSeckill() throws Exception {
        Long seckillId = 1000L;
        Date date = new Date();
        int i = seckillDao.reduceSeckill(seckillId, date);
        System.out.println(i);
    }

    @Test
    public void queryById() throws Exception {
        Long seckillId = 1000L;
        Seckill seckill = seckillDao.queryById(seckillId);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(2, 2);
        System.out.println(seckills.size());
        System.out.println(seckills.get(0).getName());
        System.out.println(seckills.get(1).getName());
    }

}