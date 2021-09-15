package Chapter05.day01;

public class ArrayEx6 {
    public static void main(String[] args) {
        // 최대값과 최소값

        int[] score = {79, 88, 91, 33, 100, 55, 95};

        int max = score[0]; // 배열의 첫 번째 값으로 최대값을 초기화
        int min = score[0]; // 배열의 첫 번째 값으로 최소값을 초기화

        for (int i = 1; i < score.length; i++) { // i = 1 부터 비교
            if (score[i] > max) {
                max = score[i];
            } else if (score[i] < min) {
                min = score[i];
            }
        }

        System.out.println("max = " + max); // 최대값
        System.out.println("min = " + min); // 최소값

    }
}
