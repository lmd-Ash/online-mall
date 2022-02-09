package com.onlinemall.common;

import com.onlinemall.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

/**
 * 统一异常处理
 * <br/>
 * Created in 2019-02-15 14:02
 *
 * @author lmd
 */
@RestControllerAdvice
@Slf4j
public class MallControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public Result handleException(CustomException e) {
        log.error("\n{}", e.getMessage());
        return Result.build(Msg.FAIL, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleException(MissingServletRequestParameterException e) {
        log.error("\n{}", e.getMessage());
        return Result.build(Msg.FAIL, "参数丢失");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleException(HttpMediaTypeNotSupportedException e) {
        log.error("\n{}", e.getMessage());
        return Result.build(Msg.FAIL, "不支持的数据格式");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleException(HttpMessageNotReadableException e) {
        log.error("\n{}", e.getMessage());
        return Result.build(Msg.FAIL, "参数格式或类型错误");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleException(MethodArgumentNotValidException e) {
        log.error("\n{}", e.getMessage());
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.build(Msg.FAIL, message);
    }

    @ExceptionHandler(BindException.class)
    public Result handleException(BindException e) {
        log.error("\n{}", e.getMessage());
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.build(Msg.FAIL, message);
    }

    /**
     * 全局异常处理
     *
     * @param e       异常
     * @param request HttpServletRequest
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionHandler(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        String uri = request.getRequestURI();
        log.error("服务器异常拦截，当前请求的uri：{}", uri);
        log.error("服务器异常拦截,错误信息=>{}", e.getMessage());
        return Result.build(Msg.SYSTEM_FAIL, Msg.TEXT_SYSTEM_FAIL);
    }

    /**
     * 请求方式错误处理
     *
     * @param e       异常
     * @param request HttpServletRequest
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        e.printStackTrace();
        String uri = request.getRequestURI();
        log.error("请求格式异常拦截，当前请求的uri：{}", uri);
        log.error("请求格式异常拦截,错误信息=>{}", e.getMessage());
        String method = e.getMethod();
        return Result.build(Msg.REQUEST_FAIL, Msg.TEXT_REQUEST_FAIL.replace("[#nowReq#]", "[" + method + "]")
                .replace("[#req#]", Arrays.toString(Objects.requireNonNull(e.getSupportedHttpMethods()).stream().map(Enum::name).toArray())));
    }

    /**
     * sql异常处理
     *
     * @param e       异常
     * @param request HttpServletRequest
     */
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public Result<?> badSqlGrammarException(BadSqlGrammarException e, HttpServletRequest request) {
        e.printStackTrace();
        String uri = request.getRequestURI();
        log.error("服务器异常拦截，当前请求的uri：{}", uri);
        log.error("服务器异常拦截,错误信息=>{}", e.getMessage());
        return Result.build(Msg.SQL_FAIL, Msg.TEXT_SQL_FAIL);
    }
}
