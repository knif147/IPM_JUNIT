<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html	>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Recruitment | IPM</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<section class="content-header">
		<h4>Article Manager</h4>
		<ol class="breadcrumb">
			<li><a href="<c:url value="/admin/article" />"><i
					class="fa fa-tag"></i> Article Manager</a></li>
			<li class="active">Add new article</li>
		</ol>
	</section>

	<div class="col-md-3"></div>
	<form class="form-horizontal" action="" role="form">
		<!-- <div class="form-group">
      <label for="inputType" class="col-md-2 control-label">Type</label>
      <div class="col-md-3">
          <input type="text" class="form-control" id="inputType" placeholder="Type">
      </div>
    </div> -->
		<div class="form-group">
			<!-- <label for="inputType" class="col-md-2 control-label">Major</label> -->
			<div class="col-md-6">
				<!-- Major and position start -->
				<div class="form-group row">
					<label for="inputMajor" class="col-md-1 control-label">Major</label>
					<div class="col-md-5">
						<select class="form-control">
							<option selected="selected">IT</option>
							<option>Accoutant</option>
							<option>CEO</option>
						</select>
					</div>
					<label for="inputPosition" class="col-md-1 control-label">Position</label>
					<div class="col-md-5">
						<select class="form-control">
							<option selected="selected">Developer</option>
							<option>PM</option>
							<option>SA</option>
						</select>
					</div>
				</div>
				<!-- Major and position end -->

				<!-- Skill and quantity start -->
				<div class="form-group row">
					<label for="inputSkill" class="col-md-1 control-label">Skill</label>
					<div class="col-md-5">
						<select class="form-control">
							<option selected="selected">Java</option>
							<option>Asp .Net</option>
							<option>C++</option>
						</select>
					</div>
					<label for="inputQuantity" class="col-md-1 control-label">Quantity</label>
					<div class="col-md-5">
						<input class="form-control" type="text" name="inputQuantity"
							value="10">
					</div>
				</div>
				<!-- skill and quantity end -->

				<!-- salary start -->
				<div class="form-group row">
					<label for="inputSalary" class="col-md-1 control-label">Salary</label>
					<label for="inputSalaryFrom" class="col-md-1 control-label">From</label>
					<div class="col-md-4 ">
						<input class="form-control" type="number" name="inputSalaryFrom"
							min="0" placeholder="Triệu Đồng">
					</div>
					<span class="col-md-1 control-label"></span> <label
						for="inputSalaryTo" class="col-md-1 control-label">To</label>
					<div class="col-md-4">
						<input class="form-control" type="number" name="inputSalaryTo"
							min="0" placeholder="Triệu Đồng">

					</div>
				</div>
				<!-- salary end -->

				<!-- start date, end date start -->
				<div class="form-group row">
					<label for="inputStartDate" class="col-md-2 control-label">Start
						Date</label>
					<div class="col-md-4">
						<input type="text" class="form-control pull-right"
							id="inputStartDate">
					</div>
					<label for="inputEndDate" class="col-md-2 control-label">End
						Date</label>
					<div class="col-md-4">
						<input class="form-control" id="date" name="date"
							placeholder="MM/DD/YYY" type="text" />
					</div>
				</div>
				<!-- start date, end date end -->

				<!-- Button start -->
				<div class="form-group row">
					<button type="submit" class="btn btn-default">Cancel</button>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
				<!-- Button end -->
			</div>
		</div>
	</form>

</body>
</html>