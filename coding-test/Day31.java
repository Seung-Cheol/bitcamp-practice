import java.util.*;
public class Day31 {
class Solution1 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12982
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int b : d) {
            if((budget = budget - b) >= 0) {
                answer++;
            } else {
              break;
            }
        }
        return answer;
    }
}

class Solution2 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/131705
  public int solution(int[] number) {
      int answer = 0;
      for(int i =0; i<number.length; i++) {
          for(int j=i+1; j<number.length; j++) {
              for(int a=j+1; a<number.length; a++) {
                  if(number[i]+number[j]+number[a]==0) {
                      answer++;
                  }
              }
          }
      }
      return answer;
  }
}

class Solution3 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/86491
  public int solution(int[][] sizes) {
      int answer = 0;
      int length = 0;
      int height = 0;
      for(int[] size : sizes) {  
          int temp = 0;
          if(size[1] > size[0]) {
              temp = size[0];
              size[0] = size[1];
              size[1] = temp;
          }
          if(size[0] > length) {
              length = size[0];
          }
          
          if(size[1] > height) {
              height = size[1];
          }
          
      }
      return length*height;
  }
}


class Solution4 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12926
  public String solution(String s, int n) {
      String answer = "";
      
      for(int i = 0; s.length() > i; i++) {
          if(s.charAt(i) <65 || s.charAt(i) > 122) {
              answer += s.charAt(i);
              continue;
          }
          
          
          int temp = s.charAt(i) + n;
          if(s.charAt(i) >=65 && s.charAt(i) <=90) {
              if(temp >90) {
                  temp = temp - 90 + 65 - 1;
              }
          }
          if(s.charAt(i) >90) {
              if(temp >122) {
                  temp = temp - 122 + 97 - 1;
              }
          }  
         answer += String.valueOf((char)temp);
      }
      return answer;
  }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/81301
class Solution {
    public int solution(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        String answer = "";
        String temp = "";
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) < 65) {
                answer = answer + s.charAt(i);
                continue;
            }
            
            temp = temp + s.charAt(i);
            if(map.containsKey(temp)) {
                answer = answer + map.get(temp);
                temp = "";
            }
        }
        return Integer.valueOf(answer);
    }
}

}
