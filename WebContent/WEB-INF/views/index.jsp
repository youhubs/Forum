<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to ForumStack !</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/3.2.89/css/materialdesignicons.min.css">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  </head>
  <body>
<%@ include file="header.jsp" %>
    <section class="hero is-primary">
        <div class="hero-body">
            <div class="container hero-forum has-text-centered">
                <h1 class="title">
                  Forum Stack
                </h1>
                <h2 class="subtitle">
                  all tech addicts can ask here :)
                </h2>
                <div class="field is-grouped">
                    <p class="control is-expanded">
                        <input class="input is-medium" type="text" placeholder="Find a great content">
                    </p>
                    <p class="control">
                        <a class="button is-medium is-info">
                      Search
                    </a>
                    </p>
                </div>
            </div>
        </div>
    </section>
    <br/>
    <div class="container">
        <div class="columns">
            <div class="column is-three-quarters">
                <div class="tabs forum">
                    <ul>
                        <li class="is-active"><a>All</a></li>
                        <li><a>Open</a></li>
                        <li><a>Solved</a></li>
                        <li><a>Popular</a></li>
                    </ul>
                </div>
                <div class="box forum">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image avatar is-64x64">
                                <img src="<c:url value="/resources/img/1.png" />" alt="image" class="is-rounded">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content list-forum">
                                <div class="is-pulled-right has-text-centered ">
                                    <a href="#" class="love">
                                        <span>
                                    <i class="mdi mdi-heart-outline"></i>   
                                  </span>
                                    </a>
                                    <span>15</span>
                                </div>
                                <p class="text-content">
                                    <a href="#">How to make great application with nuxtjs
                                <span class="solved" title="Solved">
                                  <i class="mdi mdi-checkbox-marked-circle"></i>
                                </span>
                              </a>
                                </p>
                                <p class="tags-content">
                                    <a class="tag is-rounded is-primary">NuxtJS</a>
                                    <a class="tag is-rounded is-success">VueJS</a>
                                    <a class="tag is-rounded is-warning">JavaScript</a>
                                </p>
                                <p class="info-content">
                                    <a>
                                        <i class="mdi mdi-eye-outline"></i>
                                        <small>100k</small>
                                    </a>
                                    <a>
                                        <i class="mdi mdi-comment-text-multiple-outline"></i>
                                        <small>70</small>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </article>
                    <c:forEach items="${posts}" var="post" varStatus="status">
                    <article class="media">
                        <div class="media-left">
                            <figure class="image avatar is-64x64">
                                <img src="<c:url value="/resources/img/2.png" />" alt="image" class="is-rounded">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content list-forum">
                                <div class="is-pulled-right has-text-centered ">
                                    <a href="#" class="love active">
                                        <span><i class="mdi mdi-heart"></i></span>
                                    </a>
                                    <span>12</span>
                                </div>
                                <p class="text-content">
                                    <a href="#">${post.title}</a>
                                </p>
                                <p class="tags-content">
                                    <a class="tag is-rounded is-primary">SPA</a>
                                    <a class="tag is-rounded is-grey">JWT</a>
                                    <a class="tag is-rounded is-link">FrontEnd</a>
                                </p>
                                <p class="info-content">
                                    <a>
                                        <i class="mdi mdi-eye-outline"></i>
                                        <small>30k</small>
                                    </a>
                                    <a>
                                        <i class="mdi mdi-comment-text-multiple-outline"></i>
                                        <small>12</small>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </article></c:forEach>
                </div>
                <div class="box">
                    <nav class="pagination is-rounded" role="navigation" aria-label="pagination">
                        <a class="pagination-previous">Previous</a>
                        <a class="pagination-next">Next page</a>
                        <ul class="pagination-list">
                            <li><a class="pagination-link" aria-label="Goto page 1">1</a></li>
                            <li><span class="pagination-ellipsis">&hellip;</span></li>
                            <li><a class="pagination-link" aria-label="Goto page 45">45</a></li>
                            <li><a class="pagination-link is-current" aria-label="Page 46" aria-current="page">46</a></li>
                            <li><a class="pagination-link" aria-label="Goto page 47">47</a></li>
                            <li><span class="pagination-ellipsis">&hellip;</span></li>
                            <li><a class="pagination-link" aria-label="Goto page 86">86</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="column">
                <div class="box">
                    <h5 class="title is-5"># POPULAR TAGS</h5>
                    <div class="tags">
                        <a class="tag is-rounded is-medium  is-primary">HTML</a>
                        <a class="tag is-rounded is-medium is-success">VueJS</a>
                        <a class="tag is-rounded is-medium is-warning">JavaScript</a>
                        <a class="tag is-rounded is-medium is-danger">Angular</a>
                        <a class="tag is-rounded is-medium is-link">React</a>
                        <a class="tag is-rounded is-medium  is-success">NodeJS</a>
                        <a class="tag is-rounded is-medium is-info">PHP</a>
                        <a class="tag is-rounded is-medium is-success">CSS</a>
                        <a class="tag is-rounded is-medium is-dark">DevOps</a>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>
    </div>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</body>
</html>
