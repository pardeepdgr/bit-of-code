package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private DoublyLinkedList pageList;
	private Map<Integer, Node> pageMap;

	public LRUCache(int cacheSize) {
		pageList = new DoublyLinkedList(cacheSize);
		pageMap = new HashMap<Integer, Node>();
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(4);
		cache(lru, 4);
		cache(lru, 2);
		cache(lru, 3);
		cache(lru, 1);
		cache(lru, 1);
		cache(lru, 2);
		cache(lru, 7);
		cache(lru, 8);
		cache(lru, 2);
		cache(lru, 3);
	}

	private static void cache(LRUCache cache, int pageNumber) {
		cache.accessPage(pageNumber);
		cache.print();
	}

	private void accessPage(int pageNumber) {
		Node pageNode = null;
		if (pageMap.containsKey(pageNumber)) {
			pageNode = pageMap.get(pageNumber);
			pageList.moveNodeToHead(pageNode);
		} else {
			if (pageList.getCurrentSize() == pageList.getSize())
				pageMap.remove(pageList.getTail().getPageNumber());
			pageNode = pageList.addNode(pageNumber);
			pageMap.put(pageNumber, pageNode);
		}
	}

	private void print() {
		pageList.print();
		System.out.println();
	}

}
