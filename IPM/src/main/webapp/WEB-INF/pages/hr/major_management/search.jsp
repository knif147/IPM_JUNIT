<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="content-header">
	<h1>
		Human Resource manage <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/hr/cruitment" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li class="active"><a href="<c:url value="/hr/major" />">Manage
				majors</a></li>
	</ol>
</section>
<section class="content">
	<a href="<c:url value="/hr/major/add" />"
		class="btn btn-flat btn-primary btn-add"> <i class="fa fa-plus"></i>
		Add Major
	</a>
	<div class="row">
		<div class="col-md-12">
			<c:url var="firstUrl" value="/hr/major" />
			<c:url var="lastUrl" value="/hr/major?page=${page.totalPages}" />
			<c:url var="prevUrl" value="/hr/major?page=${currentIndex - 1}" />
			<c:url var="nextUrl" value="/hr/major?page=${currentIndex + 1}" />

			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Majors List</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="main-search">
						<div class="row">
							<c:url value="/hr/major/search" var="action"/>
							<form action="${action}" method="get">
								<div class="col-xs-6 col-md-3">
									<input type="text" class="form-control"
										placeholder="Search by name major" name="name">
								</div>

								<div class="col-xs-3">
									<button class="btn btn-flat btn-primary pull-right">
										<i class="fa fa-search"></i> Search Major
									</button>
								</div>
							</form>
						</div>
					</div>
					<table class="table table-striped table-bordered">
						<tr>
							<th style="width: 5%">ID</th>
							<th style="width: 20%">Name</th>
							<th style="width: 50%">Description</th>
							<th style="width: 20%">Last Modifier</th>
							<th style="width: 5%">Action</th>
						</tr>
						<c:forEach items="${majors}" var="major" varStatus="loop">
							<tr>
								<td><c:choose>
										<c:when test="${currentIndex == 1}">
											<c:out value="${loop.count}" />
										</c:when>
										<c:otherwise>
											<c:out value="${loop.count + 10 * (currentIndex -1)}" />
										</c:otherwise>
									</c:choose></td>
								<td>${major.name}</td>
								<td>${major.description}</td>
								<td>${major.updatedAt}</td>
								<td><span class="badge bg-red">55%</span></td>
							</tr>
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
							<c:url var="pageUrl" value="/hr/major?page=${i}" />
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