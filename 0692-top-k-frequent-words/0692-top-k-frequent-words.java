import java.util.*;

class Pair {
    int first;       // frequency
    String second;   // word

    Pair(int f, String s) {
        first = f;
        second = s;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                
                // Smaller frequency comes first
                if (a.first != b.first) {
                    return a.first - b.first;
                }

                // For same frequency,
                // lexicographically LARGER word comes first
                return b.second.compareTo(a.second);
            }
        );

        // Step 3: Process every word
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String word = entry.getKey();
            int frequency = entry.getValue();

            Pair curr = new Pair(frequency, word);

            // Heap has space
            if (pq.size() < k) {
                pq.add(curr);
            }

            // Heap is full
            else {
                Pair top = pq.peek();

                // Current word is better than the worst
                if (curr.first > top.first ||
                    (curr.first == top.first &&
                     curr.second.compareTo(top.second) < 0)) {

                    pq.poll();
                    pq.add(curr);
                }
            }
        }

        // Step 4: Create answer
        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll().second);
        }

        // Step 5: Reverse because heap gives worst -> best
        Collections.reverse(ans);

        return ans;
    }
}