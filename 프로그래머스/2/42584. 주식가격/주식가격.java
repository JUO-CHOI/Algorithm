import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        List<Integer> pricesList = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            pricesList.add(prices[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            int num = 0;
            int check = pricesList.get(i); // 확인할 가격
            for (int j = i + 1; j < pricesList.size(); j++) {
                int compare = pricesList.get(j); // 그 다음 주식의 가격
                num = j - i;
                if (check > compare) break;
            }
            answer[i] = num;
        }
        return answer;
    }
}
