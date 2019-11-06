package cn.celitea.zeus.common.response;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by julin on 2019/11/5
 */
public class JSONResult {

    private static final String dataKey = "data";
    private static final String codeKey = "code";
    private static final String descKey = "desc";

    public static JSONObject fail(Status code, Object data) {
        JSONObject result = new JSONObject();
        result.put(codeKey, code.getSatusCode());
        result.put(dataKey, data);
        result.put(descKey, code.getSatusDesc());
        return result;
    }

    public static JSONObject success(Object data) {
        JSONObject result = new JSONObject();
        result.put(codeKey, Status.SUCCESS.getSatusCode());
        result.put(dataKey, data);
        result.put(descKey, Status.SUCCESS.getSatusDesc());
        return result;
    }

}
