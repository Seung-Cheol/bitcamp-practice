public class Day17 {
//https://school.programmers.co.kr/learn/courses/30/lessons/12935
  //오답 테스트케이스 오류로 인하여 잘못된듯. 
  //내림차순으로 배열을 해야한다고 생각했는데, 그냥 전체중에 최소값 제거 후 배열 안하고 리턴해야했음
  class Solution {
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
        if(arr.length==0 || arr.length==1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[arr.length-1];
            for(int i = 0; i<answer.length; i++) {
                answer[i] = arr[i];
            }
        }
        
        
        return answer;
    }
}

//정답
class Solution2 {
  public int[] solution(int[] arr) {
    //배열의길이가 1일경우 -1 리턴
      if(arr.length == 1){
          int[] answer = {-1};
          return answer;
      }
      //arr길이의 -1만큼 생성
      int[] answer = new int[arr.length-1];

      //
      int minIndex=0;

      //arr만큼
      for(int i=0;i<arr.length;i++){
        //저장되어있는 최소인덱스의 값이 비교하는 값보다 더 큰경우 minindex 변경, 결국 제일 작은 값 걸러내기
          if(arr[minIndex]>arr[i]){
              minIndex = i;
          }
      }
      //최소값 다음부터 재배열 (최소값 없애기)
      for(int i=minIndex+1;i<arr.length;i++){
          arr[i-1] = arr[i];
      }
      //answer값에 옮겨담기
      for(int i=0;i<answer.length;i++){
          answer[i] = arr[i];
      }
      return answer;
  }
}
}
