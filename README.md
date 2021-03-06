 <div align=right>
<img src="https://img.shields.io/badge/Hyunnna-01FF95?style=flat-square&logo=Github&logoColor=white"/>  <img src="https://img.shields.io/badge/Java-EF2D5E?style=flat-square&logo=Java&logoColor=white"/>
 
   </div>
   
 <div align=center>
<br />

![header](https://capsule-render.vercel.app/api?type=cylinder&color=auto&height=100&section=header&text=[Alogrithm]%20모의담금질%20알고리즘&fontSize=40&fontColor=ffffff)
   </div>

<br />

**높은 온도에서 액체 상태인 물질이 온도가 낮아지며 결정체로 변하는 과정을 모방해 simulated annealing으로 최적해를 찾아 빠른 탐색 시간내에 문제를 해결하는 방법**

<div align=center>

<img width="594" alt="ball" src="https://user-images.githubusercontent.com/62924325/173975942-bc44a2d5-4e9d-4b37-b3ea-2539f20ebb42.png">

   </div>
   
<br />    

   공이 언덕을 내려가는 그림으로 알고리즘에 대한 이해를 도울수 있다.

   start 위치에서 공을 굴리면 공은 **지역 최솟점 (Local Minima)** 에 빠진다. 하지만 *최적해는 공이 전역 최솟값 (Global Minima) 에 도달하는 것이다.* 하지만 언덕에서 공은 **현재 위치보다 높은 곳으로 이동하지 않는다.**


   이때 공이 **지역 최솟값 (Local Minima)** 에서 최솟값만 선택하지 말고 이웃해를 선택하여 지역 최솟점을 벗어나게 된다면 전역 최솟값 (Global Minima) 에 도달할 수 있게 될 것이다. 이때 이 과정을 **탈출 방법(Hill climbing)** 이라고 정의하였다.
<br />

<br />


![image](https://user-images.githubusercontent.com/62924325/173999368-f4fd3c11-0890-4e05-880a-437a77a25240.png)



### <div align=center> **E(x) = s** , **E(y) = s'** <br />

* 초기해 s의 이웃해인 s'를 얻어 s'가 함숫값인 결과해보다 효율적인 경우, X를 Y와 교체하는 과정을 반복한다. <br /> 이때 지역 최소점에 빠지는 것을 막기 위해서 온도에 대한 에너지 변화에 따른 확률에 의해 최적해가 아닌 이웃해 선택을 허용함으로써 지역해에 빠졌을 경우, 지역해 **탈출 방법(Hill climbing)** 으로 이를 방지한다. <br />

   이러한 방식으로 최적해를 찾으려면 이웃해를 먼저 정의하고 선택하는 방법을 알아야하는데 이웃해란 여러 후보해 중에서 서로 이웃하는 해들을 말한다.


* ### **이웃해 선택 방법**

1. **삽입 (Insertion)** <br />
   2개의 해를 랜덤 선택 한 후 두번째 해를 첫번째 해 옆으로 옮기고 두 해 사이의 해들은 오른쪽으로 한칸씩 이동한다. 다음 표에서 F가 선택된 경우 B가 F옆으로 이동하고 나머지 C,D,E,G가 한칸씩 이동한 것을 볼 수 있다.
   
   |A|B|C|D|E|F|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
      ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️
   
   |A|B|F|C|D|E|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
   <br />
   
3. **교환 (Switching)** <br />
   2개의 해를 랜덤선택 한 후 그 두 해의 위치를 서로 바꾼다. B,F가 선택되었다면 두 개의 자리를 바꾼다. 
   
   |A|B|C|D|E|F|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
      ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️
   
   |A|F|C|D|E|B|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
   <br />
   
4. **반전 (Inversion)** <br />
  2개의 해를 랜덤선택한 후 두개 사이의 문자와 두개의 해도 포함해서 역순으로 배열한다.  ex ) [B C D E ] -> [E D C B]
  
   |A|B|C|D|E|F|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
      ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️
   
   |A|F|E|D|C|B|G|
   |:----:|:---:|:---:|:---:|:---:|:---:|:---:| 
   
   <br />
  
* 현재 해로부터 인접해를 만들어주는 과정으로 주어진 T에 따라 많은 내부 루프의 반복수가 이루어지고 이 과정은 알고리즘 성능의 결정적인 역할을 한다. 반복 과정에서 결과해의 값이 커졌을 경우 최적해가 아닌 값을 받아들이는 기준으로 초기 온도가 높은 작동 초반의 경우 많이 받아들이고 갈수록 적게 받아들인다. 

<br />

<br />

   <div align=center>
   
![header](https://capsule-render.vercel.app/api?type=soft&color=auto&height=50&section=header&text=기본동작방식&fontSize=20&fontColor=ffffff)

   </div>
   
<br />

~~~Java

S; //  s ← s0; e ← E(s) 초기값을 설정한다.
temperature T>0; // 초기 온도값을 설정함, 예) T=1000

while( TRUE ) // 가장 에너지가 적은 상태인 S를 찾기까지 반복한다

   for 1<= i <= L do       // L는 반복 숫자이고 이 숫자 만큼 루프를 반복하게 된다.
        Pick a random neighbor S' of S; // S와 임의로 이웃해 S' 를 선택한다.
        
        d ← cost(S')-cost(S); // s와 이웃해인 s'의 값의 차 즉 최적화의 값의 차를 만든다.
                          // d ← area(S')-area(S), 돌을 예를 들면 면적이 크기가 효율성의 차이이다.
                      
        if d <= 0 then S ← S' // S'의 값이 작으면 ( 더 효율적으로 배치되었으면 ) s를 s'로 대체한다.
                     
        else 
           q ← (0,1) // 0과 1 사이에서 랜덤하게 선책한 수
           if (p < q) s ← s' // p는 자유롭게 선택할 확률이다.
        T ← rT; // 한가지 경우의 수를 처리 했었므로 한 단계 줄어 들게 되면 1보다 작은 상수 r을 T에 곱해 새로운 T로 다음 반복을 진행한다.

        return S    // 순환이 끝나면 찾는 최적화의 답을 리턴한다.

end

~~~

<br />

* **초기해 표현** <br />
   초기값는 random 변수 S 를 사용하여 선정한다.
   
* **이웃해 결정** <br />
   현재 해를 s로 가정할때 이웃하는 해중에 임의로 s'를 선택한다
   
* s' 가 s 보다 우수하지 않더라도 0~1 에서 선택한 임의의 수 q 가 확률 p 보다 작으면 현재 해 s로 가정한다. 이것이 최적해보다 이웃해로 탐색을 수행하여 최솟값을 찾는 방법이다. 

* 물리학의 냉각 과정에서 고체의 자유 에너지가 최소화 되는데 고체화되는 과정에서 지역 최소점에 빠지지 않도록 하기 위해서는 천천히 식혀야한다. <br /> 
왜냐하면 온도를 너무 급속히 낮출 경우 평행 상태를 이루어 최소 에너지 상태에 도달할 확률이 낮기 때문이다. 하지만 너무 천천히 낮추면 최소 에너지에 도달할 확률은 커지지만 많은 반복이 필요해 시간이 오래 걸린다는 단점이 있다.

* T를 다시 설정 할때 일정 비율 r(0 < r < 1) 을 곱해 감소시키는데, 이때 r은 냉각률로 0.99에 가깝게하여 앞서 설명했듯이 지역 최소점에 빠지지 않도록 천천히 T를 감소시킨다.

* 더 이상 우수한 해를 찾지 못하거나 미리 정한 루프의 최대 반복횟수를 초과했을 때를 종료 조건 기준으로 정한다.

* **P** : s와 s'의 값 차이 d 값이 크면 p를 작게 하고 작으면 p를 크게 만든다. 이유는 값의 차이가 큼에도 불구하고 p를 크게하면 그동안 탐색한 결과가 무시되어 랜덤하게 탐색하는 결과를 낳기 때문이다. <br />

### <div align=center> p = 1 / e<sup>d/T</sup> = e<sup>-dT</sup> </div>

<br />

<br />

<br />
   
<div align=center>
   
![header](https://capsule-render.vercel.app/api?type=soft&color=auto&height=50&section=header&text=최적화과정분석&fontSize=20&fontColor=ffffff)

<br />
   
  **실험결과**  <br />
   
|temperature(*C)|50|70|100|150|200|
|:--------:|:---:|:---:|:---:|:---:|:---:|
|초기 값|0.433|0.406|0.379|0.368|0.362|
|loop length|50|70|100|150|200|
|결과 값|0.454|0.410|0.367|0.364|0.358|
   
  </div>
   
   <br />
   
   loop length (내부루프의 길이)는 주어진 온도에서 안정상태가 결과 값이 될때 까지의 반복횟수이며 반복횟수로 수렴성의 보장과 효율적 해의 계산을 위해서는 길이를 늘이는 것보다 온도의 떨어지는 폭을 줄이는 것이 더 해를 구하는데 효과적이다.     
   
<br />
   
   <div align=center>
      
   <img width="500" alt="KakaoTalk_20220617_204732980" src="https://user-images.githubusercontent.com/62924325/174292528-ad00b908-da45-466e-aabf-000c6660c04c.png">

</div>
   
   유전자 알고리즘과 비교했을 경우 긴 수행시간을 잡아 효율성이 떨어지는 반면 담금질 알고리즘은 빠른 탐색시간내에 더 효율적으로 해를 찾는다는 것을 알 수 있다. 

<br />

<br />

<br />

<br />

<br />

***
 
**< 참고 >** <br />
 Simulated Annealing| 작성자 임경업 , https://sens.tistory.com/404
<br />
시뮬레이티드 어닐링을 이용한 (m, n)중 연속(r, s) : F 시스템의 정비모형 , 이상헌
․강영태․신동열


