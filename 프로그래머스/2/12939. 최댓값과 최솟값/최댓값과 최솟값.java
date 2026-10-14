import java.util.StringTokenizer;

public class Solution {
    public String solution(String s){
        StringTokenizer st = new StringTokenizer(s);
        int[] nums = new int[st.countTokens()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Integer.max(max, nums[i]);
            min = Integer.min(min, nums[i]);
        }

        return min + " " + max;
    }
}
