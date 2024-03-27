<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<div data-th-replace="header :: header">머리말</div>

<h1>회원</h1>
<form action="update" data-th-action="@{update}" data-th-object="${member}"
      enctype='multipart/form-data'
      method='post'>
  <div>
    사진:
    <a data-th-href="@{'https://kr.object.ncloudstorage.com/bitcamp-devops128/member/' + *{photo}}" data-th-if="*{photo}">
      <img data-th-src="@{'https://kr.object.ncloudstorage.com/bitcamp-devops128/member/' + *{photo}}" height='80px'></a><br>
    <a data-th-unless="*{photo}" href='/img/default-photo.jpeg'>
      <img height='80px' src='/img/default-photo.jpeg'></a><br>
    <input name='file' type='file'>
  </div>
  <div>
    번호: <input data-th-value='*{no}' name='no' readonly type='text' value="21">
  </div>
  <div>
    이메일: <input data-th-value='*{email}' name='email' type='text' value="hong@test.com">
  </div>
  <div>
    이름: <input data-th-value='*{name}' name='name' type='text' value="홍길동">
  </div>
  <div>
    암호: <input name='password' type='password'>
  </div>
  <div>
    가입일: <input data-th-value="${#dates.format(member.createdDate,'yyyy-MM-dd')}" readonly
                type='text' value="2024-03-27">
  </div>
  <div>
    <button>변경</button>
    <a data-th-href="@{delete(no=*{no})}" href="delete.html">[삭제]</a>
  </div>
</form>

<div data-th-replace="footer :: footer">꼬리말</div>

</body>
</html>