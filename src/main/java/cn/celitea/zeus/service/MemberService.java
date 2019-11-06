package cn.celitea.zeus.service;

import cn.celitea.zeus.dao.entity.AllianceMember;
import cn.celitea.zeus.dao.mapper.AllianceMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by julin on 2019/11/5
 */
@Service
@Slf4j
public class MemberService {

    @Autowired
    private AllianceMemberMapper allianceMemberMapper;

    public boolean addAllianceMember(AllianceMember record) {
        try {
            int num = allianceMemberMapper.insertSelective(record);
            return num == 1;
        } catch (Exception e) {
            log.error("Insert AllianceMember error!", e);
            return false;
        }
    }

    public boolean verifyStuIdUnique(String stuId) {
        return allianceMemberMapper.selectByStuId(stuId) == null;
    }
}
