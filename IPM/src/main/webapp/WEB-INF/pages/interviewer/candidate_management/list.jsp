<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Candidate list in Interview</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="myTable" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>No</th>
								<th>Full Name</th>
								<th>Gender</th>
								<th>CV</th>
								<th>Email</th>
								<th>Phone Number</th>
								<th>Updated At</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${candidates}" var="candidate" varStatus="loop">
								<tr>
									<td><c:out value="${loop.count}" /></td>
									<td>${candidate.fullName}</td>
									<td><c:if test="${candidate.gender==1}">
											<span class="label label-default">Male</span>
										</c:if> <c:if test="${candidate.status==0}">
											<span class="label label-default">Female</span>
										</c:if></td>
									<td>${candidate.linkCV}</td>
									<td>${candidate.email}</td>
									<td>${candidate.phoneNumber}</td>
									<td>${candidate.updatedAt}</td>
									<td><c:if test="${candidate.status==1}">
											<span class="label bg-green">Enable</span>
										</c:if> <c:if test="${candidate.status==0}">
											<span class="label bg-red">Disable</span>
										</c:if></td>
									<td>
										<div class="col-md-3">
											<a
												href='<c:url value="/interviewer/candidate/${candidate.id}/information"/>'>
												<i class="fa fa-info-circle"></i>
											</a>
										</div>
										<div class="col-md-4">
											<a href="#"><i class="fa fa-edit"></i></a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>

						</tfoot>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>