package Chapter06.day01;

// 배열의 복사
public class ArrayEx3 {
    public static void main(String[] args) {

        // 길이가 5인 int 배열 생성
        int[] arr = new int[5];

        // 배열 arr에 1~5를 저장.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("[변경전]");
        System.out.println("arr.length:" + arr.length);

        // arr 배열에 저장된 값 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
        }

        // 새로운 배열 생성 ( 기존 arr의 길이 2배)
        int[] tmp = new int[arr.length * 2];

        // 배열 arr에 저장된 값들을 배열 tmp에 복사한다.
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }

        arr = tmp; // tmp에 저장된 값을 arr에 저장한다.

        System.out.println("[변경후]");
        System.out.println("arr.length = " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
        }
    }
}
