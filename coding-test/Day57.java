import java.util.*;
public class Day57 {
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t,0) + 1);
        }
        Collection<Integer> lists = map.values();
        List<Integer> arr = new ArrayList<>();
        for(int i : lists) {
            arr.add(i);
        }
        Collections.sort(arr,Collections.reverseOrder());
        for(int i = 0; i<arr.size(); i++) {
            k -= arr.get(i);
            answer++;
            if(k<=0) {
                break;
            }
        }
        
        return answer;
    }
}
  
}
