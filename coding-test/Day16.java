import java.util.*;

public class Day16 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/12933
  class Solution1 {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        
        for(int i=0; i<chars.length; i++) {
            for(int a = i; a<chars.length; a++) {
            if(chars[i]<chars[a]) {
                char temp = chars[i];
                chars[i] = chars[a];
                chars[a] = temp;
            }
          }
        }
        answer = Long.parseLong(new String(chars));
        return answer;
    }
  }
  //https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=java
  class Solution2 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i<absolutes.length; i++) {
            if(signs[i]==true) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
//https://school.programmers.co.kr/learn/courses/30/lessons/12919
class Solution3 {
  public String solution(String[] seoul) {
      String answer = "";
      for(int i=0; i<seoul.length; i++) {
          if(seoul[i].equals("Kim")) {
              answer = String.format("김서방은 %d에 있다", i);
          }
      }
      return answer;
  }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12910
class Solution4 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> tempList = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0)
                tempList.add(arr[i]);
        }
        Collections.sort(tempList);
        int[] answer;
        if(tempList.size()==0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[tempList.size()];
            for(int i=0; i<tempList.size(); i++) {
                answer[i] = tempList.get(i);
            }
        }
        return answer;
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=java
class Solution5 {
  public String solution(String phone_number) {
      String answer = "";
      int leng = phone_number.length();
      for(int i = 0; i<leng; i++) {
          if(i<leng-4) {
              answer+="*";
          } else {
              answer+=String.valueOf(phone_number.charAt(i));
          }
      }
      return answer;
  }
}
//https://school.programmers.co.kr/learn/courses/30/lessons/12935#
class Solution6 {
  public int[] solution(int[] arr) {
      for(int i = 0; i<arr.length; i++) {
          for(int a=i; a<arr.length; a++) {
              if(arr[i]<arr[a]) {
                  int temp = arr[i];
                  arr[i] = arr[a];
                  arr[a] = temp;
              }
          }
      }
      int[] answer;
      if(arr.length==1) {
          answer = new int[1];
          answer[0] = -1;
      } else {
          answer = new int[arr.length-1];
          for(int i = 0; i<answer.length; i++) {
              answer[i] = arr[i];
          }
      }
      
      
      return answer;
  }
}

}
