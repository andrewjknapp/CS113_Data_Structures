package Midterm_Practice;

import java.util.LinkedList;
import java.util.Queue;

public class JobScheduler {
    /* Data Structure to use */
    private Queue<Process> readyQueue;

    /* Constructor */
    public JobScheduler() {
        readyQueue = new LinkedList<>();
    }

    /* Adds a new job to the system.*/
    public void addProcess(Process p) {
        readyQueue.add(p);
    }

    /* Gets the next job and adds this job back to the
    system, if no other jobs exist this job is sent back.*/
    public Process switchProcess(Process p) {
        readyQueue.add(p);
        return readyQueue.remove();
    }

    /* The previous job finished so we call this to get the
    next process, if no other jobs exist return null */
    public Process getNextProcess() {
        return readyQueue.poll();
    }
}
