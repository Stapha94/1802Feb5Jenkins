package com.threads;

public class ThreadMain {

    static class EvenRunnable implements Runnable {

        public static void main(String[] args) {

            Thread thread1 = new Thread(new EvenRunnable(), "Even Thread");
            Thread thread2 = new Thread(new OddRunnable(), "Odd Thread");
            Thread thread3 = new OtherThread("Other Thread");

            thread1.start();
            thread2.start();
            thread3.start();

            try{

                thread1.join();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println("Main Thread");

        }

        @Override
        public void run() {

            int limit = 100;
            int start = 0;

            while(start < limit){

                System.out.println(start);
                start +=2;

            }

        }
    }

    static class OddRunnable implements Runnable {

        @Override
        public void run() {

            int limit = 100;
            int start = 1;

            while(start < limit){

                System.out.println(start);
                start +=2;

            }

        }
    }

    static class OtherThread extends Thread{

        public OtherThread(String name){

            super(name);

        }

        @Override
        public void run() {

            System.out.println("This is the odd man out");

        }

    }

}
