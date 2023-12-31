package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam002 {

  static int promptReturnInt(String literal) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(literal);
    int len = keyScan.nextInt();
    keyScan.close();
    return len;
  }

  static void printStars(int starLen) {
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }
  public static void main(String[] args) {
    int len = promptReturnInt("밑변의 길이");

    int starLen = 1;
    while (starLen <= len) {
      // 별 앞에 공백 출력
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");
        spaceCnt++;
      }

      // 별 출력


      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }
}