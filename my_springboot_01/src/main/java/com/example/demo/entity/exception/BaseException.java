package com.example.demo.entity.exception;

/**
 * 异常接口类
 * @author zhaoying
 */
public interface BaseException {

    /**
     * 统一参数验证异常码
     */
    String BASE_VALID_PARAM = "F000003";

    /**
     * 返回异常信息
     *
     * @return 异常信息
     */
    String getMessage();

    /**
     * 返回异常编码
     *
     * @return 异常编码
     */
    String getCode();

    /**
     * 业务异常码
     * @return
     */
    String getExtraCode();

    /**
     * 业务异常信息
     * @return
     */
    String getExtraMessage();

}
