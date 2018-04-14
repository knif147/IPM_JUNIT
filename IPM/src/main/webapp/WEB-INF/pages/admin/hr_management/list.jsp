<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<section class="content-header">
	<h1>
		Human Resource manage <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/admin/hr" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li class="active"><a href="<c:url value="/admin/hr" />">Human
				Resource management</a></li>
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
	<a href="<c:url value="/admin/hr/add" />"
		class="btn btn-flat btn-primary btn-add"> <i class="fa fa-plus"></i>
		Add Human Resource
	</a>
	<div class="row">
		<div class="col-md-12">
			<c:url var="firstUrl" value="/admin/hr" />
			<c:url var="lastUrl" value="/admin/hr?page=${page.totalPages}" />
			<c:url var="prevUrl" value="/admin/hr?page=${currentIndex - 1}" />
			<c:url var="nextUrl" value="/admin/hr?page=${currentIndex + 1}" />

			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Human Resource List</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-striped table-bordered">
						<tr role="row">
							<th width="3%">ID</th>
							<th width="7%">Account</th>
							<th width="15%">Full name</th>
							<th width="10%">Phone number</th>
							<th width="20%">Email</th>
							<th width="25%">Address</th>
							<th width="5%">Status</th>
							<th width="10%">Last Modifier</th>
							<th width="5%">Action</th>
						</tr>
						<c:forEach items="${users}" var="hr" varStatus="loop">
							<tr role="row" class="odd">
								<td><c:choose>
										<c:when test="${currentIndex == 1}">
											<c:out value="${loop.count}" />
										</c:when>
										<c:otherwise>
											<c:out value="${loop.count + 10 * (currentIndex -1)}" />
										</c:otherwise>
									</c:choose>
								</td>
								<td>${hr.userName}</td>
								<td>${hr.fullName}</td>
								<td>${hr.phoneNumber}</td>
								<td>${hr.email}</td>
								<td>${hr.address}</td>
								<td align="center"><c:choose>
										<c:when test="${hr.status}">
											<span class="label bg-green">Enable</span>
										</c:when>
										<c:otherwise>
											<span class="label bg-red">Disable</span>
										</c:otherwise>
									</c:choose></td>
								<td>${hr.updatedAt}</td>
								<td align="center"><a
									href="<c:url value="/admin/hr/${hr.id}/update" />"><i
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
							<c:url var="pageUrl" value="/admin/hr?page=${i}" />
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