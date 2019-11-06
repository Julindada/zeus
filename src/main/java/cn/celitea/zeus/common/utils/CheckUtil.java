package cn.celitea.zeus.common.utils;


import cn.celitea.zeus.common.request.MemberForm;

/**
 * 校验工具类
 *
 * Created by julin on 2019/11/5
 */
public class CheckUtil {

    public static boolean checkMemberForm(MemberForm form) {
        if (!StringUtils.isNumeric(form.getStudentId(), 8)) return false;
        String[] birth =StringUtils.splitStr(form.getBirthDate(), "-");
        if (birth.length != 2 || !StringUtils.isNumeric(birth[0], 4) || !StringUtils.isNumeric(birth[1], 2)) return false;
        if (!StringUtils.isNumeric(form.getAdmissionYear(), 4) || !StringUtils.isNumeric(form.getGraduationYear(), 4) || !StringUtils.isNumeric(form.getPhone(), 11)) return false;
        return true;
    }
}
