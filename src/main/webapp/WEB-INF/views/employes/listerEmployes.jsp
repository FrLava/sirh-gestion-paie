<%@ include file="../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table class="table">
		<thead>
			<tr>
				<th>Matricule</th>
				<th>Entreprise</th>
				<th>Profil</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ listEmpl }" var="listEmpl">
			<tr>
				<td>${ listEmpl.dateCreation }</td>
				<td>${ listEmpl.matricule }</td>
				<td>${ listEmpl.entreprise.denomination }</td>
				<td>${ listEmpl.profilRemuneration.code }</td>
				<td>${ listEmpl.grade.code }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<%@ include file="../footer.jsp" %>