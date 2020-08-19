<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="main w clearfix">
		<div class="main-left">
			<div class="share">
				<div class="share-left"><span></span>&nbsp;Sharing and Asking</div>
				<div class="share-right">
					<a href="toPublish.do"><span class="glyphicon glyphicon-pencil"></span>&nbsp;New Post</a>
				</div>
			</div>
			<div class="post">
				<div class="post-wrap">
					<div class="post-choice">
						<a href="#" class="post-choice-current">Newest</a>
						<a href="#">Active</a>
						<a href="#" class="post-choice-last">Most Reviewed</a>
					</div>

					<ul class="post-list">
						<c:forEach items="${pageIndex.list}" var="post">
                            <li class="clearfix">
                                <div class="post-image">
                                    <a href="toProfile.do?uid=${post.id}"><img src="${post.id}"></a>
                                </div>
                                <div class="post-content">
                                    <div class="post-title"><a href="toPost.do?pid=${post.pid}">${post.title}</a></div>
                                    <div class="post-other">
                                        <div class="post-other-left">
                                            <span class="post-username"><a href="toProfile.do?uid=${post.content}">${post.content}</a></span>
                                            <span>&nbsp;posted:</span>
                                            <span class="post-time">&nbsp;${post.pdate}</span>
                                            <span>&nbsp;last reply:&nbsp;</span>
                                            <span class="post-reply-time">${post.pdate}</span>
                                        </div>
                                        <div class="post-other-right">
                                            <span class="post-reply-count">Replies ${post.rootId}</span>&nbsp;
                                            <span class="post-like-count">Likes ${post.rootId}</span>&nbsp;
                                            <span class="post-scan-count">reviews ${post.rootId}</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
					</ul>

<%@ include file="page_index.jsp" %>

				</div>
			</div>
		</div>
		
		<div class="main-right">			
			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;Active Users</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${users}" var="user">
						<li class="clearfix">
						    <a href="toProfile.do?uid=${user.id}" class="hot-user-image">${user.memberDate }</a>&nbsp;&nbsp;
						    <a href="toProfile.do?uid=${user.id}" class="hot-user-name">${user.username}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;Recent Registers</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${userList}" var="user">
						<li class="clearfix">
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-image"><img src="${user.headUrl}"></a>
							<a href="toProfile.do?uid=${user.uid}" class="hot-user-name">${user.username}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

		</div>
	</div>

<%@ include file="footer.jsp" %>

<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/base.js" />"></script>
<script type="text/javascript">
    $(function(){
        var curPage = ${pageBean.curPage};
        $(".pageNum").each(function(){
            if($(this).text()==curPage){
                $(this).addClass("active");
            }
        });
    });
</script>
</body>
</html>
