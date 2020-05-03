package conceptualization.custom_annotation;

import conceptualization.custom_annotation.annotation.MultiValueAnnotation;

import java.lang.reflect.Method;

public class AnnotationParser {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		AnnotationParser parser = new AnnotationParser();
		Method method = parser.getClass().getMethod("parse");

		MultiValueAnnotation annotation = method.getAnnotation(MultiValueAnnotation.class);
		System.out.println("auotherID: " + annotation.auotherID() 
				+ " author: " + annotation.author() 
				+ " reputationPoints: " + annotation.reputationPoints());
	}

	@MultiValueAnnotation(auotherID = 1, author = "Pardeep", reputationPoints = 10)
	public void parse() {
		System.out.println("parsing multi value annotation");
	}
}
