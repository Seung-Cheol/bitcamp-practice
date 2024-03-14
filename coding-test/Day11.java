import java.util.*;
import java.util.stream.Collectors;

public class Day11 {

//https://school.programmers.co.kr/learn/courses/30/lessons/133502#
//내가 푼 문제 ( 오답 )
//문제를 잘못 이해 함
class Solution {
    public int solution(int[] ingredient) {
        List<Integer> tempList = 
            Arrays.stream(ingredient).boxed().collect(Collectors.toList());
        int answer = 0;
        int temp = 0;
        for(int i = 0; i<tempList.size(); i++) {
            switch(tempList.get(i)) {
                case 1:
                    if(temp==3) {
                        temp = 0;
                        answer++;
                        tempList.remove(i);
                        i--;
                    }
                    if(temp==0) {
                        temp = 1;
                        tempList.remove(i);
                        i--;
                    }
                    break;
                case 2:
                    if(temp==1) {
                        temp = 2;
                        tempList.remove(i);
                        i--;
                    }
                    break;
                case 3:
                    if(temp==2) {
                        temp = 3;
                        tempList.remove(i);
                        i--;
                    }
                    break;
            }
        }
        return answer;
    }





}

//arrayList 없이 푸는 예제
class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        //배열의 시작을 언제부터 해야하는지. 빵이 완성됐으면 -4를 해줘야 함
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            //빵의 완성은 적어도 sp>=4임
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}

  
}
