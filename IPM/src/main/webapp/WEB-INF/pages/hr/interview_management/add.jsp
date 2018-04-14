<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<section class="content-header">
	<h1>
		Interview Management <small>create</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li><a href="#">Interview Management</a></li>
		<li class="active">Create</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<div class="row">
		<div class="col-xs-12">
			<div class="box box-default">
				<div class="box-header with-border">
					<h3 class="box-title">Create Interview</h3>
				</div>
				<div class="box-body">
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#modal-default">Add</button>

				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-default">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Fill the information of interview</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Interview Name</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-user"></i>
							</div>
							<input type="text" class="form-control" placeholder="Enter ...">
						</div>
						<div class="form-group">
							<label>Description</label>
							<textarea class="form-control" style="resize: none" rows="3"
								placeholder="Enter ..."></textarea>
						</div>

						<div class="form-group">
							<label>Date and time</label>
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control" id="datetimepicker"
									placeholder="dd/mm/yyyy h:mm:ss" />
							</div>
							<div class="row">
								<div class="col-lg-6">
									<div class="input-group">
										<label>Type</label> <select class="form-control">
											<option>HR</option>
											<option>Interviewer</option>
										</select>
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-6">
									<div class="input-group">
										<label>Name</label> <select class="form-control">
											<option>Tuancnh</option>
											<option>Cuongpnb</option>
										</select>
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
							</div>
							<div class="form-group">
								<label>Room</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-home"></i>
									</div>
									<input type="text" class="form-control" placeholder="Enter ...">
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default pull-left"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Add</button>
							</div>
						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->

		</div>

		<!-- /.modal -->
</section>
