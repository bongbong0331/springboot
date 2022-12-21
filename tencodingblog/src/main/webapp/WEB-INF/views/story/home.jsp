<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


			<form class="form-inline" action="/story/home" method="get" >
				<input class="form-control mr-1" type="text" placeholder="검색어를 입력하이소" name="q" value="${q }">
				<button class="btn btn-warning " type="submit">TITLE</button>
			</form>


<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Story in Life</h1>
			<p class="lead fw-normal text-white-50 mb-0">당신의 스토리를 알려주세요</p>
		</div>
	</div>
</header>


<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">

		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">



			<c:forEach var="image" items="${imagePage.content }">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top" src="http://localhost:9090/upload/${image.postImageUrl }" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${image.storyText }</h5>
								<!-- Product reviews-->
								<div class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>


							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">상세보기</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>



		<ul class="pagination justify-content-center">
			<c:set var="isDisabled" value="disabled"></c:set>
			<c:set var="isNotDisabled" value=""></c:set>
			<li class="page-item ${imagePage.first ? isDisabled : isNotDisabled } ">
			<a class="page-link" href="?page=${imagePage.number - 1 }">Previous</a></li>
			<!-- 반복문 처리 하기-->
			<!-- 1 2 3, 1 2 3 4 , 1 2 3 4 5  -->
			<c:forEach var="num" items="${iPageNumbers}">
				<c:choose>
					<c:when test="${nowiPage eq num}">
						<li class="page-item active">
						<a class="page-link" href="?page=${num -1}">${num}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
						<a class="page-link" href="?page=${num -1 }">${num}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
				<li class="page-item ${imagePage.last ? isDisabled : isNotDisabled }">
				<a class="page-link" href="?page=${imagePage.number + 1 }">Next</a></li>
		</ul>

	</div>
</section>











<%@ include file="../layout/footer.jsp"%>



