import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] solution(String[] names) {
        List<String> firstPerson = new ArrayList<>();
        for (int i = 0; i < names.length; i += 5) {
            firstPerson.add(names[i]);
        }
        return firstPerson.toArray(new String[0]);
    }
}