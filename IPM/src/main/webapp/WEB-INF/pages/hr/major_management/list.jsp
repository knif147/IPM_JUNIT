<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="content-header">
	<h1>
		Major management <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/hr/cruitment" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li class="active">Majors management</li>
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
					<h3 class="box-title">Major List</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th style="width: 5%">ID</th>
							<th style="width: 20%">Name</th>
							<th style="width: 40%">Description</th>
							<th style="width: 10%">Status</th>
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
								<td align="center">
									<c:choose>
										<c:when test="${major.status}">
											<span class="label bg-green">Enable</span>
										</c:when>
										<c:otherwise>
											<span class="label bg-red">Disable</span>
										</c:otherwise>
									</c:choose>
								</td>
								<td>${major.updatedAt}</td>
								<td align="center"><a
									href="<c:url value="/hr/major/${major.id}/update" />"><i
										class="fa fa-edit" title="view detail"></i></a></td>
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