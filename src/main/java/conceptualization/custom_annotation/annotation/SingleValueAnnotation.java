package conceptualization.custom_annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*refers to the .class file, available to java compiler but not to JVM . It is included in the class file*/
@Retention(RetentionPolicy.CLASS)
public @interface SingleValueAnnotation {

	String reader() default "all";
}
