class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> canonicalPath = new Stack<>(); 
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!canonicalPath.isEmpty()) {
                    canonicalPath.pop();
                }
            } else if (dir.equals(".") || dir.equals("")) {
                continue;
            } else {
                canonicalPath.add(dir);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : canonicalPath) {
            res.append('/');
            res.append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }
}