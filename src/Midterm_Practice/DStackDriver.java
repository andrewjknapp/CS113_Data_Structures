package Midterm_Practice;

public class DStackDriver {
    public static void main(String[] args) {
        DStack ds = new DStack();

        ds.push(4);
        ds.push(2);
        ds.push(8);
        ds.push(3);
        ds.push(6);
        ds.push(5);

        System.out.println(ds.peek());

        DStack.moveSmallestToTop(ds);

        System.out.println(ds.peek());
        ds.pop();
        System.out.println(ds.peek());
        DStack.moveSmallestToTop(ds);
        System.out.println(ds.peek());
    }
}
