import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Person[] members = new Person[n];
        Person[] temp = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];

            members[i] = new Person(age, name);
        }

        mergeSort(members, temp, 0, members.length - 1);

        StringBuilder sb = new StringBuilder();

        for (Person member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);
    }

    public static void mergeSort(Person[] members, Person[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(members, temp, start, mid);
            mergeSort(members, temp, mid + 1, end);
            merge(members, temp, start, mid, end);
        }
    }

    public static void merge(Person[] members, Person[] temp, int start, int mid, int end) {
        // 우선 사용할 만큼 임시배열에 저장
        for (int i = start; i <= end; i++) {
            temp[i] = members[i];
        }

        int part1 = start; // 왼쪽 시작 인덱스
        int part2 = mid + 1; // 오른쪽 시작 인덱스
        int index = start; // 실제 값을 넣어줄 인덱스

        // 서로 값 비교하며 넣어주기
        while (part1 <= mid && part2 <= end) {
            // 앞 배열 사람이 어리거나 나이가 같음
            // 나이가 같으면 앞 배열 사람 넣어줌 -> 일단 앞에 있는 사람이 먼저 가입한 사람임
            if (temp[part1].age <= temp[part2].age) {
                members[index] = temp[part1];
                part1++;
            }
            // part2이 어린 사람
            else {
                members[index] = temp[part2];
                part2++;
            }
            index++;
        }

        // 남은거 넣어주기
        while (part1 <= mid) {
            members[index] = temp[part1];
            part1++;
            index++;
        }
        while (part2 <= end) {
            members[index] = temp[part2];
            part2++;
            index++;
        }
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
