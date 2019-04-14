package com.timisakura.controller.portal;

import com.timisakura.shiro.UserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNAME ClearShiroCache
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/14 9:35
 * @Version
 */
@RestController
public class ClearShiroCache {
    @Autowired
    private UserRealm userRealm;
    @RequestMapping("/clearShiroCache.do")
    public String clearShiroCache(){

        //清除缓存，将来正常开发要在service调用customRealm.clearCached()
        userRealm.clearCached();

        return "success";
    }
}
