package cn.celitea.zeus.common.builders;

import cn.celitea.zeus.common.request.MemberForm;
import cn.celitea.zeus.common.utils.CheckUtil;
import cn.celitea.zeus.common.utils.StringUtils;
import cn.celitea.zeus.dao.entity.AllianceMember;

import java.time.LocalDate;

/**
 * Created by julin on 2019/11/5
 */
public class MemberBuilder {

    public static AllianceMember formToBO(MemberForm form) {
        boolean isValid = CheckUtil.checkMemberForm(form);
        if (!isValid) return null;
        AllianceMember bo = new AllianceMember();
        bo.setStudentId(form.getStudentId());
        bo.setName(form.getName());
        bo.setSex(form.getSex());
        bo.setBirthDate(form.getBirthDate());
        bo.setAdmissionYear(form.getAdmissionYear());
        bo.setGraduationYear(form.getGraduationYear());
        bo.setMajor(form.getMajor());
        bo.setHometown(form.getHometown());
        bo.setCurrentAddress(form.getCurrentAddress());
        bo.setCompany(form.getCompany());
        bo.setPhone(form.getPhone());
        bo.setMail(form.getMail());
        bo.setBlogAddress(form.getBlogAddress());
        return bo;
    }
}
