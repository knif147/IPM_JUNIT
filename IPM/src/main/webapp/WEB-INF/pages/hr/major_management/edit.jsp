<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content-header">
	<h1>
		Major management <small>Update majors</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/hr/recruitment" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li><a href="<c:url value="/hr/major" />">Major management</a>
		</li>
		<li class="active">Add</li>
	</ol>
</section>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Add new Major</h3>
				</div>
				<c:url value="/hr/major/save" var="action" />
				<form:form action="${action}" method="GET" accept-charset="UTF-8"
					modelAttribute="major">
					<div class="box-body">
						<form:hidden path="id" />
						<form:hidden path="createdAt" />
						<form:hidden path="updatedAt" />
						<div class="row">
							<div class="col-md-6">
								<c:set var="nameError">
									<form:errors path="name" />
								</c:set>
								<div class="form-group ${not empty nameError ? 'has-error' :''}">
									<label>Name Major</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<form:input path="name" type="text"
											placeholder="Example: Information Technology"
											class="form-control" />
									</div>
									<form:errors path="name" class="control-label" />
								</div>
							</div>
							
							<div class="col-md-6">
								<div class="form-group">
									<label>Status</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-certificate"></i>
										</div>
										<form:select path="status" class="form-control">
											<form:option value="true" label="Enable" />
											<form:option value="false" label="Disable" />
										</form:select>
									</div>
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
										<i class="fa fa-edit"></i> Update Major
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