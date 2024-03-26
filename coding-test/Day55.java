import java.util.*;
public class Day55 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12914
class Solution {
    public long solution(int n) {
        long answer = 0L;
        //피보나치수열
        if(n==1) {
            return 1L;
        }
        if(n==2) {
            return 2L;
        }
        long[] arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<=n; i++) {
            arr[i] = arr[i-1]%1234567L + arr[i-2]%1234567L;
        }
         return arr[arr.length-1]%1234567L;
    }
}
  
}
