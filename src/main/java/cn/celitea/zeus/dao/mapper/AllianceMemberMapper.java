package cn.celitea.zeus.dao.mapper;

import cn.celitea.zeus.dao.entity.AllianceMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllianceMemberMapper {

    int insertSelective(AllianceMember record);

    AllianceMember selectByStuId(String stuId);
}
