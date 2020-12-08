<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Aesthetic by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>New Folder &mdash; Free Website Template, Free HTML5
	Template by GetTemplates.co</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by GetTemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="GetTemplates.co" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Bootstrap DateTimePicker -->
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">



<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>

<style>
/* 넣으니까 사라짐 왜? */
.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #fcbe61;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}

.filebox input[type="file"] { /* 파일 필드 숨기기 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

/* imaged preview */
.filebox .upload-display {
	/* 이미지가 표시될 지역 */
	margin-bottom: 5px;
}

@media ( min-width : 768px) {
	.filebox .upload-display {
		display: inline-block;
		margin-right: 5px;
		margin-bottom: 0;
	}
}

.filebox .upload-thumb-wrap {
	/* 추가될 이미지를 감싸는 요소 */
	display: inline-block;
	width: 54px;
	padding: 2px;
	vertical-align: middle;
	border: 1px solid #ddd;
	border-radius: 5px;
	background-color: #fff;
}

.filebox .upload-display img {
	/* 추가될 이미지 */
	display: block;
	max-width: 100%;
	width: 100% \9;
	height: auto;
}

.Canclebutton:hover {
	color: black;
}
</style>

<body>

	<div class="gtco-loader"></div>

	<div id="page">


		<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="Main.jsp">New Folder <em>.</em></a>
						</div>
					</div>
					<div class="col-xs-8 text-right menu-1">
						<ul>
							<li class="has-dropdown"><a href="GetFoodsInfo">Contents</a>
								<ul class="dropdown">
									<li><a href="GetFoodsInfo">VS Game</a></li>
									<li><a href="RandomRecommendControll">Recommend</a></li>
								</ul></li>
							<li class="has-dropdown"><a
								href="FoodsInfoControll?foodeCode=01">Foods</a>
								<ul class="dropdown">
									<li><a href="FoodsInfoControll?foodeCode=01">Korean
											Foods</a></li>
									<li><a href="FoodsInfoControll?foodeCode=02">Western
											Foods</a></li>
									<li><a href="FoodsInfoControll?foodeCode=03">Chinese
											Foods</a></li>
									<li><a href="FoodsInfoControll?foodeCode=04">Asian
											Foods</a></li>
									<li><a href="FoodsInfoControll?foodeCode=05">Fast
											Foods</a></li>
									<li><a href="FoodsInfoControll?foodeCode=06">Coffee&Dessert</a></li>
								</ul></li>
							<!-- <li><a href="foods.html">Foods</a></li> -->
							<li><a href="GetCouponInfo">Event</a></li>
							<li><a href="pagingControll">Community</a></li>

							<c:if test="${level >1}">
								<li class="has-dropdown"><a>Management</a>
									<ul class="dropdown">
										<c:if test="${level eq 2}">
											<li><a href="RegStore.jsp">Registration</a></li>
										</c:if>
										<c:if test="${level >2}">
											<li><a href="AdminPage.jsp">Launching</a></li>
											<li><a href="#">Decision</a></li>
										</c:if>
									</ul></li>
							</c:if>

							<li class="btn-cta"><a href="logOutControll"><span>logOut</span></a></li>

						</ul>
					</div>
				</div>

			</div>
		</nav>
		<header id="gtco-header" class="gtco-cover gtco-cover-sm"
			role="banner"
			style="background-image: url(images/img_bg_3.jpg); text-align: center; height: 47vw;">
			<div class="overlay"></div>
			<div class="gtco-container" style="">
				<div class="row" style="text-align: center; height: 20vw;">
					<div class="col-md-12 col-md-offset-0 text-center">



						<div class="row row-mt-15em"
							style="text-align: center; justify-content: center;">

							<table style="margin: auto;">
								<colgroup>
									<col width="10%" />
									<col width="35%" />
									<col width="15%" />
									<col width="20%" />
									<col width="10%" />
									<col width="10%" />
								</colgroup>
								<tr style="font-size: 2.5rem;" class="cursive-font">
									<td style="color: #fff;">Num</td>
									<td style="color: #fff;">Title</td>
									<td style="color: #fff;">Writer</td>
									<td style="color: #fff;">Date</td>
									<td style="color: #fff;">Popular</td>
									<c:if test="${level eq '3'}">
										<td>Delete</td>
									</c:if>
								</tr>
								<c:forEach items="${top3}" var="board">

									<tr>
										<td><span style="font-weight: bold; font-size: 20px">${board.getNum()}</span>
										</td>
										<td><a
											href="oneCommunityView?Num=${board.getNum()}&page=${paging.getPage()}"
											style="text-decoration: none;"> <span
												style="font-weight: bold; font-size: 20px">${board.getTitle()}
											</span>
										</a></td>
										<td><span style="font-weight: bold; font-size: 20px">${board.getWriter()}
										</span></td>
										<td><span style="font-weight: bold; font-size: 20px">${board.getDate()}
										</span></td>
										<td><span style="font-weight: bold; font-size: 20px">${board.getThumbs()}
										</span></td>
										<c:if test="${level eq '3'}">
											<td><span style="font-weight: bold; font-size: 20px"><a
													href="communityDel?Num=${board.getNum()}"
													style="text-decoration: none;">삭제 </a> </span></td>
										</c:if>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="6">
										<hr>
									</td>
								</tr>
								<c:forEach items="${boardList}" var="board">
									<tr>
										<td>${board.getNum()}</td>
										<td><a
											href="oneCommunityView?Num=${board.getNum()}&page=${paging.getPage()}"
											style="text-decoration: none;"> ${board.getTitle()}</a></td>
										<td>${board.getWriter()}</td>
										<td>${board.getDate()}</td>
										<td>${board.getThumbs()}</td>
										<c:if test="${level eq '3'}">
											<td><a href="communityDel?Num=${board.getNum()}"
												style="text-decoration: none;">삭제</a></td>
										</c:if>
									</tr>
								</c:forEach>
							</table>
							<c:if test="${paging.page<=1}">
								<a> 이전</a>
							</c:if>

							<!-- 현재 페이지가 1페이지 보다 클 경우 -->
							<c:if test="${paging.page>1}">
								<a href="pagingControll?page=${paging.page-1}">이전</a>&nbsp;
							</c:if>

							<!-- 현재 페이지 표시 -->
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
								var="i" step="1">
								<c:choose>

									<c:when test="${i eq paging.page}">
										<strong style="font-size: 18px;"> ${i}</strong>
									</c:when>


									<c:otherwise>
										<a href="pagingControll?page=${i}"
											style="text-decoration: none;" id="aa">${i}</a>

									</c:otherwise>

								</c:choose>

							</c:forEach>

							<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
							<c:if test="${paging.page >= paging.maxPage}">&nbsp; <a>
									다음</a>
							</c:if>

							<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
							<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="pagingControll?page=${paging.page+1}" id="a">다음</a>
							</c:if>
							<div class="col-md-12 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<!-- <span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span> -->


							</div>

						</div>

					</div>
				</div>
			</div>
		</header>



		<div class="gtco-section">
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6 animate-box">
							<h3>Conversation</h3>
							<h4 style="opacity: 0.4; color: orange;">Writer :
								${nickname}</h4>

							<form action="communityWrite" method="post"
								enctype="multipart/form-data">

								<div class="row form-group">
									<div class="col-md-12">
										<label class="sr-only" for="email">Title</label> <input
											type="text" id="email" class="form-control"
											placeholder="Title" name="title">
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12">
										<label class="sr-only" for="message">Conversation</label>
										<textarea style="resize: none" name="content" id="message"
											cols="30" rows="10" class="form-control"
											placeholder="I wanna say"></textarea>
									</div>
								</div>
								<!-- 파일 선택 부분 -->
								<div class="filebox preview-image">
									<label for="input-file">UPLOAD</label>
									<!-- <input class="upload-name" value="파일선택" disabled="disabled"> -->
									<input type="file" id="input-file" class="upload-hidden"
										name="filename">
									<p>
										<span id="wannaFilename"></span>
									</p>
								</div>

								<div class="form-group" style="float: left;">
									<input type="submit" value="Done" class="btn btn-primary">
								</div>
								<div class="form-group" style="float: left;">
									<!-- <input type="button" value="Cancel" class="btn btn-primary" onclick="history.back(-1)"> -->
									<a href="#" onclick="history.back(-1)"><input type="button"
										value="Cancel" class="btn btn-primary"></a>

								</div>
							</form>
						</div>
						<div class="col-md-5 col-md-push-1 animate-box">

							<div style="width: 400px; height: 350px;">
								<a href="${food.foFileName}" class="fh5co-card-item image-popup">
									<figure>
										<div class="overlay"></div>
										<img src="${food.foFileName}" alt="Image"
											class="img-responsive">
									</figure>
									<div class="fh5co-text">
										<h2>${food.foName}</h2>
										<p>${food.foComment}</p>
										<p>
											<span class="price cursive-font">Do you like it?</span>
										</p>
									</div>
								</a>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>

		<footer id="gtco-footer" role="contentinfo"
			style="background-image: url(images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row row-pb-md">




					<div class="col-md-12 text-center">
						<div class="gtco-widget">
							<h3>Get In Touch</h3>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> 010 2190
										4168</a></li>
								<li><a href="#"><i class="icon-mail2"></i>kdh4168@naver.com</a></li>
								<li><a href="#"><i class="icon-chat"></i><span
										id="kakaoID1">Kakako</span></a></li>

							</ul>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> 010 3740
										6894</a></li>
								<li><a href="#"><i class="icon-mail2"></i>
										moonsj6894@naver.com</a></li>
								<li><a href="#"><i class="icon-chat"></i><span
										id="kakaoID2">Kakako</span></a></li>

							</ul>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> 010 6615 0501</a></li>
								<li><a href="#"><i class="icon-mail2"></i>
										spqjeks@naver.com</a></li>
								<li><a href="#"><i class="icon-chat"></i><span
										id="kakaoID3">Kakako</span></a></li>

							</ul>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> 010 9525 1639</a></li>
								<li><a href="#"><i class="icon-mail2"></i>
										gmlans9525@naver.com</a></li>
								<li><a href="#"><i class="icon-chat"></i><span
										id="kakaoID4">Kakako</span></a></li>
								<script>
								var kakaoid1 = document.getElementById("kakaoID1")
								kakaoid1.addEventListener("mouseover",()=>{kakaoid1.innerHTML="강동훈"});
								kakaoid1.addEventListener("mouseout",()=>{kakaoid1.innerHTML="Kakako"});
								
								var kakaoid2 = document.getElementById("kakaoID2")
								kakaoid2.addEventListener("mouseover",()=>{kakaoid2.innerHTML="문상진"});
								kakaoid2.addEventListener("mouseout",()=>{kakaoid2.innerHTML="Kakako"});
								
								var kakaoid3 = document.getElementById("kakaoID3")
								kakaoid3.addEventListener("mouseover",()=>{kakaoid3.innerHTML="유상민"});
								kakaoid3.addEventListener("mouseout",()=>{kakaoid3.innerHTML="Kakako"});
								
								var kakaoid4 = document.getElementById("kakaoID4")
								kakaoid4.addEventListener("mouseover",()=>{kakaoid4.innerHTML="조 단"});
								kakaoid4.addEventListener("mouseout",()=>{kakaoid4.innerHTML="Kakako"});
								</script>
							</ul>
						</div>
						<div class="gtco-widget">
							<h3>Get Social</h3>
							<ul class="gtco-social-icons">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>

							</ul>
						</div>
					</div>

					<div class="col-md-12 text-center copyright">
						Made by <i class="fa fa-love"></i><a
							href="https://bootstrapthemes.co">New Folder</a>
					</div>

				</div>



			</div>
		</footer>
		<!-- </div> -->

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>

	<script src="js/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="js/main.js"></script>
	<script>
		var imgTarget = $('.preview-image .upload-hidden');
		imgTarget
				.on(
						'change',
						function() {

							var parent = $(this).parent();
							var fileValue = $("#input-file").val().split("\\");
							var fileName = fileValue[fileValue.length - 1];
							document.getElementById("wannaFilename").innerHTML = fileName;

							parent.children('.upload-display').remove();
							if (window.FileReader) {
								//image 파일만 
								if (!$(this)[0].files[0].type.match(/image\//)) {
									alert("이미지 파일만 올려주세요");
									return;
								}
								var reader = new FileReader();
								reader.onload = function(e) {
									var src = e.target.result;
									parent
											.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="' + src + '" class="upload-thumb"></div></div>');
								}
								reader.readAsDataURL($(this)[0].files[0]);
							} else {
								$(this)[0].select();
								$(this)[0].blur();
								var imgSrc = document.selection.createRange().text;
								parent
										.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');
								var img = $(this).siblings('.upload-display')
										.find('img');
								img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""
										+ imgSrc + "\")";
							}

						});
	</script>

</body>
</html>

