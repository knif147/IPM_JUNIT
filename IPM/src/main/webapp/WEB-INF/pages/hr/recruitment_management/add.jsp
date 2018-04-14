<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-header">
	<h1>
		Recruitment management <small> Add new recruitment</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li>Recruitment management</li>
		<li class="active">Add</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Add new Recruitment</h3>
				</div>
				<c:url value="/hr/recruitment/group/${group}/save" var="action" />
				<form:form action="${action}" method="GET" accept-charset="UTF-8"
					modelAttribute="recruitment">
					<div class="box-body">
						<div class="row">
							<div class="col-md-6">
								<c:set var="nameError">
									<form:errors path="name" />
								</c:set>
								<div class="form-group ${not empty nameError ? 'has-error' :''}">
									<label>Name Recruitment</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<form:input path="name" type="text"
											placeholder="Example: Fresher Java" class="form-control" />
									</div>
									<form:errors path="name" class="control-label" />
								</div>
							</div>

							<div class="col-sm-6">
								<div class="form-group">
									<label>Position</label>
									<form:select path="position" items="${positions}"
										itemValue="id" itemLabel="name" class="form-control"></form:select>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<c:set var="quantityError">
									<form:errors path="quantity" />
								</c:set>
								<div
									class="form-group ${not empty quantityError ? 'has-error' :''}">
									<label>Quantity</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-users"></i>
										</div>
										<form:input path="quantity" type="number" value="1" min="1"
											class="form-control" />
									</div>
									<form:errors path="quantity" class="control-label" />
								</div>
							</div>

							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<c:set var="salaryFromError">
											<form:errors path="salaryFrom" />
										</c:set>
										<div
											class="form-group ${not empty quantityError ? 'has-error' :''}">
											<label>Salary From</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="fa fa-money"></i>
												</div>
												<form:input path="salaryFrom" type="number" value="1"
													min="1" class="form-control" />
											</div>
											<form:errors path="salaryFrom" class="control-label" />
										</div>
									</div>
									<div class="col-md-6">
										<c:set var="salaryToError">
											<form:errors path="salaryTo" />
										</c:set>
										<div
											class="form-group ${not empty salaryToError ? 'has-error' :''}">
											<label>Salary To</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="fa fa-money"></i>
												</div>
												<form:input path="salaryTo" type="number" value="1" min="1"
													class="form-control" />
											</div>
											<form:errors path="salaryTo" class="control-label" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<c:set var="timeStartError">
									<form:errors path="timeStart" />
								</c:set>
								<div
									class="form-group ${not empty timeStartError ? 'has-error' :''}">
									<label>Date From</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<form:input path="timeStart" type="text" class="form-control"
											id="datemaskFrom" placeholder="dd/mm/yyyy" />
									</div>
									<form:errors path="timeStart" class="control-label" />
								</div>
							</div>
							<div class="col-md-6">
								<c:set var="timeEndError">
									<form:errors path="timeEnd" />
								</c:set>
								<div
									class="form-group ${not empty timeEndError ? 'has-error' :''}">
									<label>Date To</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<form:input path="timeEnd" type="text" class="form-control"
											id="datemaskTo" placeholder="dd/mm/yyyy" />
									</div>
									<form:errors path="timeEnd" class="control-label" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<button class="btn btn-flat btn-primary pull-right">
										<i class="fa fa-plus"></i> Create Recruitment
									</button>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>
