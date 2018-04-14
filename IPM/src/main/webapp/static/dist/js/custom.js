$(function() {
	$("#myTable").DataTable();
	$('#datemask, #datemaskFrom, #datemaskTo').inputmask('dd/mm/yyyy', {
		'placeholder' : 'dd/mm/yyyy'
	});
	$("#phone").inputmask({
		"mask" : "09999 999 999"
	});
});

$(document).ready(function() {
	$("#statusForm :input").attr("disabled", true);
	$("#statusBtn").attr("disabled", false);
	$("#statusBtn").click(function() {
		$("#headerUser").html("Update");
		$("#pathUser").html("Update");
		$("#titleUser").html("Update");
		$("#statusForm :input").removeAttr("disabled");
		$("#btnUpdateAdmin").css("display", "block");
		$("#statusBtn").css("display", "none");
	})

	$("#statusMajor :input").attr("disabled", true);
	$("#statusBtnMajor").attr("disabled", false);
	$("#statusBtnMajor").click(function() {
		$("#headerMajor").html("Update");
		$("#pathMajor").html("Update");
		$("#titleMajor").html("Update");
		$("#statusMajor :input").removeAttr("disabled");
		$("#btnUpdateMajor").css("display", "block");
		$("#statusBtnMajor").css("display", "none");
	});
	// confirm duplicate password
	$("#confirmPassAdmin").keyup(function() {
		var newPass = $("#newPassAdmin").val();
		var confirmPass = $("#confirmPassAdmin").val();
		var err = "";
		if (confirmPass != newPass) {
			err = "password not match";
		}
		$("#passError").css("color", "red");
		$("#passError").html(err);
	});

	// ajax: confirm password
	$("#type").change(function() {
		var typeVal = $("#type").val();
		$.ajax({
			url : "/IPM/admin/info/change",
			type : "GET",
			data : "type=" + typeVal,
			success : function(data) {
				var ads = "";
				$("#typeDigit").html("<option>pham tan phat</option>");
			},
			error : function() {
			}
		});
	});

})

// script of QuanPA1: page Hr edit candidate
$(window).load(function() {
	$('.edit-candidate').prop('disabled', true);
});
$('#statusBtn').click(function() {
	$('.edit-candidate').prop('disabled', false);
});

// Kiet
$(document).ready(
		function() {
			$(function() {
				$('input[name="daterange"]').daterangepicker({
					locale : {
						format : 'DD-MM-YYYY'
					},
					startDate : new Date(),
					endDate : new Date()
				});
			});

			// input blur
			$('.input-createRecruitment, .createRecruitment-selection').blur(
					function() {
						if ($(this).val().length === 0) {
							$(this).css("border-color", "red").prop(
									"placeholder",
									"This filed must not be empty!");
						}
						if ($(this).val().length != 0) {
							$(this).css("border-color", "#ccc");
						}
					});

			// selection blur
			$('.createRecruitment-selection').blur(
					function() {
						if ($(this).val() == -1) {
							$(this).next().text("Must be select an option")
									.css("color", "red");
						}
					});

			$('.createRecruitment-selection').change(function() {
				if ($(this).val() > -1) {
					$(this).next().text("");
				}
			});
			// input focus
			$('.input-createRecruitment').focus(
					function() {
						$(this).css("border-color", "rgba(102,175,233,.6)")
								.prop("placeholder", "");
					});

			function validateAddRecruitment() {
				if ($('.input-createRecruitment').val().length != 0
						&& $('#inputSalaryFrom').val() <= $('#inputSalaryTo')
								.val() && $('#position-selection').val() > -1
						&& $('#major-selection').val() > -1
						&& $('input[type="checkbox"]').is(':checked')) {

					return true;
				} else {
					return false;
				}
			}

			// button next click, check empty input field
			$('#createRecruitment-next-btn').click(
					function(e) {
						e.preventDefault();
						var flag = false;
						// validate input field and text area field are empty
						if ($('.input-createRecruitment').val().length === 0) {
							$('.input-createRecruitment').css("border-color",
									"red").prop("placeholder",
									"This filed must not be empty!");
						}
						if ($('input[type="checkbox"]').is(':checked')) {
							$('#addRecruitment-skill').text("");
						} else {
							$('#addRecruitment-skill').text(
									"Must be select at least one skill").css(
									"color", "red");
						}

						// validate select option
						if ($('#position-selection').val() == -1) {
							$('#addRecruitment-position').text(
									"Must be select an option").css("color",
									"red");
						}
						if ($('#major-selection').val() == -1) {
							$('#addRecruitment-major').text(
									"Must be select an option").css("color",
									"red");
						}

						// validate salary
						if ($('input[name="inputSalaryFrom"]').val() > $(
								'input[name="inputSalaryTo"]').val()) {
							$('#addRecruitment-salary').text(
									"Salary From must less than To").css({
								color : "red",
								marginLeft : "250px"
							});
						}

						if ($('input[name="inputSalaryFrom"]').val() <= $(
								'input[name="inputSalaryTo"]').val()) {
							$('#addRecruitment-salary').text("");

						} else {

						}

						if (validateAddRecruitment() == true) {
							alert("alo");
							$('#createRecruitmentForm').submit();
						}

					});

		});
