package com.assanai.spring.mvc.validate;


import com.assanai.spring.mvc.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {

        return User.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {

        User user = (User) target;


        if (user != null) {
            ValidationUtils.rejectIfEmpty(errors, "userName", "username.required", "NotEmpty.user.userName");
            ValidationUtils.rejectIfEmpty(errors, "password", "password.required", "NotEmpty.user.password");
            ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required", "NotEmpty.user.gender");
            /*if (user.getUserName() != null) {
                if (user.getUserName().length() < 5 || user.getUserName().length() > 10) {
                    errors.rejectValue("userName", "username.size", new Integer[]{5, 10}, "Must between 5 and 10 characters");
                }
            }*/


        }
    }
}
