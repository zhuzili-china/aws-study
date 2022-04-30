package com.deloitte.jenkinsstudy.controller;

import com.deloitte.jenkinsstudy.entity.vo.UserinfoVO;
import com.deloitte.jenkinsstudy.service.UserinfoPOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制器
 *
 * @author Administrator
 * @date 2022/04/30
 */
@RestController
@RequestMapping("userinfo")
@Slf4j
@RequiredArgsConstructor
public class UserinfoController {

    private final RedisTemplate<String,Object> redisTemplate;

    private final UserinfoPOService userinfoPOService;

    /**
     * 保存用户信息（rds）
     * @return  是否成功
     */
    @PostMapping("/rds/save")
    public String saveRdsUserInfo(@RequestBody UserinfoVO userinfoVO) {
        log.info("保存用户信息");
        userinfoPOService.save(UserinfoVO.convertToUserinfoPo(userinfoVO));
        return "保存用户信息成功";
    }

    /**
     * 保存用户信息(redis)
     * @return  是否成功
     */
    @PostMapping("/redis/save")
    public String saveRedisUserInfo(@RequestBody UserinfoVO userinfoVO) {
        log.info("保存用户信息");
        redisTemplate.opsForValue().set("userinfo",userinfoVO);
        return "保存用户信息成功";
    }

    /**
     * 获取用户信息(redis)
     */
    @GetMapping("/redis/get")
    public UserinfoVO getRedisUserInfo() {
        log.info("获取用户信息");
        return (UserinfoVO) redisTemplate.opsForValue().get("userinfo");
    }
}
