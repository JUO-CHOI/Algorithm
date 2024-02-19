import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
//        String[] enroll = {"john", "mary", "edward"};
//        String[] referral = {"-", "-", "mary"};
//        String[] seller = {"john", "mary", "mary", "edward", "john"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // enroll index 번호와 이름 매칭시키기
        Map<String, Integer> indexName = new HashMap<>();
        indexName.put("center", -1);
        for (int i  = 0; i < enroll.length; i++) {
            indexName.put(enroll[i], i);
        }

        // 트리정보를 담을 Map
        Map<String, String> treeInfo = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String from = enroll[i]; // 판매자, 수수료 줄 사람
            String to; // 수수료 받을 사람, 소개자
            // "-" 이면 민호 넣어주기
            if (referral[i].equals("-")) {
                to = "center";
            } else {
                to = referral[i];
            }
            treeInfo.put(from, to);
        }

        // 판매 금액 넣어주기
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
//            answer[indexName.get(name)] += amount[i] * 100;
            dfs(treeInfo, name, answer, indexName, amount[i] * 100);
        }

        return answer;
    }

    public static void dfs(Map<String, String> treeInfo, String name, int[] answer, Map<String, Integer> indexName, int money) {
        int giveMoney = (int) (money * 0.1);
        answer[indexName.get(name)] += money - giveMoney;

                if (giveMoney == 0) 
            return;
        
        String upNode = treeInfo.get(name);
        if (indexName.get(upNode) != -1) {
            dfs(treeInfo, upNode, answer, indexName, giveMoney);
        }
    }
}
