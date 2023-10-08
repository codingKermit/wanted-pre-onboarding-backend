# wanted-pre-onboarding-backend
원티드 프리온보딩 백엔드 인턴십 선발과제

## 1) 요구 사항
1. 채용 공고 등록
2. 채용 공고 수정
3. 채용 공고 삭제
4. 채용 공고 목록 조회
5. 채용 공고 검색 기능 // 가점 요건
6. 채용 상세 페이지
7. 사용자 채용 공고 지원 - 사용자별 1회만 지원 가능 // 가점 요건

## 2) 필수 요건
1. ORM 사용
2. RDBMS 사용

## 3) 가점 요소
1. 10월 9일 이전 제출
2. 가산점이 포함된 요구사항 // 5번, 7번
3. Unit Test 구현
4. README에 요구사항 분석 및 구현 과정 작성
5. Git commit 메시지 컨벤션

## 4) 사용 기술
### Environment
  <div>
  <img src="https://img.shields.io/badge/eclipseIDE-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  </div>

### Developments
   <div>
      <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
      <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
      <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
   </div>

## 5) 화면 구성
1. 메인 화면
   1. 기업 사용자 화면 
      1. 채용 공고 등록
      2. 채용 공고 수정
      3. 채용 공고 삭제
      4. 채용 공고 조회 및 검색
   2. 구직 사용자 화면 -> 채용 공고 목록 조회 및 검색 기능
      1. 채용 공고 상세 페이지

## 6) 프로젝트 기획 과정
### 패키지 구조

common : 기업 회원, 일반 회원 공통으로 구현되어야할 기능 - 채용 공고 목록, 검색, 상세 페이지

company : 기업 회원에서 필요한 기능 - 공고 등록,수정,삭제

user : 일반 회원에서 필요한 기능 - 공고 지원

dtos : 소형 사이드 프로젝트의 성격이 강하기에 중복되는 dto를 다수 생성하는 것을 방지하고자 하나의 패키지에 통합

entities : dtos와 같은 목적으로 하나의 패키지에 통합하여 관리

specification : 위와같은 이유로 jpa 조건문에 사용될 specification은 하나로  통합

repo : 위와 같은 이유로 Repository 통합

### 테이블 구조

   <details>
      <summary>
         <h4>User</h4>
      </summary>
      1. userNum : 개인 회원 고유번호 ( pk )<br>
      2. userId : 개인 회원 ID<br>
      3. password 개인 회원 비밀번호<br>
   </details>
   <details>
      <summary>
         <h4>
            Company     
         </h4>  
      </summary>
   1. companyNum : 기업 회원 고유 번호 ( pk ) <br>
   2. companyId : 기업 회원 ID<br>
   3. password : 기업 회원 비밀번호<br>
   4. name : 기업 회원 이름
   </details>
   <details>
      <summary>
         <h4>
            Apply       
         </h4>
      </summary>
   1. applyNum : 공고 지원한 건의 고유번호 ( pk )<br>
   2. userId : 공고 지원자의 고유버호 ( fk ) <br>
   3. postId : 공고 게시글의 고유번호<br>
   4. createdAt : 공고 지원 일시<br>
   </details>
   <details>
      <summary>
         <h4>
Post
         </h4>
      </summary>
   1. postNum : 공고 고유번호 ( pk ) <br>
   2. title : 공고 제목<br>
   3. content : 공고 내용<br>
   4. createdAt : 공고 작성 일시<br>
   5. companyNum : 공고 기업 고유번호 ( fk ) <br>
   6. position : 채용 포지션<br>
   7. reward : 채용 보상금<br>
   8. skill : 사용 기술<br>
   9. legion : 지역<br>
   10. country : 국가<br>
   </details>

