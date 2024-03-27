<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<div data-th-replace="header :: header">머리말</div>

<h1>회원</h1>
<a href='/app/member/form'>새 회원</a>
<table border='1'>
  <thead>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
    <th>가입일</th>
  </tr>
  </thead>
  <tbody>
  <tr data-th-each="member : ${list}" data-th-object="${member}">
    <td data-th-data="*{no}">100</td>
    <td>
      <img data-th-if="*{photo}" data-th-src="@{'https://kr.object.ncloudstorage.com/bitcamp-devops128/member/' + *{photo}}" height='20px'
           src="/img/default-photo.jpeg">
      <img data-th-unless="*{photo}" height='20px' src='/img/default-photo.jpeg'>
      <a data-th-href="@{view(no=*{no})}" data-th-text="*{name}" href="view.html">홍길동</a></td>
    <td data-th-text="*{email}">hong@test.com</td>
    <td data-th-text="${#dates.format(member.createdDate, 'yyyy-MM-dd')}">2024-03-27</td>
  </tr>
  </tbody>
</table>

<div data-th-replace="footer :: footer">꼬리말</div>

</body>
</html>