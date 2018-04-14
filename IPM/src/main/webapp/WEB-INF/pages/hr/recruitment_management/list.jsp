<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<section class="content-header">
	<h1>
		Recruitment management <small> Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active"><a href="#">Recruitment management</a></li>
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
	
	<a href="<c:url value="/hr/recruitment/group/${group}/add" />"
		class="btn btn-flat btn-primary btn-add"> <i class="fa fa-plus"></i> Add new Recruitment
	</a>
	
	<div class="row">
		<div class="col-md-12">
			<c:url var="firstUrl" value="/hr/recruitment/group/${group}" />
			<c:url var="lastUrl" value="/hr/recruitment/group/${group}?page=${page.totalPages}" />
			<c:url var="prevUrl" value="/hr/recruitment/group/${group}?page=${currentIndex - 1}" />
			<c:url var="nextUrl" value="/hr/recruitment/group/${group}?page=${currentIndex + 1}" />

			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Recruitment List</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th style="width: 5%">ID</th>
							<th style="width: 15%">Name</th>
							<th style="width: 20%">Major</th>
							<th style="width: 10%">Position</th>
							<th style="width: 10%">Quantity</th>
							<th style="width: 10%">Status</th>
							<th style="width: 20%">Last Modifier</th>
							<th style="width: 10%">Action</th>
						</tr>
						
						<!-- 
						<c:forEach items="${recruitments}" var="recruitment" varStatus="loop">
							<tr>
								<td>
									<c:choose>
										<c:when test="${currentIndex == 1}">
											<c:out value="${loop.count}" />
										</c:when>
										<c:otherwise>
											<c:out value="${loop.count + 10 * (currentIndex -1)}" />
										</c:otherwise>
									</c:choose>
								</td>
								<td>${recruitment.name}</td>
								<td>${recruitment.groupRecruitment.major.name}</td>
								<td>${recruitment.position.name}</td>
								<td>${recruitment.quantity}</td>
								<td align="center">
									<c:choose>
										<c:when test="${recruitment.status}">
											<span class="label bg-green">Enable</span>
										</c:when>
										<c:otherwise>
											<span class="label bg-red">Disable</span>
										</c:otherwise>
									</c:choose>
								</td>
								<td>${recruitment.updatedAt}</td>
								<td>${recruitment.name}</td>
							</tr>
						</c:forEach>
						 -->
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
							<c:url var="pageUrl" value="/hr/recruitment/group/${group}?page=${i}" />
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
	</div>
</section>

