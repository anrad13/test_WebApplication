package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;


@Qualifier
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
public @interface DTOAnnotation {
    Class<? extends Storeable> dto();
}
