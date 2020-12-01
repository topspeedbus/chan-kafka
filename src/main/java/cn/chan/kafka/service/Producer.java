package cn.chan.kafka.service;

import cn.chan.kafka.entities.User;
import com.google.gson.Gson;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: chan
 * @Date: 2020/12/1 - 11:01
 * @Describe:
 */
@Component
public class Producer {
    @Resource
    private KafkaTemplate kafkaTemplate;

    public void send(String name) {
        User u = new User();
        u.setName(name);
        u.setAge(11);
        Gson gson = new Gson();
        String json = gson.toJson(u);

        kafkaTemplate.send("user", json);
    }
}
