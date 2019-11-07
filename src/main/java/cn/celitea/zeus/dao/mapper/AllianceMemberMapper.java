package cn.celitea.zeus.dao.mapper;

import cn.celitea.zeus.dao.entity.AllianceMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AllianceMemberMapper {

    int insertSelective(AllianceMember record);

    AllianceMember selectByStuId(String stuId);

    List<AllianceMember> listMembersByLastId(@Param("lastId") int lastId, @Param("len") int len);
}
