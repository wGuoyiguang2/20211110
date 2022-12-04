package com.example.demo.entity.exception;

/**
 * 业务异常
 * 用于在处理业务逻辑时，进行抛出的异常。
 *
 * @author zhaoying
 */
public class BizException extends BaseUncheckedException {

    private static final long serialVersionUID = -3843907364558373817L;

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String code, Throwable cause) {
        super(code, cause);
    }

    public BizException(String message) {
        super("-1", message);
    }


    public BizException(String code, String message) {
        super(code, message);
    }

    public BizException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public BizException(String code, String message, Object... args) {
        super(code, message, args);
    }

    public BizException( String code,  String message, String extraCode,  String extraMsg) {
        super(code,message,extraCode,extraMsg);
    }

    /**
     * 实例化异常
     *
     * @param code    自定义异常编码
     * @param message 自定义异常消息
     * @param args    已定义异常参数
     * @return 异常实例
     */
    public static BizException wrap(String code, String message, Object... args) {
        return new BizException(code, message, args);
    }

    public static BizException wrap(String code, String message, String extraCode, String extraMsg ) {
        return new BizException(code, message, extraCode,extraMsg);
    }


    public static BizException wrap(String message, Object... args) {
        return new BizException("-1", message, args);
    }

    public static BizException validFail(String message, Object... args) {
        return new BizException("-9", message, args);
    }

    public static BizException wrap(BaseExceptionCode ex) {
        return new BizException(ex.getCode(), ex.getMsg(),ex.getExtraCode(),ex.getExtraMessage());
    }

    public static BizException wrap(BaseExceptionCode ex, Throwable cause) {
        return new BizException(ex.getCode(), ex.getMsg(),ex.getExtraCode(),ex.getExtraMessage(), cause);
    }

    @Override
    public String toString() {
        return "BizException [message=" + getMessage() + ", code=" + getCode() + ", extraCode=" + getCode()+ ", extraMsg=" + getCode()+ "]";
    }

}
