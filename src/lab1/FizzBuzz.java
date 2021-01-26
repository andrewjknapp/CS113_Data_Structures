package lab1;

public class FizzBuzz {
    public FizzBuzz() { }

    public static void printFizzBuzz(int start, int end) {
        boolean fizz, buzz;

        for (int num = start; num <= end; num++) {
            System.out.print(num + " ");

            fizz = num % 3 == 0;
            buzz = num % 5 == 0;

            if (fizz) {
                System.out.print("Fizz");
            }

            if (buzz) {
                System.out.print("Buzz");
            }

            System.out.println();
        }
    }
}
