package com.ex.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by August Duet on 12/15/2016.
 */
@Target(ElementType.TYPE) //this element is available for types only
@Retention(RetentionPolicy.RUNTIME) //this element is accessible at runtime
public @interface Custom {
    String author() default "Default Author";
    String comment() default "";
}
