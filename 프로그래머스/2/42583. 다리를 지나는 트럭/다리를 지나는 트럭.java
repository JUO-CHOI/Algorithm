import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] trucks = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(100, 100, trucks));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTruck = new LinkedList<>();
        for (int truck : truck_weights) {
            waitingTruck.add(truck);
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int nowWeight = 0;
        while (!bridge.isEmpty()) { 
            time++;
            int out = bridge.remove();
            nowWeight -= out;
            if (!waitingTruck.isEmpty() && nowWeight + waitingTruck.peek() <= weight) {
                int truck = waitingTruck.remove();
                bridge.add(truck);
                nowWeight += truck;
            }
            else if (!waitingTruck.isEmpty() && bridge.size() < bridge_length){
                bridge.add(0);
            }
        }
        return time;
    }
}