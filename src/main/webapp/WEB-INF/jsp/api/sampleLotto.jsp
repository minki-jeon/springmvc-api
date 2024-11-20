<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%-- favicon.ico 404 (Not Found) --%>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">

<body>
	${resultApi}
</body>

<script>

// const pageIdx = 1;
// const pageSize = 2;
// const returnType = "JSON";
const drwNo = 1146;			/* 회차번호 */
const urlString = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="
				+ drwNo
				;
				
const answer = fetch(urlString, {
//     headers:{
//       "x-nxopen-api-key": API_KEY
//     }
})
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error(error))

/** 로또는 CORS 이슈로 Script로 바로 호출 불가 **/
console.log(answer)

</script>
</html>