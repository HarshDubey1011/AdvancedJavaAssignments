<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "org.hibernate.SessionFactory, org.hibernate.Session,org.hibernate.query.Query,com.hibernate_id.prac_hibernate.entity.Category,java.util.Iterator"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<%
		SessionFactory hibernateFactory = (SessionFactory)application.getAttribute("hibernateFactory");
		Session hibernateSession = hibernateFactory.openSession();
		Query<Category> query = hibernateSession.createNamedQuery("getAllCategories",Category.class);
		Iterator<Category> iter = query.getResultList().iterator();
		while(iter.hasNext()) {
			Category objCategory = iter.next();
	%>
	<tr>
	<td>
	<%=objCategory.getCategoryName() %>
	</td>
	<td>
	<%=objCategory.getCategoryDescription() %>
	</td>
	</tr>
	<%
		}
	%>
	</table>
</body>
</html>