class Solution {

    private long hoursRequired(int[] piles, int speed) {

        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1L) / speed;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = hoursRequired(piles, mid);

            if (hours > h) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}