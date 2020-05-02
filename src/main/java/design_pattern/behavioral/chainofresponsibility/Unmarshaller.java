package design_pattern.behavioral.chainofresponsibility;

import java.io.File;

import design_pattern.behavioral.chainofresponsibility.bo.Dim;
import design_pattern.behavioral.chainofresponsibility.bo.DimGroup;
import design_pattern.behavioral.chainofresponsibility.bo.Filters;
import design_pattern.behavioral.chainofresponsibility.bo.Parent;

import com.thoughtworks.xstream.XStream;

public class Unmarshaller {

	public Parent unmarshall(String fileName) {
		File xml = new File(fileName);
		XStream stream = new XStream();
		processXStremAnnotations(stream);
		return (Parent) stream.fromXML(xml);
	}
	
	private void processXStremAnnotations(XStream stream) {
		stream.processAnnotations(Dim.class);
		stream.processAnnotations(DimGroup.class);
		stream.processAnnotations(Filters.class);
		stream.processAnnotations(Parent.class);
	}
}
