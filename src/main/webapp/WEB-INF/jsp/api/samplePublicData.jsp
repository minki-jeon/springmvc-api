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

<script type ="text/javascript" src="/js/comn/api.key.js"></script>
<script>

//* api.key.js
const API_KEY = encodeURI(__publicKey1__);
const ocid = "9aa8425eb305ff231a632c6507ab63ccc583003eb0448898768cf5ad982a332b";
const pageIdx = 1;
const pageSize = 2;
const returnType = "JSON";
const uddi = "77d5f727-417a-4f07-a1de-bb342426bb38";
const urlString = "https://api.odcloud.kr/api/3038817/v1/"
				+ "uddi:" + uddi + "?"
				+ "page=" + pageIdx + "&"
				+ "perPage=" + pageSize + "&"
				+ "returnType=" + returnType + "&"
				+ "serviceKey=" + API_KEY
				;
				
const answer = fetch(urlString, {
//     headers:{
//       "x-nxopen-api-key": API_KEY
//     }
})
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error(error))

console.log(answer)

</script>
</html>