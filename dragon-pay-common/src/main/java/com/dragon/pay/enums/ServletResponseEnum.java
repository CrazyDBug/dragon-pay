package com.dragon.pay.enums;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 赌狗
 * @since 2025-05-24 12:26
 */
@Getter
@AllArgsConstructor
public enum ServletResponseEnum {
    MethodArgumentNotValidException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    MethodArgumentTypeMismatchException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestPartException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    MissingPathVariableException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    BindException(4001 ,"", HttpServletResponse.SC_BAD_REQUEST),
    MissingServletRequestParameterException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    TypeMismatchException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    ServletRequestBindingException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    HttpMessageNotReadableException(4001, "", HttpServletResponse.SC_BAD_REQUEST),
    NoHandlerFoundException(4004, "", HttpServletResponse.SC_NOT_FOUND),
    NoSuchRequestHandlingMethodException(4004, "", HttpServletResponse.SC_NOT_FOUND),
    HttpRequestMethodNotSupportedException(4005, "", HttpServletResponse.SC_METHOD_NOT_ALLOWED),
    HttpMediaTypeNotAcceptableException(4006, "", HttpServletResponse.SC_NOT_ACCEPTABLE),
    HttpMediaTypeNotSupportedException(4015, "", HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE),
    ConversionNotSupportedException(4500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    HttpMessageNotWritableException(4500, "", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    AsyncRequestTimeoutException(4503, "", HttpServletResponse.SC_SERVICE_UNAVAILABLE)
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息，直接读取异常的message
     */
    private String message;
    /**
     * HTTP状态码
     */
    private int statusCode;
}
