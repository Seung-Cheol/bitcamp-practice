// synchronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0540 {
  public static void main(String[] args) {
    Job job1 = new Job();
    Job job2 = new Job();
    Worker w1 = new Worker("홍길", job1);
    Worker w2 = new Worker("꺽정", job1);
    Worker w3 = new Worker("유관", job1);
    Worker w4 = new Worker("김구", job2);
    Worker w5 = new Worker("안중", job2);
    Worker w6 = new Worker("윤봉", job2);

    w1.start();
    w2.start();
    w3.start();
    w4.start();
    w5.start();
    w6.start();

  }
  static class Job {
    synchronized void play(String threadName) throws InterruptedException {
      System.out.println(threadName);
      Thread.sleep(10000);
    }
  }

  static class Worker extends Thread {
    Job job;
    public Worker(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play(getName());
        delay();
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
