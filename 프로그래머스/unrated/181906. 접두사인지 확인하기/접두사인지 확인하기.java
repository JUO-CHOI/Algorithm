class Solution {
    public int solution(String my_string, String is_prefix) {
        StringBuilder compare = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            compare.append(my_string.charAt(i));
            if (is_prefix.equals(compare.toString())) return 1;
        }
        return 0;
    }
}