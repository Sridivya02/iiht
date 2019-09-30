function postToURLSubject(value) {
		var form = document.createElement("form");
		form.setAttribute("method", "POST");
		form.setAttribute("action", "/Spring_Assignment_MVC/deleteSubject/"+ value);		
		document.body.appendChild(form);
		form.submit();
		document.body.removeChild(form);		
	}

	$(function() {
		//Tabs
		//$('#booksAndSubjects').tabs();
		$('#addSubject').click(function() {
			document.location.href = "/Spring_Assignment_MVC/addEditSubjectPage";
		});
	})