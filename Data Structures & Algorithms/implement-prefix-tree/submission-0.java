class PrefixTree {
  static class TrieNode {
        TrieNode[] children; // Array to store references to child nodes
        boolean isEndOfWord; // Flag to indicate if a word ends at this node

        // Constructor
        public TrieNode() {
            children = new TrieNode[26]; // For 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    private TrieNode root; // Root node of the Trie

    // Initialize the PrefixTree object
    public PrefixTree() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Map character to index (0-25)
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            current = current.children[index]; // Move to the next node
        }
        current.isEndOfWord = true; // Mark the end of the word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // Word not found
            }
            current = current.children[index];
        }
        return current.isEndOfWord; // Return true if it's the end of a word
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // Prefix not found
            }
            current = current.children[index];
        }
        return true; // Prefix exists
    }
   
}
