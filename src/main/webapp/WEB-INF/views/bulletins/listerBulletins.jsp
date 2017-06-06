<%@ include file="../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table class="table">
		<thead>
			<tr>
				<th>Periode</th>
				<th>Matricule</th>
				<th>Prime Exceptionnelle</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ listBull }" var="listBull">
			<tr>
				<td>${ listBull.periode.dateDebut } - ${ listBull.periode.dateFin }</td>
				<td>${ listBull.remunerationEmploye.matricule }</td>
				<td>${ listBull.primeExceptionnelle }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<%@ include file="../footer.jsp" %>