<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<section class="content-header">
	<h1>
		Candidate Management <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li><a href="<c:url value="/hr/candidate"/>"> Candidate
				management </a></li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<c:if test="${not empty success}">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<i class="icon fa fa-check"></i> ${success}
		</div>
	</c:if>
	
	<a href="<c:url value="/hr/candidate/add" />"
		class="btn btn-flat btn-primary btn-add"> <i class="fa fa-plus"></i>
		Add Candidate
	</a>

	<div class="row">
		<div class="col-md-12">
			<c:url var="firstUrl" value="/hr/candidate" />
			<c:url var="lastUrl" value="/hr/candidate?page=${page.totalPages}" />
			<c:url var="prevUrl" value="/hr/candidate?page=${currentIndex - 1}" />
			<c:url var="nextUrl" value="/hr/candidate?page=${currentIndex + 1}" />

			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Candidate List</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th style="width: 5%">No</th>
							<th style="width: 20%">Full Name</th>
							<th style="width: 15%">Id Card</th>
							<th style="width: 15%">Email</th>
							<th style="width: 15%">Phone Number</th>
							<th style="width: 15%">Last Modifier</th>
							<th style="width: 5%">Status</th>
							<th style="width: 10%">Action</th>
						</tr>
						<c:forEach items="${candidates}" var="candidate" varStatus="loop">
							<tr>
								<td align="center"><c:out value="${loop.count}" /></td>
								<td>${candidate.fullName}</td>
								<td>${candidate.idCard}</td>
								<td>${candidate.email}</td>
								<td>${candidate.phoneNumber}</td>
								<td>${candidate.updatedAt}</td>
								<td align="center"><c:choose>
										<c:when test="${candidate.status}">
											<span class="label bg-green">Enable</span>
										</c:when>
										<c:otherwise>
											<span class="label bg-red">Disable</span>
										</c:otherwise>
									</c:choose>
								<td>
									<div class="col-xs-3">
										<a href="#showCV_${candidate.id}" data-toggle="modal"> <i
											class="fa fa-eye"></i>
										</a>
									</div>
									<div class="col-xs-3">
										<a
											href='<c:url value="/hr/candidate/${candidate.id}/update"/>'>
											<i class="fa fa-edit"></i>
										</a>
									</div>
								</td>
							</tr>
							<div id="showCV_${candidate.id}" class="modal fade">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">File CV Candidate:
												${candidate.fullName}</h4>
										</div>

										<div class="modal-body">
											<embed height="500px" width="100%"
												src='<c:url value="/upload/${candidate.linkCV}" />'></embed>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default btn-flat"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->

				<div class="box-footer clearfix">
					<ul class="pagination pagination-sm no-margin pull-right">
						<c:choose>
							<c:when test="${currentIndex == 1}">
								<li class="disabled"><a href="#">&lt;&lt;</a></li>
								<li class="disabled"><a href="#">Previous</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${firstUrl}">&lt;&lt;</a></li>
								<li><a href="${prevUrl}">Previous</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
							<c:url var="pageUrl" value="/hr/candidate?page=${i}" />
							<c:choose>
								<c:when test="${i == currentIndex}">
									<li class="active"><a href="${pageUrl}"><c:out
												value="${i}" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentIndex == page.totalPages}">
								<li class="disabled"><a href="#">Next</a></li>
								<li class="disabled"><a href="#">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${nextUrl}">Next</a></li>
								<li><a href="${lastUrl}">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>