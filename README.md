<img src="https://img.shields.io/badge/Hyunnna-01FF95?style=flat-square&logo=Github&logoColor=white"/>  <img src="https://img.shields.io/badge/Java-EF2D5E?style=flat-square&logo=Java&logoColor=white"/>

<br />

![header](https://capsule-render.vercel.app/api?type=cylinder&color=auto&height=100&section=header&text=[Alogrithm]%20모의담금질%20알고리즘&fontSize=40&fontColor=ffffff)

<br />

**단위시간당 기대비용을 최소로 하는 최적의 교체 주기를 구하기 위해 함수식을 구하는 과정에서 순환식과 상한, 하한값을 simulated annealing으로 최적화할 수 있는 방안을 찾아 빠른 탐색 시간내에 문제를 해결하는 방법**

<img width="594" alt="ball" src="https://user-images.githubusercontent.com/62924325/173975942-bc44a2d5-4e9d-4b37-b3ea-2539f20ebb42.png">

<br />    

   공이 언덕을 내려가는 그림으로 알고리즘에 대한 이해를 도울수 있다.

   start 위치에서 공을 굴리면 공은 **지역 최솟값 (Local Minima)** 에 빠진다. 하지만 **최적해는 공이 전역 최솟값 (Global Minima) 에 도달하는 것이다.** 하지만 언덕에서 공은 **현재 위치보다 높은 곳으로 이동하지 않는다.**


   이때 공이 **지역 최솟값 (Local Minima)** 를 빠져나갈 정도만 **언덕 전체를 약간 흔들어주면 공은 전역 최솟값 (Global Minima) 에 도달할 수 있게 될 것이다.** 여기서 언덕 전체를 흔들어주는 역할 을 하는것이 모의담금질 알고리즘에 적용된 **Hill climbing**이다. 

   그럼 어느정도로 언덕을 흔들어야 할까? 모의 담금질 알고리즘에 의하면 처음에는 세게, 시간이 지날수록 강도를 약하게 하는 것이 효율적이다. 
   여기서 흔들어주는 세기는 담금질 방법에서 냉각속도에 해당한다. 
   
   이때 이웃해가 더 우수해서 최적해가 바뀌게 되는 경우가 있는데 이러한 경우를 **downhill move** 라고 가정하였다.

<br />

<br />

<br />

![header](https://capsule-render.vercel.app/api?type=soft&color=auto&height=50&section=header&text=기본동작방식&fontSize=20&fontColor=ffffff)

물리학에서 에너지 수준이 가장 낮은 상태를 얻기 위해서 어널링 과정을 최적화 문제에 적용한 담금질의 기본 동작 방식은 다음과 같다.

![image](https://user-images.githubusercontent.com/62924325/173999368-f4fd3c11-0890-4e05-880a-437a77a25240.png)

* 초기해 X를 설정한 수 X의 이웃해인 Y를 얻어 Y가 함숫값인 결과해보다 효율적인 경우, X를 Y와 교체하는 과정을 반복한다. 이때 지역 최소점에 빠지는 것을 막기 위해서 온도에 대한 에너지 변화에 따른 확률에 의해 최적해가 아닌 이웃해 선택을 허용함으로써 지역해에 빠졌을 경우, 지역해 탈출 방법(Hill climbing)으로 이를 방지한다.   

   1. **INITIALIZE** <br />
      알고리즘이 시작하는데 필요한 초기해 X와 컨트롤 파라미터 T , 내부루프의 반복수 L을 결정한다. 
         * T : 결정 상태를 얻기 위한 담금질 과정의 온도와 같은 역할
         * L : 주어진 T에서 평행 상태에 이르 기까지 내부 루프의 반복 수 <br />
          
   2. **PERTURB** <br />
      현재 해로부터 인접해를 만들어주는 과정으로 주어진 T에 따라 많은 내부 루프의 반복수가 이루어지고 이 과정은 알고리즘 성능의 결정적인 역할을 한다.
      <br />
   3. **수락 기준** <br />
      반복 과정에서 결과해의 값이 커졌을 경우 최적해가 아닌 값을 받아들이는 기준으로 초기 온도가 높은 작동 초반의 경우 많이 받아들이고 갈수록 적게 받아들인다. 

<br />

<br />

<br />

![header](https://capsule-render.vercel.app/api?type=soft&color=auto&height=50&section=header&text=최적화과정분석&fontSize=20&fontColor=ffffff)

    
~~~java

S; //  s ← s0; e ← E(s) 초기값을 설정한다.
temperature T>0; // 초기 온도값을 설정함, 예) T=1000

while( TRUE ) // 가장 에너지가 적은 상태인 S를 찾기까지 반복한다

   for 1<= i <= P do       // P는 반복 숫자이고 이 숫자 만큼 루프를 반복하게 된다.
        Pick a random neighbor S' of S; // 기존의 솔루션 S와 임의로 이웃해 S' 를 선택한다.
        
        d ← cost(S')-cost(S); // 기존의 솔루션인 s와 새로운 솔루션인 s'의 값의 차 즉 최적화의 값의 차를 만든다.
                          // d ← area(S')-area(S), 돌을 예를 들면 면적이 크기가 효율성의 차이이다.
                          
        /* downhill move */
        if d <= 0 then S ← S' // S'의 값이 작으면 즉 차지하는 면적이 작고, 더 효율적으로 배치 되었으면,
                          // 이것이 현재까지의 최적화가 되고 이것을 온도가 내려간다. Downhill로 표현한다.
                          
        /* uphill move */
        if d > 0 then S ← S' // S'의 값이 크면 즉 차지하는 면적이 크고, 더 비 효율적으로 배치 되었으면, 이것을 온도가 올라간다.
                         //  uphill로 표현한다.
                         
        else // 이웃해가 이전해보다 우수하지 않은 경우
           q ← (0,1) // 0과 1 사이에서 랜덤하게 선책한 수
           if (p < q) s ← s' // p는 자유롭게 선택할 확률
        T ← rT; // 한가지 경우의 수를 처리 했었므로 한 단계 줄어 들게 되면 1보다 작은 상수 r을 T에 곱해 새로운 T로 다음 반복을 진행한다.

        return S    // 프로그램이 마무리 되면 우리가 찾는 최적화의 답을 리턴한다.

end

~~~
<br />

* **초기해 표현** <br />
   초기해는 random 변수를 사용하여 선정한다.
   
* **이웃해 결정** <br />
   현재 해를 s로 가정할때 이웃하는 해중에 임의로 s'를 선택한다
    
*

*

<br />

<br />

   * **비교값** 

   ||내용|명|명|명|명|
   |:--------:|:---:|:---:|:---:|:---:|:---:|
   |**Case 1**|테스트2|테스트3|명|명|명|
   |**Case 2**|테스트2|테스트3|명|명|명|
   |**Case 3**|테스트2|테스트3|명|명|명|

<br />

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


