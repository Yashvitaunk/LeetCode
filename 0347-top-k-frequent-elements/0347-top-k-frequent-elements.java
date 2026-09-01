import java.util.*;

class Pair {
    int first;    // frequency
    int second;   // element

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap
        // First: Min frequency
        // Second: Min element
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first) {
                    return a.first - b.first;
                }

                return a.second - b.second;
            }
        );

        // Step 3: Traverse the frequency map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int element = entry.getKey();
            int frequency = entry.getValue();

            Pair curr = new Pair(frequency, element);

            // Heap has less than k elements
            if (pq.size() < k) {
                pq.add(curr);
            }

            // Heap is full
            // Add curr only if its frequency is greater
            // than the smallest frequency in the heap
            else if (curr.first > pq.peek().first) {
                pq.poll();
                pq.add(curr);
            }
        }

        // Step 4: Create answer
        int[] ans = new int[k];

        // Step 5: Get elements from heap
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().second;
        }

        return ans;
    }
}