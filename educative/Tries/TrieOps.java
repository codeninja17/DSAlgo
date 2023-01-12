package educative.Tries;

public class TrieOps {

    TrieNode root;

    public TrieOps() {
        root = new TrieNode();
    }

    public int getIndex(char c) {
        return c - 'a';
    }

    public void insert(String key) {
        if (key == null) return;

        TrieNode currentNode = root;
        key = key.toLowerCase();

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = getIndex(c);
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.markAsEndWord();
    }

    public boolean search(String key) {
        if (key == null) return false;

        TrieNode currentNode = root;
        key = key.toLowerCase();

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = getIndex(c);
            if (currentNode.children[index] == null) {

                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.endOfWord;
    }

    public void delete(String key) {
        if (key == null) return;
        deleteHelper(key,root,0);

    }

    public boolean deleteHelper(String key, TrieNode current, int currentIndex) {
        if(currentIndex == key.length()) {
            if(hasChildren(current)){
                current.unmarkAsEndWord();
                return false;
            }
            return true;
        }

        int index = getIndex(key.charAt(currentIndex));
        if(current.children[index] == null) return false;
        boolean res = deleteHelper(key, current.children[index],currentIndex+1);
        if(res) current.children[index] = null;
        else return false;
        return !hasChildren(current) && !current.endOfWord;
    }

    public static void main(String[] args) {
        TrieOps ops = new TrieOps();
        ops.insert("any");
        ops.insert("answer");
        ops.insert("bed");
        ops.insert("bedroom");

        System.out.println(ops.search("b"));
        System.out.println(ops.search("bed"));
        System.out.println(ops.search("bad"));
        System.out.println(ops.search("bedroom"));
        System.out.println(ops.search("an"));
        System.out.println(ops.search("any"));

        ops.delete("answer");

        System.out.println(ops.search("any"));
        System.out.println(ops.search("answer"));



    }

    public boolean hasChildren(TrieNode node){
        for(TrieNode node1 : node.children){
            if(node1!=null) return true;
        }
        return false;
    }
}
