package org.suai.courceWork.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.suai.courceWork.models.entities.User;
import org.suai.courceWork.models.forms.UserForm;
import org.suai.courceWork.services.implementations.UserServiceImpl;

@Component
public class UserValidator implements Validator {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserValidator(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
        if(this.userServiceImpl.findFirstByName(userForm.getName()) != null)
            errors.rejectValue("name", "" , "User with that name already exists!");
        if(!userForm.getPassword().equals(userForm.getPasswordConfirm()))
            errors.rejectValue("passwordConfirm", "", "Passwords don't match!");
        if(this.userServiceImpl.findByEmail(userForm.getEmail()) != null)
            errors.rejectValue("email", "", "User with this email already exists!");
    }

}
