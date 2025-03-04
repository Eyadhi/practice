package trie;

public class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	class TrieNode {
		TrieNode[] children;
		boolean isword;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.isword = false;
		}
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			} else {
				current = current.children[index];
			}
		}
		current.isword = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return (current.isword);
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("cont");
		trie.insert("son");
		System.out.println("Values inserted successfully");
		if (trie.search("ca") == true) {
			System.out.println("Found");
		} else {
			System.out.println("not Found");
		}
	}
}
