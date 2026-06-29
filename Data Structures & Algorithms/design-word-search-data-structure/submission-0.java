class WordDictionary {

   // Define the TrieNode class
    static class TrieNode {
        TrieNode[] children; // Array for child nodes (26 for 'a' to 'z')
        boolean isEndOfWord; // Flag to mark the end of a word

        public TrieNode() {
            children = new TrieNode[26]; // Initialize children array
            isEndOfWord = false;
        }
    }

    private TrieNode root; // Root of the Trie

    // Initialize the WordDictionary object
    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word into the WordDictionary
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create a new node if needed
            }
            current = current.children[index];
        }
        current.isEndOfWord = true; // Mark the end of the word
    }

    // Search for a word, including support for wildcards (.)
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper function for recursive search
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false; // If node is null, word/prefix doesn't exist
        }
        if (index == word.length()) {
            return node.isEndOfWord; // Reached the end of the word
        }

        char c = word.charAt(index);
        if (c == '.') {
            // If current character is '.', try all possible children
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Normal character, follow the corresponding child node
            int charIndex = c - 'a';
            return searchInNode(word, index + 1, node.children[charIndex]);
        }
    }

}
