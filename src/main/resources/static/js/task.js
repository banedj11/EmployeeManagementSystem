$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(task, status){
			
			$('#idEdit').val(task.id);
			$('#employeeAddEdit').val(task.employee_id);
			$('#titleEdit').val(task.title);
			$('#descriptionEdit').val(task.description);
			$('#startDateEdit').val(task.startDate);
			$('#expectedFinishDateEdit').val(task.expectedFinishDate);
		});
		$('#editModal').modal();
		
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
});