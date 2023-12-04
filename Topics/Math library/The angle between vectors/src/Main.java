import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().split(" ");
        String[] coordintatesTwo = scanner.nextLine().split(" ");
        Integer[] vectorOne = Stream.of(coordinates).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] vectorTwo = Stream.of(coordintatesTwo).map(Integer::valueOf).toArray(Integer[]::new);
        double stepOne = Math.sqrt(Math.pow(vectorOne[0],2) + Math.pow(vectorOne[1],2));
        double stepTwo = Math.sqrt(Math.pow(vectorTwo[0],2) +  Math.pow(vectorTwo[1],2));
        double stepThree = (vectorOne[0] * vectorTwo[0]) + (vectorOne[1] * vectorTwo[1]);
        double stepFour = stepThree / (stepOne * stepTwo);
        double stepFive = Math.toDegrees(Math.acos(stepFour));
        System.out.println(stepFive);
    }
}