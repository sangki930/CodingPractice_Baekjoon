package BOJ.backtracking.숌사이수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput = readUserInput(bufferedReader);
            System.out.println("사용자의 입력: " + userInput);
        } catch (IOException e) {
            System.err.println("입력 에러가 발생하였습니다: " + e.getMessage());
        }
    }

    private static String readUserInput(BufferedReader reader) throws IOException {
        System.out.print("입력을 입력하세요: ");
        return reader.readLine();
    }
}