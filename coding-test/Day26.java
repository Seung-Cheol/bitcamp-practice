import java.util.*;
public class Day26 {
//https://school.programmers.co.kr/learn/courses/30/lessons/42840
class Solution {
    public int[] solution(int[] answers) {
      //특정 번째마다 규칙이 있을때는 나누기를 이용.
       //0번쨰는 5번째랑 똑같고 1번째는 6번쨰랑 똑같음 = 5로 나눴을떄 나머지가 같은 숫자는 값이 같음
        int[] first_list = new int[]{1,2,3,4,5};
        //0번째는 8번째랑 똑같고 1번째는 9번째랑 똑같음 = 8로 나눴을떄 나머지가 같은 숫자 값이 같음
        int[] second_list = new int[]{2,1,2,3,2,4,2,5};
        //0번째는 10번쨰랑 똑같고 1번쨰는 11번째랑 똑같음 = 10으로 나눴을 떄 나머지가 같은 숫자 값이 같음
        int[] third_list = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int first = 0;
        int second = 0;
        int third = 0;
        for(int i = 0; answers.length>i; i++) {
            if(answers[i] == first_list[i%first_list.length]) {
                first++;
            }
            
            if(answers[i] == second_list[i%second_list.length]) {
                second++;
            }
            
            if(answers[i] == third_list[i%third_list.length]) {
                third++;
            }
        }
        int[] tempList = new int[]{first,second,third};
        List<Integer> arr = new ArrayList<>();
        
        int max = 0;
        for(int i = 0; i<tempList.length; i++) {
            if(tempList[i] > max) {
                max = tempList[i];
            }
        }
        
        for(int i = 0; i<tempList.length; i++) {
            if(tempList[i] == max) {
                arr.add(i+1);
            }
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i = 0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}
}
