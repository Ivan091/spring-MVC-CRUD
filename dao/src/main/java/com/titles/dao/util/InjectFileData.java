package com.titles.dao.util;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectFileData {

    String value();
}
