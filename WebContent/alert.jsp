<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>

<script type="text/javascript">
(function(){
	if (${result}==1) {
		alert("${value}");
		location.href="Main.jsp";
	}else if (${result}==2) {
		alert("${value}");
		location.href="Loginindex.jsp";
	}else if (${result}==3) {
		alert("${value}");
		location.href="index.jsp";
	}else if (${result}==4) {
		alert("${value}");
		location.href="UserModify.jsp";
	}
	else if (${result}==5) {
		alert("${value}");
		location.href="pagingControll";
	}
	
})();

</script>
</html>