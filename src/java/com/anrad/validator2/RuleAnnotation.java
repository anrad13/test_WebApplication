/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface RuleAnnotation {
    String errMsg() default "no message";
    Class<? extends Storeable> dto();
    RuleGroup group() default RuleGroup.DEFAULT;
}
