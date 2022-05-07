package com.inventory.service.infrastructure.Cache;

import com.inventory.service.Domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductCacheManager {



    @Autowired
    private RedisTemplate<Integer, Product> template;




    public void put(Integer id, Product entry) {
        template.opsForValue().set(id,entry);
    }


    public Product get(Integer id) {
        return  template.opsForValue().get(id);
    }
}
