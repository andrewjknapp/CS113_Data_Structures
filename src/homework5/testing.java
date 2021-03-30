package homework5;

public class testing {
    public static void main(String[] args) {
        CircularArrayQueue<String> caq = new CircularArrayQueue<>(3);

        caq.add("Hello");
        caq.add("There");
        caq.add("General");

        System.out.println(caq.poll());
        System.out.println(caq.poll());
        System.out.println(caq.poll());

        caq.add("Hello");
        System.out.println(caq.poll());

        caq.add("There");
        caq.add("General");
        caq.add("Kenobi");

        System.out.println(caq.poll());
        System.out.println(caq.poll());
        System.out.println(caq.poll());


    }
}
