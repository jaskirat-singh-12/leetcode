class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String ch : wordList) {
            set.add(ch);
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int lvl = p.level;

            if(word.equals(endWord)) return lvl;

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    if (word.charAt(i) == ch) {
                        continue;
                    }

                    String s = word.substring(0, i) + ch + word.substring(i+1);

                    if(set.contains(s)) {
                        q.offer(new Pair(s, lvl+1));
                        set.remove(s);
                    }
                }
            }
        }

        return 0;
    }

    class Pair{
        String word;
        int level;

        public Pair(String word, int level) {
            this.level = level;
            this.word = word;
        }
    }
}