package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return List.copyOf(words);
    }

    public void addWord(String word) {
        for (Character c : word.toCharArray()) {
            if (Character.isWhitespace(c)) {
                throw new IllegalArgumentException("It should be one word!");
            }
            if (Character.isUpperCase(c)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> onceOnly = new ArrayList<>();
        for (String word : words) {
            if (onceOnly.contains(word)) {
                return true;
            }
            onceOnly.add(word);
        }
        return false;
    }
}