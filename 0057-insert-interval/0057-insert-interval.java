import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> temp = new ArrayList<>();

        boolean inserted = false;

        // Insert new interval in sorted order
        for (int[] curr : intervals) {

            if (!inserted && newInterval[0] < curr[0]) {
                temp.add(newInterval);
                inserted = true;
            }

            temp.add(curr);
        }

        // If new interval has the largest start
        if (!inserted) {
            temp.add(newInterval);
        }

        // Same merge logic as Question 56
        List<int[]> res = new ArrayList<>();

        int start = temp.get(0)[0];
        int end = temp.get(0)[1];

        for (int i = 1; i < temp.size(); i++) {

            int s = temp.get(i)[0];
            int e = temp.get(i)[1];

            if (end >= s) {          // Overlap
                end = Math.max(end, e);
            } else {                 // No overlap
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}