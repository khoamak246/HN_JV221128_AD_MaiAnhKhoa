package Exam_Advance_2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> reversedInputStringStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String inputText = null;
        while (true) {
            showMenu();
            System.out.print("Input your option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            switch (selectedOption) {
                case 1:
                    System.out.print("Input your text: ");
                    inputText = sc.nextLine();
                    System.out.println("Input successfully!");
                    System.out.println("Press 2 to reversed text!");
                    break;
                case 2:
                    if (inputText != null){
                        String[] textSplitSpaceArray = inputText.split(" ");
                        Collections.addAll(reversedInputStringStack, textSplitSpaceArray);
                        System.out.println();
                        while (!reversedInputStringStack.isEmpty()) {
                            System.out.print(reversedInputStringStack.pop() + " ");
                        }
                    } else {
                        System.out.println("Please press 1 to input first!");
                    }
                    break;
                case 3:
                    System.out.println("See you again!");
                    return;
                default:
                    System.out.println("Not match any option!");
                    System.out.println("Please try again!\n");
                    break;
            }
        }


    }

    private static void showMenu() {
        System.out.println(
                         "\n\n-------| MENU |-------\n" +
                        "1. Nhập câu\n" +
                        "2. Đảo ngược câu\n" +
                        "3. Thoát\n" +
                        "----------------------\n"
        );
    }
}
