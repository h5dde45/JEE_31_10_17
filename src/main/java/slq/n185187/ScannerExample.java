package slq.n185187;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String name;
        double weight;
        int height;

        name=scanner.nextLine();
        weight=scanner.nextDouble();
        height=scanner.nextInt();

        System.out.println(name);
        System.out.println(weight);
        System.out.println(height);
    }
}
