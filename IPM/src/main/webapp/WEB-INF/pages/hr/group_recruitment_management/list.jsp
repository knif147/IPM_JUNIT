<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<section class="content-header">
	<h1>
		Recruitment group management <small>Show information</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="<c:url value="/hr/cruitment" />"> <i
				class="fa fa-home"></i> Home
		</a></li>
		<li class="active">Recruitment management</li>
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
	<a href="<c:url value="/hr/recruitment/group/add" />"
		class="btn btn-flat btn-primary btn-add"> <i class="fa fa-plus"></i>
		Add Group
	</a>
	<div class="row">
		<div class="col-md-12">
			<c:url var="firstUrl" value="/hr/recruitment/group" />
			<c:url var="lastUrl"
				value="/hr/recruitment/group?page=${page.totalPages}" />
			<c:url var="prevUrl"
				value="/hr/recruitment/group?page=${currentIndex - 1}" />
			<c:url var="nextUrl"
				value="/hr/recruitment/group?page=${currentIndex + 1}" />

			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Recruitment Group List</h3>
					<div class="box-tools">
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
								<c:url var="pageUrl" value="/hr/recruitment/group?page=${i}" />
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
				<div class="box-body">
					<div class="row">
						<c:forEach items="${groupRecruitments}" var="groupRecruitment">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-green">
									<div class="inner">
										<h3><c:out value="${fn:length(groupRecruitment.recruitments)}" /></h3>
										<h3>${groupRecruitment.name}</h3>
										<p>
											<c:url var="linkUpdate" value="/hr/recruitment/group/${groupRecruitment.id}/update"/>
											<a href="${linkUpdate}" style="color: #FFF">Information Technolory</a>
										</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<c:url var="action" value="/hr/recruitment/group/${groupRecruitment.id}"/>
									<a href="${action}" class="small-box-footer"> More info <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:forEach>
						<!-- ./col -->
					</div>
				</div>
				<div class="box-footer clearfix"></div>
			</div>
		</div>
	</div>
</section>