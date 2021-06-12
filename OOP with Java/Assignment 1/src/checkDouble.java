import java.util.Scanner;

public class checkDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b;
        if (sc.hasNextDouble()){
            a = sc.nextDouble();
        } else {
            System.out.println("Input not double.");
            return;
        }

        if (sc.hasNextDouble()){
            b = sc.nextDouble();
        } else {
            System.out.println("Input not double.");
            return;
        }
        
        System.out.println("Average: " + (a+b)/2);
    }
}
