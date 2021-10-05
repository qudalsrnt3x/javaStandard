package Chapter09.day20;

// 공변반환타입

import java.util.Arrays;

public class CloneEx2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arrClone = arr.clone(); // 배열 arr을 복제해서 같은 내용의 새로운 배열을 만든다.

        arrClone[0] = 6;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrClone));

        // 배열복사는 arraycopy() 메서도를 이용해서도 할 수 있다.


    }
}
