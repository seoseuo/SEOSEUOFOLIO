# SEOSEUOFOLIO

 <a href="https://chivalrous-saffron-326.notion.site/SEOSEUOFOLIO-67fb1bc68d0145edacba6979ef0fcd18"><img src="https://img.shields.io/badge/DETAIL BIO & Progress & Video-E6E6E6?style=for-the-badge&logo=notion&logoColor=black" /></a>
 
 ![image](https://user-images.githubusercontent.com/90320005/211271830-19b68c41-bab3-44e5-8e58-f868206f97c1.png)


 # 개요

> 한림대학교 모바일 프로그래밍 & (주) 더 존 비즈온 스마트 포트폴리오 프로젝트

* 자신의 포트폴리오를 앱으로 구현하여, 개발자의 개발 역량과 이력을 제공하는 것을 목표로 한다. 하나의 기능을 제공하는 완성된 앱을 구현하고, 내부에서는 화면 간의 이동
(이동 시 데이터 전달 처리 방안), Thread의 활용, 리스트 및 위젯으로 화면 구성, 앱 과 웹 이동 방법 등의 기능을 개발하는 것이 핵심이다.



<pre>
<code>
💬 서승 폴리오는 ‘나’라는 사람이 한림대학교를 다니며 어떤 활동을 하고 어떤 공부를 하였는지,
또 어떤 프로젝트를 만들었고 어떠한 자치 기구 활동을 하였는지 정리하고 하나의 앱으로 개발하여
저의 개발 역량과 교내 이력을 열람할 수 있는 특별하고 간편하지만 가볍지 않은 저의 포트폴리오 어플리케이션 입니다.
</code>
</pre>


---

# 주요기능

- `시작 화면`에서는 가운데 버튼을 클릭하면 어플리케이션으로 들어갈 수 있습니다.

- `메인 화면`에서는 `앱바`와 `툴바` `액션바`로 상단을 구성하였고 간단하게 어플을 소개하고 좌측에서 우측으로 슬라이드하여 메뉴를 꺼낼 수 있습니다.

- `인텐트` 기능으로 각 액티비티와 깃허브, 노션과 같은 액티비티, 웹으로 이동할 수 있도록 구현하였습니다. 또한 액티비티끼리 데이터를 주고받을 땐 `put,getExtra` 함수를 사용하여 송수신 하였습니다.

- `네비게이션 메뉴`는 화면을 좌측에서 우측으로 슬라이드하여 꺼낼 수 있고, 다른 액티비티로 이동할 수 있습니다.

- `서승권이란` `학생 자치기구 활동` `학업 액티비티`에서는 순차적으로 자기소개, 저의 학생 자치기구 활동, 어떤 과목을 수강하였는지 열람 할 수 있습니다.

### `SQLITE`와 연동하여 구현한 작업들

- `프로젝트 액티비티`에서는 `카드뷰` 형태로 저의 프로젝트들을 나열하였고 sns 게시물처럼 해당 프로젝트를 추가, 수정, 삭제 할 수 있습니다.

- `문의 액티비티`에서는 이메일버튼, 추가버튼, 삭제버튼이 있고 순서대로 개발자의 이메일로 메일을 바로 전송할 수 있도록 하고 추가, 삭제 버튼을 어플에 대한 의견이나 댓글을 추가, 삭제 할 수 있습니다.

---

# 역할

> 기획 단계 (더 존 비즈온)를 제외하고 UI,UX 제작, `💨Main Feat`에 작성한 모든 기능들을 도맡았습니다.

---

# 소개

![슬라이드3](https://user-images.githubusercontent.com/90320005/211272100-f559c30c-c7db-4e8e-a999-a58ccaf9da41.PNG)
![슬라이드4](https://user-images.githubusercontent.com/90320005/211272102-3c752864-dcc8-48f7-9ad6-96d117da2380.PNG)
![슬라이드5](https://user-images.githubusercontent.com/90320005/211272079-7f5064c4-0511-4c25-ac81-21e5c92bec7b.PNG)
![슬라이드6](https://user-images.githubusercontent.com/90320005/211272083-b365165c-cdb4-4b3f-b499-1be5119c1726.PNG)
![슬라이드7](https://user-images.githubusercontent.com/90320005/211272084-81e646ef-5593-4681-be0e-9a1f0d8d3261.PNG)
![슬라이드8](https://user-images.githubusercontent.com/90320005/211272085-6afaa002-7ab8-420c-9ecc-fbdd412e8f44.PNG)
![슬라이드9](https://user-images.githubusercontent.com/90320005/211272089-6e5a9703-cf4a-4f3d-a309-728e6d1dae1d.PNG)
![슬라이드10](https://user-images.githubusercontent.com/90320005/211272093-6a53190b-f8e3-4a81-81dc-82bfa0d56807.PNG)
![슬라이드11](https://user-images.githubusercontent.com/90320005/211272099-ba82d39d-69e3-4100-a503-a606267efa90.PNG)

- - -


# 시연 영상 & 구현영상
 <a href="https://chivalrous-saffron-326.notion.site/SEOSEUOFOLIO-67fb1bc68d0145edacba6979ef0fcd18"><img src="https://img.shields.io/badge/DETAIL BIO & Progress & Video-E6E6E6?style=for-the-badge&logo=notion&logoColor=black" /></a>
 

# 후기
**구현하지 못한 점, 아쉬운 점**
프로젝트를 업로드 하거나, 수정할 때 이미지를 갤러리에서 꺼내와 등록 할 수 있도록 기능을 구현하려 하였지만 해당 부분에 있어 미흡한 과정이 있었고 그리하여 미처 구현하지 못하였습니다.
( DB 에 INSERT 하는 과정, INTENT로 사진을  형변환 시켜 데이터를 넘겨주는 과정) 
원하는 기능을 구현하지 못하고 처음 기획했던 모습에 100% 수렴하지 못한 것이 아쉬운 점이면 아쉬운 점 인 것 같습니다.


**소감**
안드로이드 스튜디오를 사용해 처음으로 어플리케이션을 만들어 보았습니다. 디자인적으로도, 기능적으로도 한참 부족하고 모자른 결과물이지만 기획부터 마감까지, 처음부터 끝까지 스스로 만들어 낸 프로젝트 이므로 뿌듯한 마음을 가지고 있습니다.

이번 프로젝트에서 겪은 시행착오를 거름삼아 완성도 있고, 다양한 기능을 구현할 수 있는 어플리케이션을 개발해보고 싶습니다.

