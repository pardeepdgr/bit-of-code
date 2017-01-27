package CustomAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* @Target tag is used to specify at which type, the annotation is used.
 * TYPE				class, interface or enumeration
 * FIELD			fields
 * METHOD			methods
 * CONSTRUCTOR		constructors
 * LOCAL_VARIABLE	local variables
 * ANNOTATION_TYPE	annotation type
 * PARAMETER		parameter 
 */
@Target(ElementType.METHOD)
/*
 * By default, annotations are not inherited to subclasses. The @Inherited
 * annotation marks the annotation to be inherited to subclasses.
 */
@Inherited
/* refers to the runtime, available to java compiler and JVM */
@Retention(RetentionPolicy.RUNTIME)
/* The @Documented Marks the annotation for inclusion in the documentation */
@Documented
@interface MultiValueAnnotation {

	int auotherID() default -1;

	String author() default "NewUser";

	int reputationPoints() default 0;
}
