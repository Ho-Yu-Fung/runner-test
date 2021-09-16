package com.example.runnertest;

import com.example.runnertest.other.PropertiesTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

@SpringBootTest
class RunnerTestApplicationTests {
    @Autowired
    PropertiesTest propertiesTest;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        HashMap<Object, Object> map = new LinkedHashMap();
        redisTemplate.opsForZSet().add("ranking","h2x",12);
        redisTemplate.opsForZSet().add("ranking","x2",13);
        Set<ZSetOperations.TypedTuple> set = redisTemplate.opsForZSet().reverseRangeWithScores("ranking", 0, -1);
        Iterator<ZSetOperations.TypedTuple> iterator = set.iterator();
        while (iterator.hasNext()){
            ZSetOperations.TypedTuple item = iterator.next();
            Object value = item.getValue();
            Double score = item.getScore();
            map.put(value,score);
        }
        System.out.println(map);
    }

}
