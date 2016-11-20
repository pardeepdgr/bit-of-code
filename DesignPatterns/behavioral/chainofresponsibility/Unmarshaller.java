package chainofresponsibility;

import java.io.File;

import chainofresponsibility.bo.Dim;
import chainofresponsibility.bo.DimGroup;
import chainofresponsibility.bo.Filters;
import chainofresponsibility.bo.Parent;

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
