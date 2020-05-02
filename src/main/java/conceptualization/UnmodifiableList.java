package conceptualization;

import java.util.ArrayList;
import java.util.List;

public class UnmodifiableList<E> extends ArrayList<E> {

	public static boolean isUnmodifiable = false;

	@Override
	public boolean add(E e) {
		if (!isUnmodifiable)
			return super.add(e);
		else
			return false;
	}
}

class UnmodifiableListTest {

	public static void main(String[] args) {
		List<Integer> list = new UnmodifiableList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		UnmodifiableList.isUnmodifiable = true;
		list.add(4);

		for (Integer element : list) {
			System.out.println(element);
		}
	}
}
