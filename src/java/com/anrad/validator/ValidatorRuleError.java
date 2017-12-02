package com.anrad.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface ValidatorRuleError {
    String errMsg() default "no message";
}
