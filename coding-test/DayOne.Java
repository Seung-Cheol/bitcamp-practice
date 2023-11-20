class DayOne {

  //내가 풀었던 오답
  import java.util.Arrays;
  class Solution {
    public String[] solution(String[] players, String[] callings) {
        for (int i=0; i<callings.length; i++) { 
            boolean check = Arrays.asList(players).contains(callings[i]);
            if(check==false) {
                continue;
            }
            for(int a=0; a<players.length; a++) { 
                if((players[a].equals(callings[i])) && (a==0)) {
                    break;
                }
                if(players[a].equals(callings[i])) {
                    String temp = players[a-1];
                    players[a-1] = players[a];
                    players[a] = temp;
                    break;
                }
            }
        }
        String[] answer = players;
        return answer;
    }
}

  //내가 풀었던 방식과 비슷한 정답
  import java.util.HashMap;
  import java.util.Map;
  class Solution {
  
  public String[] solution(String[] players, String[] callings) {
  Map<String, Integer> indexMap = new HashMap<>();
  for (int i = 0; i < players.length; i++) {
      indexMap.put(players[i], i);
  }

  for (int i = 0; i < callings.length; i++) {
      int callingIndex = indexMap.get(callings[i]);
      if (callingIndex > 0) {
          String temp = players[callingIndex-1];
          players[callingIndex-1] = players[callingIndex];
          players[callingIndex] = temp;
          indexMap.put(players[callingIndex], callingIndex);
          indexMap.put(players[callingIndex-1], callingIndex-1);
      }
  }

  return players;
  }
  }
}