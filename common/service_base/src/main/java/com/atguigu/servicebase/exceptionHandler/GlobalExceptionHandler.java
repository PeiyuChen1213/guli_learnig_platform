package com.atguigu.servicebase.exceptionHandler;

import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  同一异常处理类
 */

//控制异常处理的范围是在所有带controller注解的类
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 统一异常处理器
     * @param e 捕获到的异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        //捕捉到的异常
        e.printStackTrace();
        log.error("捕获到异常"+e.getMessage());
        return R.error().message(e.getMessage());
    }

    /**
     *  处理特定的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了自定义异常");
    }

    @ExceptionHandler(CustomerException.class)
    public R error(CustomerException e){
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
