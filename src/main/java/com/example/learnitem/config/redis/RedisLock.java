package com.example.learnitem.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config.redis
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-12 14:49.
 * @Description:
 */
@Slf4j
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * redis 加锁
     *
     * @param key   锁-名称
     * @param value 当前时间+ 超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key, value))) {
            log.info("[分布式锁]{}直接加锁成功", key);
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上有个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                log.info("[分布式锁]{}续期加锁成功", key);
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
                log.info("[分布式锁]{}解锁成功", key);
            }
        } catch (Exception e) {
            log.error("[redis分布式锁]解锁异常,{}", e.getMessage());
        }
    }
}
