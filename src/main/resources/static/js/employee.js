$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(employee, status){
			
			$('#idEdit').val(employee.id);
			$('#firstNameEdit').val(employee.firstName);
			$('#lastNameEdit').val(employee.lastName);
			$('#emailEdit').val(employee.email);
			$('#passwordEdit').val(employee.password);
			$('#mobileEdit').val(employee.mobile);
			$('#sallaryEdit').val(employee.sallary);
			$('#genderAddEdit').val(employee.gender);
			$('#addressEdit').val(employee.address);
			$('#dateOfBirthEdit').val(employee.dateOfBirth);
			$('#hireDateEdit').val(employee.hireDate);
			$('#contractAddEdit').val(employee.contract_id);
			$('#positionAddEdit').val(employee.position_id);
		});
		$('#editModal').modal();
		
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$.get(href, function(employee, status){
			
			$('#idDetails').val(employee.id);
			$('#firstNameDetails').val(employee.firstName);
			$('#lastNameDetails').val(employee.lastName);
			$('#emailDetails').val(employee.email);
			$('#mobileDetails').val(employee.mobile);
			$('#sallaryDetails').val(employee.sallary);
			$('#genderDetails').val(employee.gender);
			$('#addressDetails').val(employee.address);
			$('#dateOfBirthDetails').val(employee.dateOfBirth);
			$('#hireDateDetails').val(employee.hireDate);
			$('#contractAddDetails').val(employee.contract.type);
			$('#positionAddDetails').val(employee.position.name);
			$('#createdByDetails').val(employee.createdBy);
			//$('#createdDateDetails').val(employee.createdDate.substr(0,19).replace("T", " "));
			$('#lastModifiedByDetails').val(employee.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
		
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
});