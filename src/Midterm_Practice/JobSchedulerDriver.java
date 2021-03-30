package Midterm_Practice;

public class JobSchedulerDriver {
    public static void main(String[] args) {

        JobScheduler js = new JobScheduler();

        System.out.println(js.getNextProcess());
        js.addProcess(new Process(17));
        js.addProcess(new Process(96));
        js.addProcess(new Process(34));
        Process currentProcess = js.getNextProcess();
        System.out.println(currentProcess);
        currentProcess = js.switchProcess(currentProcess);
        System.out.println(currentProcess);
    }
}
