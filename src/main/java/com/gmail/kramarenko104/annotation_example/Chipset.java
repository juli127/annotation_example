package com.gmail.kramarenko104.annotation_example;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Chipset {
	String type();
}
