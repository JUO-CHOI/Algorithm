class Solution {
    public int solution(String my_string, String is_suffix) {
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.substring(my_string.length() - (i + 1)).equals(is_suffix))
                return 1;
        }
        return 0;
    }
}