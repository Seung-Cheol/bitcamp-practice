// synchronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0530 {
  public static void main(String[] args) {
    Job job1 = new Job();
    Job job2 = new Job();
    Worker w1 = new Worker("홍길", job1);
    Worker w2 = new Worker("꺽정", job2);

    w1.start();
    w2.start();

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
