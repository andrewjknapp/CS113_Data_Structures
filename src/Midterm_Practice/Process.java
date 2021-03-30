package Midterm_Practice;

public class Process {
    private int pid;

    public Process(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Process{" +
                "pid=" + pid +
                '}';
    }
}
