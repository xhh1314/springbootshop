<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%String path=request.getContextPath(); 
System.out.println(path);
%>
</head>
  <frameset rows="10%,*">
 <frame name=head src="${ctx}/jsp/head.jsp">
 <frameset cols="15%,*">
 <frame name=left src="${ctx}/jsp/left.jsp">
 <frame name=body src="${ctx}/jsp/body.jsp">
 </frameset>
 </frameset>
</html>