package Chapter06.day01;

public class ArrayEx10 {
    public static void main(String[] args) {

        // 정렬하기(sort)

        int[] numArr = new int[10]; // 10개의 정수를 저장할 배열 생성

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] = (int) (Math.random() * 10)); // 0~9까지의 임의의 값 넣기
        }
        System.out.println();

        for (int i = 0; i < numArr.length - 1; i++) { // 배열의 길이 - 1번 만큼 반복
            boolean changed = false; // 자리바꿈이 발생했는지 체크한다.

            for (int j = 0; j < numArr.length - 1 - i; j++) { // i가 커질수록 비교횟수는 하나씩 줄어든다.
                if (numArr[j] > numArr[j + 1]) {// 옆의 값이 작으면 서로 바꾼다.

                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                    changed = true; // 자리바꿈이 발생했으니 true로 변경
                }
            }

            if(!changed) break; // 자리바꿈이 없으면 반복문을 벗어난다.

            for (int k = 0; k < numArr.length; k++) {
                System.out.print(numArr[k]); // 정렬된 결과를 출력한다.
            }
            System.out.println();
        }
    }
}

