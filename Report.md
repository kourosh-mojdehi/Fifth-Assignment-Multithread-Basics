# Fifth-Assignment-Multithread-Basics

### Theoretical Questions 📝 

**Note: Please answer these questions in a Markdown file and place it in the root directory of your fork. Include code or screenshots where you see fit.**

### 1. **What will be printed after interrupting the thread?**

```java
public static class SleepThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            } finally {
                System.out.println("Thread will be finished here!!!");
            }
        }
    }

    public static void main(String[] args) {
        SleepThread thread = new SleepThread();
        thread.start();
        thread.interrupt();
    }
```
### Answer 1
After invoking thread.interrupt() , it will throw an interrupted exeption and it will be catched , so "Thread was interrupted!" 
will be printed. execution of the finally block doesn't depend on the exption .so then "Thread will be finished here!!!"
wil be printed.

### 2. In Java, what would be the outcome if the `run()` method of a `Runnable` object is invoked directly, without initiating it inside a `Thread` object?
```java
public class DirectRunnable implements Runnable {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        DirectRunnable runnable = new DirectRunnable();
        runnable.run();
    }
}
```
### Answer 2
if we don't pass the object of direct runnable class to a Thread object ,  run() method will execute 
in the main thread , and we will have just one thread .






### 3. Elaborate on the sequence of events that occur when the `join()` method of a thread (let's call it `Thread_0`) is invoked within the `Main()` method of a Java program.
```java
public class JoinThread extends Thread {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        JoinThread thread = new JoinThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Back to: " + Thread.currentThread().getName());
    }
}
```
### Answer 3 
I name thread = t1 
1 : we created an instance of joinThread class which has extended Thread class . then started it 
2 : t1.join() means the thread that called t1( main thread) will be stopped till the t1 dies. and jdk 
  will gave you error if you don't put it in try catch block.
3 : at th end line, we can be sure that the t1 has died and we are on main thread again and it will print "back
to : main"

