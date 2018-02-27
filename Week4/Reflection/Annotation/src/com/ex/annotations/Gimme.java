package com.ex.annotations;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by August Duet on 12/15/2016.
 */
@Target(value={ElementType.METHOD}) //this element is only available for methods
@Retention(RetentionPolicy.RUNTIME) //this element is accessible at runtime
public @interface Gimme {
}
