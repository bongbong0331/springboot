<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!--  -->
<!-- multipart/form-data 기억하기 -->
<div class="container">

	<form action="/story/image/upload" enctype="multipart/form-data" class="m-5" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<div class="custom-file">
			<input type="file" name="file" class="custom-file-input" id="customFile" required="required"> 
			<label class="custom-file-label" for="customFile">파일을 선택하라</label>

			<div class="input-group mt-3">
				<div class="input-group-prepend">
					<span class="input-group-text">스토리 설명</span>
				</div>
				<input type="text" class="form-control" name="storyText">
				<div class="input-group mt-3">
					<button type="submit" class="btn btn-info">사진 업로드</button>
				</div>
			</div>




		</div>
	</form>

</div>

<br>
<br>



<script>
	$(".custom-file-input").on("change",function() {
		
				console.log("test code : " + $(this).val());
				
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>











<%@ include file="../layout/footer.jsp"%>




