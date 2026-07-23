class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean odd = false;
        int res = 0;

        for (int val : map.values()) {

            if (val % 2 == 0) {
                res += val;
            } else {
                res += val - 1;
                odd = true;
            }
        }

        if (odd)
            return res + 1;

        return res;
    }
}