package cn.celitea.zeus.common.request;

import lombok.Data;

/**
 * Created by julin on 2019/11/5
 */
@Data
public class MemberForm {

    /**
     * 学号
     * 限制：8位数字
     */
    private String studentId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     * 限制：1男，2女
     */
    private Byte sex;

    /**
     * 出生年月
     * 限制：2019-09 以"-"间隔年月，高位补0
     */
    private String birthDate;

    /**
     * 入学年份
     * 限制：四位数字
     */
    private String admissionYear;

    /**
     * 毕业年份
     * 限制：四位数字
     */
    private String graduationYear;

    /**
     * 专业名
     */
    private String major;

    /**
     * 家乡
     */
    private String hometown;

    /**
     * 当前住址
     */
    private String currentAddress;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 手机号
     * 限制：11位数字
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 博客地址
     */
    private String blogAddress;
}
