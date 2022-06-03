import java.util.Scanner;

public class Tech{
    static Scanner scan = new Scanner(System.in);

    //"GetInputStringFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction() {
        return scan.nextLine();
    }

    public static Integer getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}

