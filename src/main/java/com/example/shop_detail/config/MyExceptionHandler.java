package com.example.shop_detail.config;

import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.exception.CustomizeException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Enumeration;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultData resolveConstraintViolationException(ConstraintViolationException e) {
        ResultData result = new ResultData();
        //系统自定义异常
        log.error(e.getMessage(), e);
        return result.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData resolveMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ResultData result = new ResultData();
        //拦截参数异常
        log.error(e.getBindingResult().getFieldError().getDefaultMessage());
        return result.error(ResultEnum.PARAM_ERROR.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());
    }


    /**
     * 系统自定义异常
     *
     * @param e 异常
     * @return resultData
     */
    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public ResultData systemExceptionHandler(HttpServletRequest request, SystemException e) {
        ResultData result = new ResultData();
        //系统自定义异常
        log.error(String.format("requestUrl ={%s}，params ={%s}, token={%s},appid={%s}",
                request.getRequestURI(), getParams(request), request.getHeader("Authorization"), request.getHeader("APPID")));
        log.error(e.getMessage(), e);

        return result.error( e.getMessage());
    }

    /**
     * 系统业务异常（用户业务操作异常）
     *
     * @param e 异常
     * @return resultData
     */
    @ExceptionHandler(value = CustomizeException.class)
    @ResponseBody
    public ResultData customizeExceptionHandler(HttpServletRequest request, CustomizeException e) {
        ResultData result = new ResultData();
        log.error(String.format("requestUrl ={%s}，params ={%s},token={%s},appid={%s}",
                request.getRequestURI(), getParams(request), request.getHeader("X-Auth-Token"), request.getHeader("APPID")));
        return result.error(e.getCode(), e.getErrMsg());
    }

    /**
     * 系统其它异常
     *
     * @param e 异常
     * @return resultData
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, Exception e) {
        ResultData result = new ResultData();
        //其他异常
        log.error(String.format("requestUrl ={%s}，params ={%s},token={%s},appid={%s}",
                request.getRequestURI(), getParams(request), request.getHeader("X-Auth-Token"), request.getHeader("APPID")));
        log.error(e.getMessage(), e);
        return result.error(e.getMessage());
    }

    private String getParams(HttpServletRequest request) {
        Enumeration<String> enu = request.getParameterNames();
        StringBuilder param = new StringBuilder(" ");
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            param.append(paraName).append(":【").append(request.getParameter(paraName)).append("】 ");
        }
        return param.toString();
    }
}
