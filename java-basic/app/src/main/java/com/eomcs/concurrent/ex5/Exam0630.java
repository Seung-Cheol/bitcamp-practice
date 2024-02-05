// synchronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0630 {
  public static void main(String[] args) {
    Job job1 = new Job();
    Job job2 = new Job();
    Worker1 w1 = new Worker1("홍길", job1);
    Worker2 w2 = new Worker2("꺽정", job1);
    Worker3 w3 = new Worker3("관순 ", job1);
    Worker4 w4 = new Worker4("중근", job1);

    w1.start();
    w2.start();
    w3.start();
    w4.start();

  }
  static class Job {
    //같은 변수를 동시에 변경하지 못하게 하
    synchronized void play1(String threadName) throws InterruptedException {
      System.out.println(threadName +"play1 호출");
      Thread.sleep(10000);
    }
    synchronized void play2(String threadName) throws InterruptedException {
      System.out.println(threadName+ "play2호출");
      Thread.sleep(10000);
    }
    void play3(String threadName) throws InterruptedException {
      System.out.println(threadName+ "play3 호출");
      Thread.sleep(10000);
    }
  }

  static class Worker1 extends Thread {
    Job job;
    public Worker1(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play1(getName());
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

  static class Worker2 extends Thread {
    Job job;
    public Worker2(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play2(getName());
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

  static class Worker3 extends Thread {
    Job job;
    public Worker3(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play3(getName());
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

  static class Worker4 extends Thread {
    Job job;
    public Worker4(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play3(getName());
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }

}
