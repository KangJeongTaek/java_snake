# java_snake_games
 
## JFrame을 이용한 스네이크 게임 제작해보기
- 테트리스에서 만들었던 양식을 거의 그대로 가져와서 내부 로직만 변경해봄
    - GamePanel, KeyHandler, Main은 거의 동일
    - PlayManager는 게임 방식이 완전 상이하므로 다시 코드를 작성했음.

### 제작 의의
- 테트리스는 유튜브 강의를 보며 거의 따라하듯이 코드를 작성했으나, 이번 게임은 혼자서 도움을 받지 않고 작성했음.

### 어려웠던 점
- 하나의 블록의 이동할 때의 속도 조절과 각 블록의 이동 경로를 지정하는 곳에서 상당히 고생을 했음.

### 문제점
- 현재 시작 시에 우측 키보드를 누르면 무조건 게임 오버가 뜸(젤 앞쪽 블록이 그 뒤의 블록과 마주치기 때문) -> 시작 시에는 우측을 누르지 못하도록 설정해야함
<img src="https://raw.githubusercontent.com/KangJeongTaek/java_snake/main/images/video01.gif" width="570px">

- 게임 시작 시에 블록 움직임이 약간 어색하게 보임(두 번째 블록부터 첫 번째 블록의 움직임을 따라가도록 로직을 작성했는데, 두번 째 블록이 첫번 째 블록의 위치로 가기 때문에 중간에 블록 하나가 빈 것처럼 보여짐)

<img src="https://raw.githubusercontent.com/KangJeongTaek/java_snake/main/images/video02.gif" width="570px">

### 게임 실행 영상

<img src="https://raw.githubusercontent.com/KangJeongTaek/java_snake/main/images/video03.gif" width="570px">