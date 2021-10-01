package Chapter08.day18;

public class ExceptionEx1 {
    public static void main(String[] args) {
        try {
            try {

            } catch (Exception e){}
        } catch (Exception e){
//            try {
//
//            } catch (Exception e) {}    // 에러. 변수 e가 중복 선언되었다.
        } // try -catch의 끝

        try {

        } catch (Exception e){

        } // try -catch의 끝
    } // main

    // 하나의 메서드 내에 여러 개의 try - catch 문이 사될 수 있다.
    // try블럭 또는 catch 블럭에 또 다른 try - catch 문이 포함될 수 있다.(catch 블럭에서도 예외가 발생할 수 있기 때문)
}
