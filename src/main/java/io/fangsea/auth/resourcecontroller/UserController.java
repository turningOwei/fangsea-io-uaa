package io.fangsea.auth.resourcecontroller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019/5/9 10:19
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @RequestMapping("/user/login")
    public DemoModel userLogin(){
        DemoModel demoModel = new DemoModel();
        demoModel.setCode("0000");
        demoModel.setTraceId("2o9bqeu4l2");
        demoModel.setMsg("0000");
        HashMap data = new HashMap();
        demoModel.setData(data);
        return demoModel;
    }

    @Data
    class DemoModel{
        private String traceId;
        private String code;
        private String msg;
        private HashMap data;
    }

}
