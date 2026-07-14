class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map =  new HashMap<>();

        map.put(0,-1);
        int zero =0, one = 0, res =0;

        for(int i =0 ;i<nums.length; i++){
            if(nums[i] == 0)
            zero++;
            else
               one++;
               int diff = zero -one;

               if(map.containsKey(diff))
               res = Math.max(res, i-map.get(diff));
                  else 
                  map.put(diff, i);

        }
        return res;
    }
}