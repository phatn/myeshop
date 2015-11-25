<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="sideBar">
<c:forEach items="${categories}" var="category">
	<li <c:if test="${not empty category.categories}">class="hasChild"</c:if>>
		<a href="<c:url value="/product/list/"/>${category.description.sefUrl}">${category.description.name}</a>
	<c:if test="${not empty category.categories }">
		<ul class="subNav">
		<c:forEach items="${category.categories}" var="level1Cat">
			<li><a href="<c:url value="/product/list/"/>${level1Cat.description.sefUrl}">${level1Cat.description.name}</a>
				<c:if test="${not empty level1Cat.categories }">
					<ul>
					<c:forEach items="${level1Cat.categories}" var="level2Cat">
						<li><a href="<c:url value="/product/list/"/>${level2Cat.description.sefUrl}">${level2Cat.description.name}</a></li>
					</c:forEach>
					</ul>
				</c:if>
				<div style="height: 10px;"></div>
			</li>
		</c:forEach>
		</ul>
	</c:if>
	</li>
</c:forEach>
</ul>
