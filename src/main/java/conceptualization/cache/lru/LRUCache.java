package conceptualization.cache.lru;

import conceptualization.cache.lru.model.Node;
import data_structure.linkedlist.DoublyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private DoublyLinkedList pageList;
	private Map<Integer, Node> pageMap;

	public LRUCache(int cacheSize) {
		pageList = new DoublyLinkedList(cacheSize);
		pageMap = new HashMap<Integer, Node>();
	}

	public void cache(LRUCache cache, int pageNumber) {
		cache.accessPage(pageNumber);
	}

	private void accessPage(int pageNumber) {
		Node pageNode;
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

	public ArrayList<Node> getPageList() {
		return pageList.toArrayList();
	}

}
