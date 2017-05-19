package com.zl.dao;

import com.zl.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouliang on 2017-05-16.
 */
public interface SeckillDao {
    /**
     * 对秒杀商品进行减库存
     * @param seckillId
     * @param killTime
     * @return 返回的是数据库中记录更新的行数
     */
    public int reduceSeckill(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据商品id查询商品信息
     * @param seckillId
     * @return id对应的商品信息实体类
     */
    public Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * 参数列表中要用@Param("offset")以及@Param("limit")来修饰的原因是
     * @param offet
     * @param limit
     * @return
     */
    public List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap);
}
