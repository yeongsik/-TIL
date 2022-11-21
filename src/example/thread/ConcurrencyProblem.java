package example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 출처 https://deveric.tistory.com/104

/*
    멀티 스레드 환경에서 동시성 제어 방법
    1. 암시적 lock
    2. 명시적 lock
    3. volatile
    4. Concurrent 패키지 사용
    5. 불변객체
 */
public class ConcurrencyProblem {
    public static void main(String[] args) {

        // 암시적 lock
        FirstCount count = new FirstCount();
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(count.view());
                    }
                }
            }.start();
        }

        // 명시적 lock
        SecondCount secondCount = new SecondCount();
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        secondCount.getLock().lock(); // 다른 스레드가 접근 불가
                        System.out.println(secondCount.view());
                        secondCount.getLock().unlock(); // 다른 스레드 접근 가능
                    }
                }
            }.start();
        }

    }
}
// 암시적 lock - method lock , 변수 lock
class FirstCount {
//    private Integer count = 0; - 변수 락할 때 기본형 타입은 되지 않음
    private int count;

    // 암시적 lock - method Lock
    public synchronized int view() {
        return count++;
        // 암시적 lock - 변수 Lock
//        synchronized (this.count) {
//            return count++;
//        }
    }

    public int getCount() {
        return count;
    }
}

// 명시적 lock
class SecondCount {
    private int count;
    private Lock lock = new ReentrantLock();
    public int view() {
        return count++;
    }

    public int getCount() {
        return count;
    }

    public Lock getLock() {
        return lock;
    }
}