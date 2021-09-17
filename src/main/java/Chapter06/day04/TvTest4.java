package Chapter06.day04;

public class TvTest4 {
    public static void main(String[] args) {
        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv객체 배열 생성 (배열에 값을 넣진 않은 상태)

        // Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv(); // 각 요소에 객체를 생성
            tvArr[i].channel = i + 10;   // 채널의 값을 i + 10으로 저장
        }

        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel=%d%n", i, tvArr[i].channel);
        }
    }
}
