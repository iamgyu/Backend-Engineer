import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        int number = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        }
    }
}
