import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split("-");
        System.out.println(string[1] + "/" + string[2] + "/" + string[0]);
    }
}