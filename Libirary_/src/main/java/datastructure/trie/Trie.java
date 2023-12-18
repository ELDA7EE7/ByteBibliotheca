package datastructure.trie;

public class Trie {
    private TrieNode root;

    //constructor
    public Trie() {
        root = new TrieNode();
    }

    //insert function
    //takes string and insert it into our tree
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    //boolean search function
    //take string and check if string is
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEnd;
    }
}
