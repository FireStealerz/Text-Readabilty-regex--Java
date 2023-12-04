import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstString = scanner.nextLine().split("");
        String[] subString = scanner.nextLine().split("");
        int indCounter = 0;
        int patterCounter = 0;
        int j = 0;
        for (int i = 0; i < firstString.length; i++) {
            if (Objects.equals(firstString[i], subString[j])) {
                indCounter++;
                j++;
                if (indCounter == subString.length) {
                    patterCounter++;
                    j = 0;
                    indCounter = 0;
                }
            }else {
                j = 0;
            }
        }
        System.out.println(patterCounter);
    }
}