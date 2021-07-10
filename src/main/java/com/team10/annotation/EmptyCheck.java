package com.team10.annotation;

import java.lang.annotation.*;

/**
 * 用于对前端传递过来的参数判空
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 1:28:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EmptyCheck {

}
