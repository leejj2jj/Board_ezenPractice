<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
	function fn_go_list() {
		let keyword = document.getElementById("keyword").value;

		location.href = "/list" + '${pageMaker.makeQuery(1)}' + '&searchType=tcw&keyword=' + keyword;
	}
</script>

<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Fixed navbar</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="/list">Posts</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="keyword" id="keyword" value="${cri.keyword}">
					<button class="btn btn-outline-success" type="button" onclick="fn_go_list()">Search</button>
				</form>
			</div>
		</div>
	</nav>
</header>