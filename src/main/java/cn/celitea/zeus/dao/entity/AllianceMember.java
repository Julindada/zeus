package cn.celitea.zeus.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AllianceMember implements Serializable {
    private Integer id;

    private String studentId;

    private String name;

    private Byte sex;

    private String birthDate;

    private String admissionYear;

    private String graduationYear;

    private String major;

    private String hometown;

    private String currentAddress;

    private String company;

    private String phone;

    private String mail;

    private String blogAddress;

    private Date createTime;

    private Date updateTime;

}
