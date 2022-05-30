public class Solution {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> res = new ArrayList<>();
        TrieNode head = new TrieNode();
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            list.add(new Entry(username[i], timestamp[i], website[i]));
        }
		//sort the input list first
        list.sort(Comparator.comparingInt(entry -> entry.time));
		//iterate over the input list, add all of them into the TrieNode cluster
        for (Entry entry : list) {
            if (!head.users.contains(entry.username)) {
                head.users.add(entry.username);
            }
            head.addChild(entry.username, entry.website);
        }
		
		//Recursively get the three websites
        while (!head.children.isEmpty()) {
            head = getWeb(head, res);
        }
        return res;
    }

    TrieNode getWeb(TrieNode head, List<String> res) {
        String[] webArr = head.children.keySet().toArray(new String[0]);
        Arrays.sort(webArr, (s1, s2) -> head.children.get(s2).count - head.children.get(s1).count == 0 ? s1.compareTo(s2) : head.children.get(s2).count - head.children.get(s1).count);
        res.add(webArr[0]);
        return head.children.get(webArr[0]);
    }

    class Entry {
        String username;
        int time;
        String website;

        Entry(String username, int time, String website) {
            this.username = username;
            this.time = time;
            this.website = website;
        }
    }

    class TrieNode {
        int level = 0;
        String website = null;
        int count = 0;
        Map<String, TrieNode> children = new HashMap<>();
        Set<String> users = new HashSet<>();

        int addChild(String username, String website) {
            if (!users.contains(username)) {
			//the website represented by this node has not been visited by the username before, so the input website cannot be added as its child
                return 0;
            }
            if (level < 2) {
			//only node at 0 (means head), 1st position could add a grandchild to its child
                for (String childWeb : children.keySet()) {
                    count = Math.max(count, children.get(childWeb).addChild(username, website));
                }
            }
			//add the child to itself
            TrieNode childNode;
            if (!children.containsKey(website)) {
                childNode = new TrieNode();
                childNode.website = website;
                childNode.level = level + 1;
                children.put(website, childNode);
            }
            childNode = children.get(website);
            if (!childNode.users.contains(username)) {
                if (childNode.level == 3) {
                    childNode.count++;
                }
                childNode.users.add(username);
            }
            if (childNode.level == 3) {
                count = Math.max(count, childNode.count);
            }
            return count;
        }
    }
}