<%@ include file="../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	<form class="form-horizontal" method="POST" action="creer">
	<fieldset>
	
		<!-- Form Name -->
		<legend>Ajouter un Bulletin</legend>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="entreprise">Periode</label>
		  <div class="col-md-4">
		    <select id="periode" name="periode" class="form-control">
		    	<c:forEach items="${ periode }" var="periode">
		    		<option value="${ periode.id }">${periode.dateDebut} - ${periode.dateFin}</option>
		    	</c:forEach>
		    </select>
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="profil">Matricule</label>
		  <div class="col-md-4">
		    <select id="remunerationEmploye" name="remunerationEmploye" class="form-control">
		    <c:forEach items="${ remunerationEmploye }" var="remunerationEmploye">
		    		<option value="${ remunerationEmploye.id }">${remunerationEmploye.matricule}</option>
		    </c:forEach>
		    </select>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="Prime">Prime Exceptionnelle</label>  
		  <div class="col-md-4">
		  <input id="primeExceptionnelle" name="primeExceptionnelle" type="text" placeholder="" class="form-control input-md">
		    
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
	</form>

<%@ include file="../footer.jsp" %>
