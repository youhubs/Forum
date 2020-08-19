<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--Page Navigation--%>
<nav class="col-md-10 col-md-offset-2">
    <ul class="pagination pagination-sm">
        <%--First--%>
        <li><a href="listPostByTime.do?curPage=1">First</a></li>
        <%--Previous Page--%>
        <c:choose>
            <c:when test="${pageIndex.curPage!=1 }">
                <li><a href="listPostByTime.do?curPage=${pageIndex.curPage-1 }"><span>&laquo;</span></a></li>
            </c:when>
            <c:otherwise>
                <li><span>&laquo;</span></li>
            </c:otherwise>
        </c:choose>
        <%--Middle--%>
        <c:choose>
            <c:when test="${pageIndex.allPage<=4 }">
                <c:forEach begin="1" end="${ pageIndex.allPage}" var="i">
                    <li class="pageNum"><a href="listPostByTime.do?curPage=${i }">${i }</a></li>
                </c:forEach>
            </c:when>
            <c:when test="${pageIndex.curPage<=2 }">
                <c:forEach begin="1" end="4" var="i">
                    <li class="pageNum"><a href="listPostByTime.do?curPage=${i }">${i }</a></li>
                </c:forEach>
            </c:when>
            <c:when test="${pageIndex.allPage-pageIndex.curPage<2 }">
                <c:forEach begin="${pageIndex.allPage-3 }" end="${ pageIndex.allPage}" var="i">
                    <li class="pageNum"><a href="listPostByTime.do?curPage=${i }">${i }</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach begin="${pageIndex.curPage-1 }" end="${ pageIndex.curPage+2}" var="i">
                    <li class="pageNum"><a href="listPostByTime.do?curPage=${i }">${i }</a></li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <%--Next--%>
        <c:choose>
            <c:when test="${pageIndex.curPage!=pageIndex.allPage }">
                <li><a href="listPostByTime.do?curPage=${pageIndex.curPage+1 }"><span>&raquo;</span></a></li>
            </c:when>
            <c:otherwise>
                <li><span>&raquo;</span></li>
            </c:otherwise>
        </c:choose>
        <%--Last Page--%>
        <li><a href="listPostByTime.do?curPage=${pageIndex.allPage}">Last</a></li>
    </ul>
</nav>
