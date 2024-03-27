import java.util.*;
public class Day46 {
class Solution {
    public int[] solution(int n, String[] words) {
        int answer = 0;
        char lastWord = words[0].charAt(words[0].length()-1);
        List<String> arr = new ArrayList<>();
        arr.add(words[0]);
        for(int i = 1; i<words.length; i++) {
            if(words[i].charAt(0)!=lastWord) {
                answer = i+1;
                break;
            }
            if(arr.contains(words[i])) {
                answer = i+1;
                break;
            }
            arr.add(words[i]);
            lastWord = words[i].charAt(words[i].length()-1);
        }
        
        if(answer==0) {
            return new int[]{0,0};
        }
        int[] ar = new int[2];
        //나눴을때 값이 0인경우는 n이 첫번쨰 올 값이고 answer가 3이고 3번쨰일때 당연히 첫번째임
        //이전 번째에 속하니까 +1을 해줄 필요가 없다
        if(answer%n==0) {
            ar[0] = n;
            ar[1] = answer/n;
        } else {
        //나눴을때 값이 0이 아닌 경우는 해당번째에서 놀고 있으므로 기본적으로 +1을 해줘야 함
            ar[0] = answer%n;
            ar[1] = answer/n + 1;
        }
        return ar;
    }
}
}
