public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String delimeter = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(delimeter);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String delimeter = Character.toString((char) 257);
        //if (s.equals(delimeter)) return new ArrayList<>();
        return Arrays.asList(s.split(delimeter, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));