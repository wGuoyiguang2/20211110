package com.example.demo.entity.exception;

/**
 * 非运行期异常基类，所有自定义非运行时异常继承该类
 *
 * @author zhaoying
 * @see RuntimeException
 */
public class BaseUncheckedException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = -778887391066124051L;
    /**
     * 异常信息
     */
    private String message;

    /**
     * 具体异常码
     */
    private String code;

    private String extraCode;
    private String extraMsg;

    public BaseUncheckedException(Throwable cause) {
        super(cause);
    }

    public BaseUncheckedException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }


    public BaseUncheckedException(String code, final String message) {
        super(message);
        this.code = code;
        this.message = message;

    }

    public BaseUncheckedException(String code, final String message, final String extraMsg) {
        super(message);
        this.code = code;
        this.message = message;
        this.extraCode = code;
        this.extraMsg = extraMsg;

    }

    public BaseUncheckedException(String code, final String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BaseUncheckedException(String code, final String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getExtraCode() {
        return extraCode;
    }

    @Override
    public String getExtraMessage() {
        return extraMsg;
    }
}
