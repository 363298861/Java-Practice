package Leetcode;

public class No211WordDictionary {

    Node root;

    public class Node{
        private boolean end;
        private Node[] next;
        Node(){
            end = false;
            next = new Node[26];
        }

    }


    /** Initialize your data structure here. */
    public No211WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(root, word);
    }

    private void addWord(Node node, String word){
        if(word.isEmpty()){
            node.end = true;
            return;
        }
        int n = word.charAt(0) - 'a';
        if(node.next[n] == null)
            node.next[n] = new Node();
        addWord(node.next[n], word.substring(1));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node node, String word){
        if(node == null) return false;
        if(word.isEmpty() && node.end) return true;
        if(word.isEmpty()) return false;
        char first = word.charAt(0);
        if(first == '.'){
            for(int i = 0; i < 26; i++){
                if(search(node.next[i], word.substring(1))) return true;
            }
            return false;
        }else{
            int n = first - 'a';
            return search(node.next[n], word.substring(1));
        }
    }

    public static void main(String[] args) {
        No211WordDictionary wd = new No211WordDictionary();
        wd.addWord("a");
        wd.addWord("ab");

        System.out.println(wd.search("a"));
        //System.out.println(wd.search("bad"));
        //System.out.println(wd.search("b.c"));
    }
}
