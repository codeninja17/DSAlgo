package educative.Tries;

public class TrieNode {

    TrieNode [] children;
    boolean endOfWord;

    static final int ALPHABET_COUNT = 26;
    public TrieNode() {
        this.children = new TrieNode[ALPHABET_COUNT];
        this.endOfWord = false;
    }

    public void markAsEndWord(){
        this.endOfWord = true;
    }

    public void unmarkAsEndWord(){
        this.endOfWord = false;
    }

}
