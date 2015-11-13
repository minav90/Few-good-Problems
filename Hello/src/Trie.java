class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode nodes[];
    public TrieNode() {
        isWord = false;
        nodes = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
       root = insert(root,word,0);
    }
    
    public TrieNode insert(TrieNode root,String word,int i)
    {
        if(root == null)
          root = new TrieNode();
        if(i == word.length())
         { root.isWord = true;
           return root;
         }
        char c = word.charAt(i);
        root.nodes[c - 'a'] = insert(root.nodes[c - 'a'],word,i+1);
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
        if(word == null || word.length() == 0)
        return false;
        
        return search(root,word,0);
        
    }
    
    public boolean search(TrieNode root,String word,int i)
    {
        if(root == null)
        return false;
        
        if(i == word.length())
        return root.isWord;
        
        char c = word.charAt(i);
        return search(root.nodes[c - 'a'],word,i+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length()==0) return false;
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode node, String prefix, int d){
        if(node == null) return false;
        if(d == prefix.length()){
            return true;
        }
        char c = prefix.charAt(d);
        return startsWith(node.nodes[c-'a'], prefix, d+1);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");