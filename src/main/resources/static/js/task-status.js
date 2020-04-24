$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(task, status){
			
			$('#idEdit').val(task.id);
			$('#employeeAddEdit').val(task.employee_id);
			
		});
		$('#statusModal').modal();
		
	});
	
	
});