# zeus接口文档

## 接口Response格式

### 格式

```json
{
    "code": "000000",
    "data": {}/[],
    "desc": "成功"
}
```

### 状态码 (code)

```java
SUCCESS("000000","成功"),
SERVER_ERROR("000001","服务错误"),
PARAM_ERROR("000002","参数错误"),
REPEATED_STUID("000003","学号重复")
```



## 接口信息

### 添加接口

/member/add

数据格式 application/json

```java
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
```



### 通过学号查询单个信息

/member/get?studentId=12345678

studentId 为字符串



### 成员列表

/member/list?lastId=0&len=10

lastId 上一页最后一个id（int）非必须参数，默认为0

len 每页长度（int）非必须参数，默认为10