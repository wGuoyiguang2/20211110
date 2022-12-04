package com.example.demo.entity.exception;

/**
 *
 * 异常编码
 * @author zhaoying
 */
public interface BaseExceptionCode {

    /**
     * 异常编码
     *
     * @return 异常编码
     */
    String getCode();

    /**
     * 异常消息
     *
     * @return 异常消息
     */
    String getMsg();


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
