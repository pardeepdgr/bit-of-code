package data_structure.trie;

import data_structure.trie.node.TrieNode;

public class Trie {
	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/* runtime complexity: O(l*n), where l is average length of words and n is number of words */
	public void insert(String word) {
		TrieNode current = root;
		int length = word.length();

		for (int i = 0; i < length; i++) {
			char character = word.charAt(i);
			TrieNode node = current.getChildren().get(character);

			if (node == null) {
				node = new TrieNode();
				current.getChildren().put(character, node);
			}
			current = node;
		}
		current.setEndOfWord(true);
		System.out.println(word + " has been inserted.");
	}

	/* runtime complexity: O(l), where l is length of word */
	public boolean search(String word) {
		TrieNode current = root;
		int length = word.length();

		for (int i = 0; i < length; i++) {
			char character = word.charAt(i);
			TrieNode node = current.getChildren().get(character);

			if (node == null)
				return false;
			current = node;
		}
		/* for prefix based search => return !current.isEndOfWord(); */
		return current.isEndOfWord();
	}

	public void delete(String word) {
		delete(root, word, 0);
	}

	/* runtime complexity: O(l*n), where l is average length of words and n is number of words */
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord())
				return false;
			current.setEndOfWord(false);
			return current.getChildren().size() == 0;
		}
		char character = word.charAt(index);
		TrieNode node = current.getChildren().get(character);
		if (node == null)
			return false;
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
		if (shouldDeleteCurrentNode) {
			current.getChildren().remove(character);
			return current.getChildren().size() == 0;
		}
		return false;
	}
}
