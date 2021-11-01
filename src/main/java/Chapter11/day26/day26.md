
## Day26 컬렉션 클래스 정리 & 요약

### - Collections Framework

- 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식
- 다양한 종류의 컬렉션 클래스를 표준화된 방식으로 다룰 수 있도록 체계화
- java.util package에 포함되어 있다.

|인터페이스|특 징|
|---|---|
|List|순서가 있는 데이터의 집합. 데이터의 중복을 허용한다.<br> ex) 대기자 명단 <hr> 구현클래스: ArrayList, LinkedList, Stack, Vector 등|
|Set| 순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다. <br> ex) 양의 정수집합, 소수의 집합 <hr> 구현클래스: HashSet, TreeSet 등|
|Map| 키(Key)와 값(Value)의 쌍(pair)으로 이루어진 데이터의 집합 <br> 순서는 유지되지 않으며, 키는 중복허용x, 값은 중복허용 가능 <br> ex) 우편번호, 지역번호(전화번호) <hr> 구현클래스: HashMap, TreeMap, HashTable, Properties 등

- 컬렉션 프레임웍의 모든 컬렉션 클래스들은 List, Set, Map 중의 하나를 구현하고 있다.

### List인터페이스
- 중복을 허용하면서 저장순서가 유지
- ArrayList를 많이 사용

### Set인터페이스
- 중복을 허용하지 않고 저장순서가 유지되지 않음

### Map인터페이스
- 키(Key)와 값(Value)을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는 데 사용

### 컬랙션 클래스특징

|컬렉션|특 징|
|:---|---|
|ArrayList|배열기반. 데이터의 추가와 삭제에 불리, <br> 순차적인 추가삭제는 제일 빠름. 임의의 요소에 대한 접근성이 뛰어남|
|LinkedList|연결기반. 데이터의 추가와 삭제에 유리. 임의의 요소에 대한 접근이 좋지 않음|
|HashMap|배열과 연결이 결합된 형태. 추가, 삭제, 검색, 접근성이 모두 뛰어남. <br> 검색에는 최고의 성능을 보임.|
|TreeMap|연결기반. 정렬과 검색(범위검색)에 적합. 검색성능은 HashMap보다 떨어짐|
|Stack| Vector를 상속받아 구현|
|Queue| LinkedList가 Queue인터페이스를 구현|
|Properties|Hashtable을 상속받아 구현|
|HashSet|HashMap를 이용해서 구현|
|TreeSet|TreeMap을 이용해서 구현|
|LinkedHashMap <br> LinkedHashSet|	HashMap과 HashSet에 저장순서유지기능을 추가함.|

