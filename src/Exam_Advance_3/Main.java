package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> parentQueue = new LinkedList<>();
        String parentName;
        while (true) {
            showMenu();
            System.out.print("Please select your option: ");
            int selectedOption = Integer.parseInt(sc.nextLine());
            switch (selectedOption) {
                case 1:
                    System.out.print("Input parent name: ");
                    parentName = sc.nextLine();
                    parentQueue.add(parentName);
                    System.out.println("Add parent successfully!");
                    break;
                case 2:
                    String parentNameTemp = parentQueue.poll();
                    if (parentNameTemp != null) {
                        System.out.println(parentNameTemp);
                    } else {
                        System.out.println("Not have any parent in list!");
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
                        "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                        "2. Phụ huynh tiếp theo\n" +
                        "3. Thoát\n" +
                        "----------------------\n");
    }
}
