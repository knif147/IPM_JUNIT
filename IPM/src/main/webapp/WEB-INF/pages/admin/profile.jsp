<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<section class="content-header">
	<h1>
		Admin profile manage <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/admin/hr" />"> <i
				class="fa fa-users"></i> Human Resource manage
		</a></li>
		<li class="active"><a href="<c:url value="/admin/hr/add" />">
				Add </a></li>
	</ol>
</section>
<section class="content">
	<c:if test="${not empty success}">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<i class="icon fa fa-check"></i> ${success}
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-12">
			<!-- Custom Tabs (Pulled to the right) -->
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs pull-right">
					<li><a href="#tab_resetpass" data-toggle="tab">Change
							password</a></li>
					<li class="active"><a href="#tab-info" data-toggle="tab">Account
							Information</a></li>
					<li class="pull-left header"><i class="fa fa-th"></i>Update
						Profile</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="tab_resetpass">
						<div class="row">
							<div class="col-md-6 col-sm-12">
								<div class="form-group">
									<label>Old Password</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<input type="password" id="oldPassAdmin"
											placeholder="Enter your old password" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label>New Password</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<input type="password" id="newPassAdmin"
											placeholder="Enter your new password" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label>Confirm Password</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-pencil"></i>
										</div>
										<input type="password" id="confirmPassAdmin"
											placeholder="Comfirm new password" class="form-control" />
									</div>
									<p id="passError"></p>
								</div>
								<div class="form-group">
									<div class="input-group pull-right">
										<button class="btn btn-flat bg-primary" id="btnChangePass">
											<i class="fa fa-edit (alias)"> Change password</i>
										</button>
									</div>
								</div>
								<p id="errPass"></p>
							</div>
						</div>
					</div>
					<!-- /.tab-pane -->
					<div class="tab-pane active" id="tab-info">
						<div class="box-body" id="statusForm">
							<c:url value="/admin/info/update" var="action" />
							<form:form action="${action }" method="get" modelAttribute="user">
								<div class="row">
									<div class="col-md-12">
										<div class="row">
											<div class="col-md-6">
												<c:set var="userNameError">
													<form:errors path="userName" />
												</c:set>
												<div
													class="form-group ${not empty userNameError ? 'has-error' : ''} ">
													<label>Account</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-pencil"></i>
														</div>
														<form:input type="text" placeholder="Example: TraNV"
															class="form-control" path="userName" />
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<c:set var="emailError">
													<form:errors path="email" />
												</c:set>
												<div
													class="form-group ${not empty emailError ? 'has-error' : ''}">
													<label>Email</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-envelope"></i>
														</div>
														<form:input type="text"
															placeholder="Example: TraNV@fsoft.com.vn"
															class="form-control" path="email" />
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
													class="form-group ${not empty fullNameError ? 'has-error' : ''}">
													<label>Full name</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-pencil"></i>
														</div>
														<form:input type="text"
															placeholder="Example: Nguyen Van A" class="form-control"
															path="fullName" />
													</div>
													<form:errors path="fullName" class="control-label" />

												</div>
											</div>
											<div class="col-md-6">
												<c:set var="addressError">
													<form:errors path="address" />
												</c:set>
												<div
													class="form-group ${not empty fullNameError ? 'has-error' : ''}">
													<label>Address</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-home"></i>
														</div>
														<form:input type="text"
															placeholder="Example: Ho Chi Minh city"
															class="form-control" path="address" />
													</div>
													<form:errors path="address" class="control-label" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<c:set var="dateError">
													<form:errors path="dateOfBirth" />
												</c:set>
												<div
													class="form-group ${not empty dateError ? 'has-error' : ''}">
													<label>Date of birth:</label>
													<div class="input-group date">
														<div class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</div>
														<form:input type="text" class="form-control pull-right"
															placeholder="Example: 22/10/1995" id="datemask"
															path="dateOfBirth" />
													</div>
													<form:errors path="dateOfBirth" class="control-label" />
												</div>
											</div>
											<div class="col-md-6">
												<c:set var="phoneError">
													<form:errors path="phoneNumber" />
												</c:set>
												<div
													class="form-group ${not empty phoneError ? 'has-error' : ''}">
													<label>Phone number</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-phone"></i>
														</div>
														<form:input type="text"
															placeholder="Example: 0165 654 4511" class="form-control"
															id="phone" path="phoneNumber" />
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
													<button type="submit"
														class="btn btn-flat btn-primary pull-right"
														id="btnUpdateAdmin">
														<i class="fa  fa-edit (alias)"></i> Update Profile Admin
													</button>
													<span class="btn btn-flat btn-primary pull-right"
														id="statusBtn"> <i class="fa fa-edit (alias)"></i>
														Edit Profile Admin
													</span>
												</div>
											</div>
										</div>
										<form:hidden path="id" />
										<form:hidden path="password" />
										<form:hidden path="role" />
										<form:hidden path="confirmPassword" />
										<form:hidden path="createdAt" />
										<form:hidden path="updatedAt" />
									</div>
								</div>
							</form:form>
						</div>

					</div>
					<!-- /.tab-pane -->
				</div>
				<!-- /.tab-content -->
			</div>
			<!-- nav-tabs-custom -->
		</div>
	</div>
</section>
<select id="type"><option value="123">123</option>
	<option value="456">456</option></select>
<select id="typeDigit"></select>





