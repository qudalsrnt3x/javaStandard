package Chapter06.day01;

import java.util.Arrays;

public class ArrayEx2 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        //int[] iArr3 = new int[]{100, 95, 90, 80};
        int[] iArr3 = {100, 95, 90, 80};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < iArr1.length; i++) {
            iArr1[i] = i + 1; // 1~10 의 숫자를 순서대로 배열에 넣는다.
        }

        for (int i = 0; i < iArr2.length; i++) {
            iArr2[i] = (int) ((Math.random() * 10) + 1); // 1~10의 값을 무작위로 넣는다.
        }

        // 배열에 저장된 값을 출력
        for (int i = 0; i < iArr1.length; i++) {
            System.out.print(iArr1[i]+", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(iArr2));
        System.out.println(Arrays.toString(iArr3));
        System.out.println(iArr3); // 타임@주소 형태
        System.out.println(chArr); // char는 붙여서 나온다.
    }
}
