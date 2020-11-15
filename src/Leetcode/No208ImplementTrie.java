package Leetcode;

public class No208ImplementTrie {
    Node root;

    public class Node{
        boolean end;
        Node[] next;
        Node(){
            end = false;
            next = new Node[26];
        }
    }

    public No208ImplementTrie(){
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word);
    }

    private void insert(Node node, String word){
        if(word.isEmpty()){
            node.end = true;
            return;
        }
        int n = word.charAt(0) - 'a';
        if(node.next[n] == null){
            node.next[n] = new Node();
            insert(node.next[n], word.substring(1));
        }else{
            insert(node.next[n], word.substring(1));
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node node, String word){
        if(word.isEmpty()) return node.end;
        int n = word.charAt(0) - 'a';
        if(node.next[n] == null) return false;
        return search(node.next[n], word.substring(1));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            int n = prefix.charAt(i) - 'a';
            if(node.next[n] == null) return false;
            node = node.next[n];
        }
        return true;
    }

    public static void main(String[] args) {
        No208ImplementTrie trie = new No208ImplementTrie();
//        trie.insert("insert");
//        trie.insert("search");
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));;
//        System.out.println(trie.search("app"));;
//        System.out.println(trie.startsWith("app"));;
        trie.search("a");
    }
}
