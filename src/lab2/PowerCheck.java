package lab2;

public class PowerCheck {
    public PowerCheck() { }

    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) return false;

        String binaryNum = Integer.toBinaryString(num);
        for (int index = 1; index < binaryNum.length(); index++) {
            if (binaryNum.charAt(index) != '0') {
                return false;
            }
        }
        return true;
    }
}
