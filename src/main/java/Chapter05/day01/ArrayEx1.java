package Chapter05.day01;

public class ArrayEx1 {
    public static void main(String[] args) {

        int[] score = new int[5]; // 길이가 5인 배열 생성, (index는 0~4)
        int k = 1;

        score[0] = 50;
        score[1] = 60;
        score[k+1] = 70; // score[2] = 70;
        score[3] = 80;
        score[4] = 90;

        int tmp = score[k+2] + score[4]; // int tmp = score[3] + score[4]

        // for 문으로 배열의 모든 요소를 출력한다.
        for (int i = 0; i < 5; i++) {
            System.out.printf("score[%d]:%d%n", i, score[i]);
        }

        // tmp 값 출력
        // score[3] + score[4] = 80 + 90 = 170
        System.out.printf("tmp:%d%n", tmp);

        // index의 범위를 넘어가면 runtime 시 에러가 발생
        // ArrayIndexOutOfBoundsException
        //System.out.printf("score[%d]:%d%n", 7, score[7]);


    }

}
