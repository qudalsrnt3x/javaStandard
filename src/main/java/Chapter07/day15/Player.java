package Chapter07.day15;

abstract class Player {
    boolean pause;  // 일시정지 상태를 저장하기 위한 변수
    int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

    Player() {  // 추상 클래스 생성자
        pause = false;
        currentPos = 0;
    }
    /** 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다. */
    abstract void play(int pos); // 추상메서드
    /** 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 한다. */
    abstract void stop();

    void play(){
        play(currentPos);   // 추상메서드 사용가능
    }

    void pause() {
        if (pause) {    // pause가 true 일 때(정지상태)에서 pause가 호출되면,
            pause = false;  // pause의 상태를 false로 바꾸고
            play(currentPos);   // 현재의 위치에서 play 한다.
        } else {    // pause가 false일 때 (play상태)에서 pause가 호출되면,
            pause = true; // pause의 상태를 true로 바꾸고
            stop(); // play를 멈춘다.
        }

    }
}

class CDplayer extends Player {
    void play(int currentPos) {
        //.. 조상의 추상메서드를 구현
    }

    void stop() {
        //.. 조상의 추상메서드를 구현
    }

    // CDPlayer클래스에 추가로 정의된 멤버
    int currntTrack;

    void nextTrack() {
        currntTrack++;
        // ...
    }

    void preTrack() {
        if (currntTrack > 1) {
            currntTrack--;
            // ...
        }
    }

}
