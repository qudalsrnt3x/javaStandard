package Chapter05.day01;

public class ArrayEx5 {
    public static void main(String[] args) {
        // 총합과 평균

        int sum = 0;        // 총합을 저장하기 위한 변수
        float average = 0f; // 평균을 저장하기 위한 변수

        int[] score = {100, 88, 100, 100, 90};

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        average = sum / (float)score.length;    // float로 얻기 위해 형변환

        System.out.println("sum = " + sum); // 총합
        System.out.println("average = " + average); // 평균
    }
}
