package Chapter08.day19;

import java.io.File;

public class ExceptionEx16 {
    public static void main(String[] args) {
        try {
            File f = createFile(args[0]);
            System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }
    }

    static File createFile(String fileName) throws Exception {
        if(fileName == null || fileName.equals(""))
            throw new Exception("파일이름이 유효하지 않습니다");
        File f = new File(fileName);
        // File 객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
        f.createNewFile();
        return f;
    }

    // Exception15 와의 차이점은 예외의 처리방법에 있다.
    // 예외가 발생한 부분에서 처리할 수도 있고 예외를 던져서 처리할 수도 있음
}
