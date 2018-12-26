package indi.viyoung.viboot.util;

/**
 * @author yangwei
 * @since 2018/12/20
 */
public enum ReturnCode {

    /** 操作成功 */
    SUCCESS("SUCCESS_CODE", "SUCCESS_MSG"),

    /** 操作失败 */
    FAIL("FAIL_CODE", "FAIL_MSG"),

    /** 空指针异常 */
    NullpointerException("NPE_CODE", "NPE_MSG"),

    /** 自定义异常之返回值为空 */
    NullResponseException("NRE_CODE", "NRE_MSG");


    private ReturnCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
