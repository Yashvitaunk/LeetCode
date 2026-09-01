import java.util.*;

class Pair {
    int first;
    String second;

    Pair(int f, String s) {
        first = f;
        second = s;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap on first, Min on second
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return a.first - b.first;

                return a.second.compareTo(b.second);
            }
        );

        // Add pairs to heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int frequency = entry.getValue();
            int element = entry.getKey();

            pq.add(new Pair(frequency, String.valueOf(element)));

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = Integer.parseInt(pq.poll().second);
        }

        return ans;
    }
}