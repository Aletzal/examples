<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>info</title>
  </head>
  <body>
    <p>
      <font size="6" color="#00a500">
        Форум
        <a href="logoff">Выход</a>
      </font>
    </p>
    <hr/>
    <p>
    Текущий пользователь : 
      <font size="3" color="#00a500">
        <c:out value="${sessionScope.person}"/>
      </font>
    </p>
    <hr/>
      <c:out value="${applicationScope.persons}"/>
    <table cellspacing="2" cellpadding="3" border="1" width="100%">
      <tr>
        <th>
          Автор сообщения
        </th>
        <th>
          Дата
        </th>
        <th>
          Текст сообщения
        </th>
      </tr>
      <c:forEach items="${requestScope.top10}" var="row">
       <tr>
        <td width="33%">${row.nick}</td>
        <td width="33%">${row.d}</td>
        <td width="34%">${row.text}</td>
      </tr>
      </c:forEach>
    </table>
    <form action="insertmessage" method="post">
      <input type="text" name="text"/>
      <button type="submit" name="Отправить">
        Button
      </button>
    </form><a href="report">Отчет</a>
  </body>
</html>