package com.jianping.pond.util;

import com.jianping.pond.exception.SysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 存储字符串键值对
     */
    public String setString(String key, String value) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            throw new SysException(e.getMessage());
        } finally {
            jedis.close();
        }
    }
    /**
     * 得到对应键的字符串值
     */
    public String getString(String key) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            throw new SysException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 删除字符串键值对
     */
    public Long delString(String key) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            throw new SysException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 存储对象
     */
    public String setObject(String key, Object value) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key.getBytes(), ObjectUtil.serialize(value));
        } catch (Exception e) {
            throw new SysException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 得到对应键的对象
     */
    public Object getObject(String key) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] byteArr = jedis.get(key.getBytes());
            return ObjectUtil.unSerialize(byteArr);
        } catch (Exception e) {
            throw new SysException(e.getMessage());
        } finally {
            jedis.close();
        }
    }
    public Long delObject(String key) throws SysException {
        Jedis jedis = jedisPool.getResource();
        try {
            Long lg = jedis.del(key.getBytes());
            return lg;
        }catch (Exception e){
            throw new SysException(e.getMessage());
        }finally {
            jedis.close();
        }
    }
}