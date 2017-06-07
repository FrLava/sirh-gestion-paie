<%@ include file="../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
	<form class="form-horizontal" method="POST" action="creer">
	<fieldset>
	
		<!-- Form Name -->
		<legend>Ajouter un employé</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="Matricule">Matricule</label>  
		  <div class="col-md-4">
		  <input id="matricule" name="matricule" type="text" placeholder="" class="form-control input-md">
		    
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="entreprise">Entreprise</label>
		  <div class="col-md-4">
		    <select id="entreprise" name="entreprise" class="form-control">
		    	<c:forEach items="${ entreprise }" var="entreprise">
		    		<option value="${ entreprise.id }">${entreprise.denomination}</option>
		    	</c:forEach>
		    </select>
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="profil">Profil</label>
		  <div class="col-md-4">
		    <select id="profil" name="profil" class="form-control">
		    <c:forEach items="${ profil }" var="profil">
		    		<option value="${ profil.id }">${profil.code}</option>
		    </c:forEach>
		    </select>
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="grade">Grade</label>
		  <div class="col-md-4">
		    <select id="grade" name="grade" class="form-control">
		    <c:forEach items="${ grade }" var="grade">
		    		<option value="${ grade.id }">${grade.code}</option>
		    </c:forEach>
		    </select>
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="add"></label>
		  <div class="col-md-4">
		    <button type="submit" class="btn btn-primary">Ajouter</button>
		  </div>
		</div>
	
	</fieldset>
	<sec:csrfInput/>
	</form>

<%@ include file="../footer.jsp" %>
