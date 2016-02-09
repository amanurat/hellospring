package com.assanai.spring.mvc.controller.advice;

import com.assanai.spring.mvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by amanurat on 12/16/2015 AD.
 */
@ControllerAdvice
public class UserNotFoundMapperController {



    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server internal error")
    public void serverError() {

    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity could not found")
//    @ResponseBody
    public ErrorResponse notFound() {

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Entity could not found");
    }



    class ErrorResponse {

        public ErrorResponse(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        private Integer code;
        private String desc;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
