<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="content-header">
	<h1>
		Human Resource management <small>Add new Human Resource</small>
	</h1>
	<ol class="breadcrumb">
		<li>
			<a href="<c:url value="/admin/hr" />"> <i
				class="fa fa-home"></i> Home
			</a>
		</li>
		<li>
			<a href="<c:url value="/admin/hr" />">Human Resource management</a>
		</li>
		<li class="active">
			<a href="<c:url value="/admin/hr/add" />">Add</a>
		</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Add new Human Resource</h3>
				</div>

				<c:url value="/admin/hr/save" var="action" />
				<form:form action="${action}" method="GET" accept-charset="UTF-8"
					modelAttribute="user">
					<div class="box-body">
						<div class="row">
							<div class="col-md-6">
								<c:set var="userNameError">
									<form:errors path="userName" />
								</c:set>
								<div
									class="form-group ${not empty userNameError ? 'has-error' :''}">
									<label>Account</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<form:input path="userName" type="text"
											placeholder="Example: TraNV" class="form-control" />
									</div>
									<form:errors path="userName" class="control-label" />
								</div>
							</div>

							<div class="col-md-6">
								<c:set var="emailError">
									<form:errors path="email" />
								</c:set>
								<div
									class="form-group ${not empty emailError ? 'has-error' :''}">
									<label>Email</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-envelope"></i>
										</div>
										<form:input path="email" type="text"
											placeholder="Example: TraNV@fsoft.com.vn"
											class="form-control" />
									</div>
									<form:errors path="email" class="control-label" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<c:set var="fullNameError">
									<form:errors path="fullName" />
								</c:set>
								<div
									class="form-group ${not empty fullNameError ? 'has-error' :''}">
									<label>Full name</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<form:input path="fullName" type="text"
											placeholder="Example: Nguyen Van A" class="form-control" />
									</div>
									<form:errors path="fullName" class="control-label" />
								</div>
							</div>
							<div class="col-md-6">
								<c:set var="addressError">
									<form:errors path="address" />
								</c:set>
								<div
									class="form-group ${not empty addressError ? 'has-error' :''}">
									<label>Address</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-home"></i>
										</div>
										<form:input path="address" type="text"
											placeholder="Example: Ho Chi Minh city" class="form-control" />
									</div>
									<form:errors path="address" class="control-label" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<c:set var="bdError">
									<form:errors path="dateOfBirth" />
								</c:set>
								<div class="form-group ${not empty bdError ? 'has-error' :''}">
									<label>Date of birth:</label>
									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<form:input type="text" path="dateOfBirth"
											class="form-control pull-right"
											placeholder="Example: 22/10/1995" id="datemask" />
									</div>
									<form:errors path="dateOfBirth" class="control-label" />
								</div>
							</div>
							<div class="col-md-6">
								<c:set var="phoneError">
									<form:errors path="phoneNumber" />
								</c:set>
								<div
									class="form-group ${not empty phoneError ? 'has-error' :''}">
									<label>Phone number</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-phone"></i>
										</div>
										<form:input path="phoneNumber" type="text"
											placeholder="Example: 0165 654 4511" class="form-control"
											id="phone" />
									</div>
									<form:errors path="phoneNumber" class="control-label" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Gender</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-transgender"></i>
										</div>
										<form:select path="gender" class="form-control">
											<form:option value="true" label="Male" />
											<form:option value="false" label="Female" />
										</form:select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<button class="btn btn-flat btn-primary pull-right">
										<i class="fa fa-plus"></i> Create Human Resource
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