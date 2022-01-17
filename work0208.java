package Leetcode.smart;

/**
 * leetcode208. 实现 Trie (前缀树)
 */
public class work0208 {


    public static void main(String[] args) {
        // Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }

    private static class Trie {

        private Trie[] childrens;

        private boolean end;

        private int level;

        public Trie() {
            this(0);
        }

        public Trie(int level){
            childrens = new Trie[26];
            this.level = level;
        }

        public void insert(String word) {
            if(word.length() == level) {
                end = true;
                return;
            }
            char c = word.charAt(level);
            if(childrens[c - 'a'] == null){
                childrens[c - 'a'] = new Trie(level + 1);
            }
            childrens[c - 'a'].insert(word);
        }


        public boolean search(String word) {
            if(word.length() == level) return end;
            char c = word.charAt(level);
            if(childrens[c - 'a'] == null) return false;
            else return childrens[c - 'a'].search(word);
        }

        public boolean startsWith(String prefix) {
            if(prefix.length() == level) return true;
            char c = prefix.charAt(level);
            if(childrens[c - 'a'] == null) return false;
            else return childrens[c - 'a'].startsWith(prefix);
        }
    }

}
