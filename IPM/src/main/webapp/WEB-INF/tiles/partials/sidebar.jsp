<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<section class="sidebar">
	<sec:authentication var="principal" property="principal" />
	<c:set var="user" value="${principal.getUser()}" />
	
	<!-- Sidebar user panel -->
	<div class="user-panel">
		<div class="pull-left image">
			<img src="<c:url value='/static/images/avatar.png' />"
				class="img-circle" alt="User Image">
		</div>
		<div class="pull-left info">
			<p>${user.fullName}</p>
			<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		</div>
	</div>
	<form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>

	<!-- sidebar menu: : style can be found in sidebar.less -->
	<ul class="sidebar-menu">
		<li class="header"> MAIN NAVIGATION</li>
		
		<sec:authorize access="hasRole('ROLE_1')">
			<!-- Admin Begin-->
			<li class="treeview">
				<a href="<c:url value='/admin/hr' />"> 
					<i class="fa fa-users"></i> <span>HR Management</span>
				</a>
			</li>
			<li class="treeview">
				<a href="<c:url value='/admin/interviewer' />"> 
					<i class="fa fa-users"></i> <span>Interviewer Management</span>
				</a>
			</li>
			<li class="treeview">
				<a href="<c:url value='/admin/info' />"> 
					<i class="fa fa-cog"></i> <span>Profile</span>
				</a>
			</li>
			<!-- Admin End -->
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_2')">
			<!-- HR Begin -->
			<li class="treeview">
				<a href="<c:url value='/hr/recruitment/group' />"> 
					<i class="fa fa-calendar-minus-o"></i> <span>Recruitment Management</span>
				</a>
			</li>
			
			<li class="treeview">
				<a href="<c:url value='/hr/major' />"> 
					<i class="fa fa-industry"></i> <span>Major Management</span>
				</a>
			</li>
			
			<li class="treeview">
				<a href="<c:url value='/hr/position' />"> 
					<i class="fa fa-life-ring"></i> <span>Position Management</span>
				</a>
			</li>
			
			<li class="treeview">
				<a href="<c:url value='/hr/candidate' />"> 
					<i class="fa fa-users"></i> <span>Candidate Management</span>
				</a>
			</li>
			
			<li class="treeview">
				<a href="<c:url value='/hr/info' />"> 
					<i class="fa fa-cog"></i> <span>Profile</span>
				</a>
			</li>
			
			<!-- HR End -->
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_3')">
			<!-- Interviewer Begin -->
		
			<!-- Interviewer End -->
		</sec:authorize>
		
	</ul>
</section>