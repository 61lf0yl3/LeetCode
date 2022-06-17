class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> words = new Stack<>();
        Stack<Integer> repetitions = new Stack<>();
        
        int times = 0;
        StringBuilder currWord = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                currWord.append(c);
            } else if (Character.isDigit(c)) {
                times = times*10 + (c-'0');
            } else if (c == '[') {
                words.add(currWord);
                currWord = new StringBuilder();
                
                repetitions.add(times);
                times = 0;
                
            } else if (c == ']') {
                StringBuilder decodedWord = words.pop();
                for (int i = repetitions.pop(); i > 0; i--) {
                    decodedWord.append(currWord);
                }
                currWord = decodedWord;
            }
        }
        return currWord.toString();
    }
}