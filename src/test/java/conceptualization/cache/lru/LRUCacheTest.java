package conceptualization.cache.lru;

import conceptualization.cache.lru.model.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LRUCacheTest {
    private Node p1 = new Node(1);
    private Node p2 = new Node(2);
    private Node p3 = new Node(3);
    private Node p4 = new Node(4);
    private Node p7 = new Node(7);
    private Node p8 = new Node(8);

    @Test
    public void should_cache_recently_used_page_numbers() {
        LRUCache lru = new LRUCache(4);

        lru.cache(lru, 4);
        assertEquals(Arrays.asList(p4), lru.getPageList());

        lru.cache(lru, 2);
        assertEquals(Arrays.asList(p2, p4), lru.getPageList());

        lru.cache(lru, 3);
        assertEquals(Arrays.asList(p3, p2, p4), lru.getPageList());

        lru.cache(lru, 1);
        assertEquals(Arrays.asList(p1, p3, p2, p4), lru.getPageList());

        lru.cache(lru, 1);
        assertEquals(Arrays.asList(p1, p3, p2, p4), lru.getPageList());

        lru.cache(lru, 2);
        assertEquals(Arrays.asList(p2, p1, p3, p4), lru.getPageList());

        lru.cache(lru, 7);
        assertEquals(Arrays.asList(p7, p2, p1, p3), lru.getPageList());

        lru.cache(lru, 8);
        assertEquals(Arrays.asList(p8, p7, p2, p1), lru.getPageList());

        lru.cache(lru, 2);
        assertEquals(Arrays.asList(p2, p8, p7, p1), lru.getPageList());

        lru.cache(lru, 3);
        assertEquals(Arrays.asList(p3, p2, p8, p7), lru.getPageList());
    }

}
