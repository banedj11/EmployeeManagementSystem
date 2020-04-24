$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(position, status){
			
			$('#idEdit').val(position.id);
			$('#nameEdit').val(position.name);
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