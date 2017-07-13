package com.lmig.moviedb;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MovieValidator implements Validator {

    /**
     * This Validator validates *just* Movie instances
     */
    public boolean supports(Class clazz) {
        return Movie.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Movie m = (Movie) obj;
        if (m.getYear() < 1875) {
            e.rejectValue("year", "tooLow");
        } else if (m.getYear() > 2017) {
            e.rejectValue("year", "tooHigh");
        }
    }
}