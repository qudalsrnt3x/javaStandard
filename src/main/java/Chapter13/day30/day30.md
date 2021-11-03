## 쓰레드 thread

### 프로세스와 쓰레드

- 프로세스란 간단히 말해서 '실행 중인 프로그램(program)'이다.
- 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.


- 쓰레드란 프로세스 실행의 단위
- 모든 프로세스는 최소한 하나 이상의 쓰레드가 존재
- 둘 이상의 쓰레드를 가진 프로세스를 멀티쓰레드 프로세스라고 한다.

<img src="https://mblogthumb-phinf.pstatic.net/MjAxODAzMDFfMTkz/MDAxNTE5ODM5NTQ4MTQ2.kFxrV0b3md0ukj58I4_Us7IILfMx2h-Sm7Eo_mB8O90g.J9MYHCS2xFR9uNw0uDl-WZ5iGaiQAEFC-aLiZ8uktq4g.PNG.gjcka1234/ccc.png?type=w800" alt="쓰레드">


> **프로세스와 쓰레드의 차이** <br>
> 프로세스는 운영체제로부터 자원을 할당받는 작업의 단위이고 <br>
쓰레드는 프로세스가 할당받은 자원을 이용하는 실행의 단위이다.
> 

#### 멀티태스킹과 멀티쓰레딩

- 멀티쓰레딩은 하나의 프로세스에 여러 쓰레드가 동시에 작업
- ex) 메신저로 채팅하면서 파일을 다운로드받는다.

#### 멀티쓰레딩의 장점
- CPU의 사용률을 향상시킨다.
- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.

#### 멀티쓰레딩의 단점

- 동기화(synchronization), 교착상태(deadlock)같은 문제를 고려해야 한다.