package conceptualization;

import java.util.ArrayList;

public class ImmutableList<E> extends ArrayList<E> {

    public static boolean isUnmodifiable = false;

    @Override
    public boolean add(E e) {
        if (!isUnmodifiable)
            return super.add(e);
        else
            return false;
    }

}
