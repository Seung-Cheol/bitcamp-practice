import java.util.*;
public class Day20 {
//https://school.programmers.co.kr/learn/courses/30/lessons/92334
static class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
      //결과를 담을 배열 생성
        int[] answer = new int[id_list.length];
        //유저이름, 신고한사람, 신고당한사람 hashset으로 (중복을 방지하기 위해 hashset) 포함된 어레이리스트
        ArrayList<User> users = new ArrayList<>();

        //범인목록추가
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        //이름과 인덱스. 인덱스를 통하여 배열에 값을 더하기 위함
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for(String name : id_list) {
          //이름과 인덱스 저장
            idIdx.put(name,idx++);
            //이름저장과 동시에 비어있는 해시셋 저장 후 User 객체 저장
            users.add(new User(name));
        }

        for(String re : report){
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            //유저객체 중에서 신고한유저 객체의 신고자 목록에 추가
            //유저객체 중에서 신고당한유저 객체의 신고당한 목록에 추가
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }

        //신고사이즈가 k보다 클 경우 서스펜디드 리스트에 추가
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        //유저가 신고한 리스트의 배열을 꺼내서 신고자목록에 있다면 answer n번쨰에 1을 추가
         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }

             }
        }
        return answer;
    }
}

static class User{
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}
  
}
