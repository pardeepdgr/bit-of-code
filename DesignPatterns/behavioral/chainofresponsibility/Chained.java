package chainofresponsibility;

import java.util.List;
import java.util.Map;

import chainofresponsibility.bo.Parent;

public interface Chained {

	public abstract Map<String, List<String>> load(Parent parent);

	public abstract void setNextHandler(Chained chain);

}
