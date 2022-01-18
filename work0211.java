package Leetcode.smart;


/**
 * leetcode211. 添加与搜索单词 - 数据结构设计
 */
public class work0211 {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        boolean param_2 = obj.search("b.d");
        System.out.println(param_2);

    }

    private static class WordDictionary {

        private WordDictionary[] son;

        private boolean isEnd;

        private int level;

        public WordDictionary() {
            this(0);
        }

        public WordDictionary(int level) {
            son = new WordDictionary[26];
            this.level = level;
        }

        public void addWord(String word) {
            if(word.length() == level) {
                isEnd = true;
                return;
            }
            int index = word.charAt(level) - 'a';
            if(son[index] == null){
                son[index] = new WordDictionary(level+1);
            }
            son[index].addWord(word);
        }

        public boolean search(String word) {
            if(word.length() == level) return isEnd;
            char c = word.charAt(level);
            if(c == '.'){
                for (WordDictionary w : son) {
                    if(w == null) continue;
                    if(w.search(word)) return true;
                }
            }else if (son[c-'a'] != null){
                return son[c-'a'].search(word);
            }
            return false;
        }
    }

}