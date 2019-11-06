package cn.celitea.zeus.common.response;

import lombok.Getter;

/**
 * Created by julin on 2019/11/5
 */
public enum Status {
    SUCCESS("000000","成功"),
    SERVER_ERROR("000001","服务错误"),
    PARAM_ERROR("000002","参数错误"),
    REPEATED_STUID("000003","学号重复")
    ;

    @Getter
    private String SatusCode;
    @Getter
    private String SatusDesc;

    Status(String SatusCode, String SatusDesc) {
        this.SatusCode = SatusCode;
        this.SatusDesc = SatusDesc;
    }
}
