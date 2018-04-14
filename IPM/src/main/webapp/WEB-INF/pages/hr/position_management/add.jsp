<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content-header">
	<h1>
		Position management <small>Add position</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/hr/recruiment" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li><a href="<c:url value="/hr/position" />">Position
				management</a></li>
		<li class="active">Add</li>
	</ol>
</section>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Add new Position</h3>
				</div>
				<c:url value="/hr/position/save" var="action" />
				<form:form action="${action}" method="GET" modelAttribute="position">
					<div class="box-body">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label>Majors</label>
									<form:select path="major" items="${majors}" itemValue="id"
										itemLabel="name" class="form-control"></form:select>
								</div>
							</div>
							<div class="col-md-6">
								<c:set var="nameError">
									<form:errors path="name" />
								</c:set>
								<div class="form-group ${not empty nameError ? 'has-error' :''}">
									<label>Name Position</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<form:input path="name" type="text"
											placeholder="Example: Developer"
											class="form-control" />
									</div>
									<form:errors path="name" class="control-label" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<c:set var="descriptionError">
									<form:errors path="description" />
								</c:set>
								<div
									class="form-group ${not empty descriptionError ? 'has-error' :''}">
									<label>Description</label>
									<form:textarea path="description" type="text" rows="5"
										placeholder="Example: Lorem Ipsum is simply dummy text of the printing and typesetting industry"
										class="form-control" />
									<form:errors path="description" class="control-label" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<button class="btn btn-flat btn-primary">
										<i class="fa fa-plus"></i> Create Position
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