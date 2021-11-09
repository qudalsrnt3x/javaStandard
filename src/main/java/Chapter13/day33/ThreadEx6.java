package Chapter13.day33;

import javax.swing.*;
// 서로 다른 작업을 병행할 경우 싱글쓰레드보다 멀티쓰레드가 더 효과적이다.

public class ThreadEx6 {
    public static void main(String[] args) {

        // 하나의 쓰레드로 사용자의 입력을 받는 작업과 화면에 숫자를 출력하는 작업을 처리하기 때문에 사용자가 입력을 마치기 전까지 화면에 숫자가 출력되지 않는다.
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + " 입니다.");

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초간 시간을 지연한다.
            } catch (Exception e){}
        }
    }
}
