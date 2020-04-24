$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(contract, status){
			
			$('#idEdit').val(contract.id);
			$('#typeEdit').val(contract.type);
			$('#detailsEdit').val(contract.details);
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