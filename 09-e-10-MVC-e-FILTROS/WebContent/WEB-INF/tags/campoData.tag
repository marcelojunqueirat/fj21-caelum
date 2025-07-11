<%@ attribute name="id" required="true"%>
<%@ attribute name="value" required="false" %>

<input type="text" id="${id}" name="${id}" value="${value != null ? value : ''}" />

<script>
//	$("#${id}").datepicker({
//		dateFormat : 'dd/mm/yy'
//	});

	$(function() {
		$("#${id}").datepicker({
			dateFormat : 'dd/mm/yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>