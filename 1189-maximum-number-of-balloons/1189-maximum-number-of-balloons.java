class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int valueOfB = 0;
        int valueOfA = 0;
        int valueOfL = 0;
        int valueOfO = 0;
        int valueOfN = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if(key == 'b') {
                valueOfB = value;
            }
            if(key == 'n') {
                valueOfN = value;
            }
            if(key == 'a') {
                valueOfA = value;
            }
            if(key == 'l') {
                valueOfL = value / 2;
            }
            if(key == 'o') {
                valueOfO = value / 2;
            }

        };
        int val1 = Math.min(Math.min(valueOfB, valueOfA), valueOfL);
        int val2 = Math.min(Math.min(val1, valueOfO), valueOfN);

        return val2;
    }
}