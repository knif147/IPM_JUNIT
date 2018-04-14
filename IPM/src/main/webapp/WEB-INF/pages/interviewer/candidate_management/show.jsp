<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form'%>
<section class="content-header">
	<h1>
		Interview Management<small>View</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li><a href="#">Interview Management</a></li>
		<li class="active">View</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">
						<span id="titleUser">Candidate Information</span> detail
					</h3>
				</div>
				<div class="box-body">
					<div class="row">
						<div class="col-md-12" id="statusForm">
							<!-- left -->
							<form:form method="POST" accept-charset="UTF-8"
								modelAttribute="candidate">
								<div class="col-md-6">
									<div class="form-group">
										<label>Id Card</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-steam-square"></i>
											</div>
											<form:input path="idCard" type="text"
												class="form-control edit-candidate" placeholder="" />
										</div>
									</div>
									<div class="form-group">
										<label>Email</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-envelope"></i>
											</div>
											<form:input path="email" type="text"
												class="form-control edit-candidate" />
										</div>
									</div>
									<div class="form-group">
										<label>Full name</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-user"></i>
											</div>
											<form:input path="fullName" type="text"
												class="form-control edit-candidate" />
										</div>
									</div>
									<div class="form-group">
										<label>Address</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-home"></i>
											</div>
											<form:input path="address" type="text"
												class="form-control edit-candidate" />
										</div>
									</div>
								</div>
								<!-- right -->
								<div class="col-md-6">
									<div class="form-group">
										<label>Date of birth:</label>
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<form:input path="dateOfBirth" type="text"
												class="form-control pull-right edit-candidate" id="datemask" />
										</div>
									</div>
									<div class="form-group">
										<label>Phone number</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-phone"></i>
											</div>
											<form:input path="phoneNumber" type="text" id="phone"
												class="form-control edit-candidate"
												data-inputmask="&quot;mask&quot;: &quot;(999) 999-9999&quot;"
												data-mask="" />
										</div>
									</div>
									<div class="form-group">
										<label>Gender</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-venus-mars"></i>
											</div>
											<form:input path="gender" type="text"
												class="form-control edit-candidate" />
										</div>
										
									</div>
									<div class="form-group">
										<label>Status</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-ban"></i>
											</div>
											<select
												class="form-control select2 select2-hidden-accessible edit-candidate"
												style="width: 100%;" tabindex="-1" aria-hidden="true">
												<option selected="selected">Enable</option>
												<option>Disable</option>
											</select>
										</div>
									</div>
								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>