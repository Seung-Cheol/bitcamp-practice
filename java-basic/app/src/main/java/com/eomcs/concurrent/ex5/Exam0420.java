// synchronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0420 {
  public static void main(String[] args) {
    Worker w1 = new Worker("홍길");
    Worker w2 = new Worker("꺽정");

    w1.start();
    w2.start();

  }

  synchronized static void play(String threadName) throws InterruptedException {
    System.out.println(threadName);
    Thread.sleep(10000);
  }

  static class Worker extends Thread {
    public Worker(String name) {
      super(name);
    }

    @Override
    public void run() {
      try {
        play(getName());
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    private void delay() {
      int delayCount = (int)(Math.random() * 1000);
      for (int i = 0; i < delayCount; i++)
        Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }
  }

}
