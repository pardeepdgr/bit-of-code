package conceptualization;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ImmutableListTest {

    @Test
    public void should_not_add_any_element_to_immutable_list() {
        List<Integer> list = new ImmutableList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());

        ImmutableList.isUnmodifiable = true;
        list.add(4);
        assertEquals(3, list.size());
    }

}
