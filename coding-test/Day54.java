import java.util.*;
class Day54 {
    class Solution {
        //https://school.programmers.co.kr/learn/courses/30/lessons/12953
        public int solution(int[] arr) {
            Arrays.sort(arr);
            for(int i = 0; i<arr.length-1; i++) {
                int temp1 = arr[i];
                int temp2 = arr[i+1];

                while(temp1 != temp2) {
                    if(temp1 < temp2) {
                        temp1 += arr[i];
                    }

                    if(temp1 > temp2) {
                        temp2 += arr[i+1];
                    }
                }
                arr[i+1] = temp1;
            }
            return arr[arr.length-1];
        }
    }
}