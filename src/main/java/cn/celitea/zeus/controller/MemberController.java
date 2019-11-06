package cn.celitea.zeus.controller;


import cn.celitea.zeus.common.builders.MemberBuilder;
import cn.celitea.zeus.common.request.MemberForm;
import cn.celitea.zeus.common.response.JSONResult;
import cn.celitea.zeus.common.response.Status;
import cn.celitea.zeus.dao.entity.AllianceMember;
import cn.celitea.zeus.service.MemberService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by julin on 2019/10/31
 */
@RestController
@Slf4j
@RequestMapping(value="/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/hello")
    public String hello() {
        log.info("Hello World");
        return "Hello World";
    }

    @RequestMapping("/add")
    public JSONObject add(@RequestBody MemberForm member) {
        AllianceMember allianceMember = MemberBuilder.formToBO(member);
        if (allianceMember == null) return JSONResult.fail(Status.PARAM_ERROR, null);
        if (memberService.verifyStuIdUnique(allianceMember.getStudentId())) {
            boolean result = memberService.addAllianceMember(allianceMember);
            if (result)
                return JSONResult.success(null);
            else
                return JSONResult.fail(Status.SERVER_ERROR, null);
        }else
            return JSONResult.fail(Status.REPEATED_STUID, null);
    }
}
