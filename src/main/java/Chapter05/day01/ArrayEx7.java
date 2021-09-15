package Chapter05.day01;

import java.util.Arrays;

public class ArrayEx7 {
    public static void main(String[] args) {
        // 섞기(shuffle)

        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i; // 배열을 0~9까지 초기화
            System.out.print(numArr[i]);
        }

        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10); // 0~9 중의 한 값을 임의로 얻는다.

            int tmp = numArr[0]; // tmp 에 numArr[0] 값을 넣어준다.
            numArr[0] = numArr[n]; // numArr[0]에 numArr[n] 의 값을 넣어준다.
            numArr[n] = tmp;    // numArr[n]에 tmp (numArr[0])값을 넣어준다.
        }

        // 배열 출력
        System.out.println(Arrays.toString(numArr));
    }
}
