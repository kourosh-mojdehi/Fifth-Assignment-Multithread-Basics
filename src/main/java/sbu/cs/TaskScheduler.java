package sbu.cs;

import java.util.ArrayList;
import java.util.List;

public class TaskScheduler
{
    public static class Task implements Runnable
    {
        /*
            ------------------------- You don't need to modify this part of the code -------------------------
         */
        String taskName;
        int processingTime;

        public Task(String taskName, int processingTime) {
            this.taskName = taskName;
            this.processingTime = processingTime;
        }
        /*
            ------------------------- You don't need to modify this part of the code -------------------------
         */

        @Override
        public void run() {
            try {
                Thread.sleep(processingTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void bubbleSort(ArrayList<Task> tasks, int n)
    {
        int i, j;
        int temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (tasks.get(j).processingTime > tasks.get(j+1).processingTime) {

                    temp = tasks.get(j).processingTime;
                    tasks.get(j).processingTime = tasks.get(j+1).processingTime;
                    tasks.get(j+1).processingTime = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
    public static ArrayList<String> doTasks(ArrayList<Task> tasks)
    {
        ArrayList<String> finishedTasks = new ArrayList<>();
        bubbleSort(tasks , tasks.size());
        for( Task task : tasks){
            Thread thread = new Thread(task);
            thread.start();
            try {
                thread.join();
            }
            catch (InterruptedException e){
                System.out.println(e.getStackTrace());
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
            finishedTasks.add(task.taskName);
        }

        /*
        TODO
            Create a thread for each given task, And then start them based on which task has the highest priority
            (highest priority belongs to the tasks that take more time to be completed).
            You have to wait for each task to get done and then start the next task.
            Don't forget to add each task's name to the finishedTasks after it's completely finished.
         */

        return finishedTasks;
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks= new ArrayList<>();
        for(int i =10 ; i>6 ; i--){
            Task task = new Task("h" , i);
            tasks.add(task);
        }
        bubbleSort(tasks , tasks.size());
       for (Task task : tasks ){
           System.out.println(task.processingTime);
       }
    }
}
