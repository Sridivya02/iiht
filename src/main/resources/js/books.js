function postToURL(value) {
		var form = document.createElement("form");
		form.setAttribute("method", "POST");
		form.setAttribute("action", "/Spring_Assignment_MVC/deleteBook/"+ value);		
		document.body.appendChild(form);		
		form.submit();
		document.body.removeChild(form);		
	}

	$(function() {
		//Tabs
		$('#booksAndSubjects').tabs();
		$('#addBook').button();
		$('#addSubject').button();
		$('#editSubject').button();
		$('#deleteSubject').button();
		$('#searchSubject').button();

		$('#addBook').click(function() {
			document.location.href = "/Spring_Assignment_MVC/addEditBookPage";
		});
	})