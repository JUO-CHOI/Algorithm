class Solution {
    boolean solution(String s) {

        int right = 0;
        int left = 0;
        for (char bracket : s.toCharArray()) {
            if (bracket == '(') left++;
            else right++;
            if (right > left) return false;
        }
        if (right == left) return true;
        else return false;
    }
}