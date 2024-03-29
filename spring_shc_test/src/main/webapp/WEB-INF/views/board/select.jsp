<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/b1e3c8f87d.js" crossorigin="anonymous"></script>
<style>
.btn-up, .btn-down{
	border : 1px solid black; color: red
}
.btn-up.red, .btn-down.red{
	background : red; color : white
}
</style>
</head>
<body>
	<div class="container">
		<c:if test="${board.bd_del == 'N' }">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <label for="">제목:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_title }">
			</div>
			<div class="form-group">
			  <label for="">작성자:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
			  <label for="">작성일:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_reg_date_time_str }">
			</div>
			<div class="form-group">
			  <label for="">최종수정일:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_up_date_time_str}">
			</div>
			<div class="form-group">
			  <label for="">조회수:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_views}">
			</div>
			<c:if test="${likes.li_state == 1}">red</c:if>
			<div class="form-group">
				<button class="btn btn-up <c:if test="${likes.li_state == 1}">red</c:if>" data-value="1"><i class="fa-solid fa-thumbs-up"></i></button>
				<button class="btn btn-down <c:if test="${likes.li_state == -1}">red</c:if>" data-value="-1"><i class="fa-solid fa-thumbs-down"></i></button>
			</div>
			<div class="form-group">
			  <label for="">내용:</label>
			  <div class="form-control" style="height:auto; min-height:400px">${board.bd_content}</div>
			</div>
			<div class="form-group">
			  <label for="">첨부파일</label>
			  <c:forEach items="${fileList}" var="fi">
				  <a href="<c:url value="/file${fi.fi_name }"></c:url>" class="form-control" download="${fi.fi_ori_name}">${fi.fi_ori_name }</a>
			  </c:forEach>
		  </div>
		  
		  <c:if test="${board.bd_me_id == user.me_id }">
				<a href="<c:url value="/board/update/${board.bd_num}"></c:url>" class="btn btn-outline-success">수정</a>
				<a href="<c:url value="/board/delete/${board.bd_num}"></c:url>" class="btn btn-outline-success">삭제</a>
			</c:if>
			<a href="<c:url value="/board/insert?bd_ori_num=${board.bd_ori_num}&bd_depth=${board.bd_depth}&bd_order=${board.bd_order}"></c:url>" class="btn btn-outline-success">답글</a>
			<hr>
			<div class="list-comment">
				<div class="media border p-3">
			    <div class="media-body">
			      <h4>John Doe <small><i>February 19, 2016</i></small></h4>
			      <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
			      <div class="form-group">      
			      	<textarea class="form-control" rows="" cols=""></textarea>
			      </div>
			    </div>
			    <button class="btn btn-outline-danger" style="display: block">답글</button>
			    <div class="btn-box">
			    	<button class="btn btn-outline-danger" style="display: block">수정</button>
			    	<button class="btn btn-outline-success  mt-1" style="display: block">삭제</button>
			    </div>
			  </div>
			</div>
			<ul class="pagination-comment pagination justify-content-center mt-3">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
		  </ul>
			<div>
				<div class="form-group">
				  <textarea class="form-control" rows="5" name="co_content"></textarea>
				</div>
				<button class="btn btn-outline-success col-12 btn-co-insert">댓글 등록</button>
			</div>
		</c:if>
		<c:if test="${board.bd_del =='Y' }">
			<h1>작성자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board.bd_del =='A' }">
			<h1>관리자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
	</div>
	<script type="text/javascript">
		$(function(){
			$('.btn-up, .btn-down').click(function(){
				let id = '${user.me_id}';
				if(id == ''){
					if(confirm('로그인이 필요한 기능입니다. 로그인을 하러 이동하겠습니까?')){
						location.href = '<%=request.getContextPath()%>/login'
						return;
					}
				}
				
				let li_state = $(this).data('value');
				let li_bd_num = '${board.bd_num}'
				let obj ={
						li_state : li_state,
						li_bd_num: li_bd_num
				}
				$.ajax({
		      async:false,
		      type:'POST',
		      data:JSON.stringify(obj),
		      url:"<%=request.getContextPath()%>/check/likes",
		      dataType:"json",
		      contentType:"application/json; charset=UTF-8",
		      success : function(data){
		    	  $('.btn-up, .btn-down').removeClass('red');
		    	  if(data.state == '1'){
		    		  $('.btn-up').addClass('red');
		    		  alert('게시글을 추천했습니다.')
		    	  }else if(data.state == '-1'){
		    		  $('.btn-down').addClass('red');
		    		  alert('게시글을 비추천했습니다.')
		    	  }else if(data.state == '10'){
		    		  alert('게시글을 추천을 취소했습니다.')
		    	  }else if(data.state == '-10'){
		    		  alert('게시글을 비추천을 취소했습니다.')
		    	  }else{
		    		  alert('잘못된 접근입니다.')
		    	  }
		    	  
		      }
			  });
			});
		})
		//댓글
		$(function(){
			$('.btn-co-insert').click(function(){
				let co_me_id = '${user.me_id}';
				//아이디 체크
				if(co_me_id == ''){
					//로그인 화면으로 이동할지 물어봄
					if(confirm('로그인이 필요한 서비스입니다.\n로그인화면으로 이동하겠습니까?')){
						//로그인화면으로 이동
						location.href = '<%=request.getContextPath()%>/login'
						return;
					}else{
						return;
					}
				}
				//댓글 내용 체크
				let co_content = $('[name=co_content]').val()
				//댓글 내용이 비었으면 입력하라고 함
				if(co_content == ''){
					alert('댓글 내용을 입력하세요.');
					$('[name=co_content]').focus();
					return;
				}
				let obj = {
						co_content : co_content,
						co_bd_num : '${board.bd_num}'
				}
				
				ajaxPost(false, obj, '/ajax/comment/insert', commentInsertSuccess);
				
			})
			//댓글에 있는 답글 버튼 클릭
			$(document).on('click','.btn-co-reply',function(){
				let co_me_id = '${user.me_id}';
				//아이디 체크
				if(co_me_id == ''){
					//로그인 화면으로 이동할지 물어봄
					if(confirm('로그인이 필요한 서비스입니다.\n로그인화면으로 이동하겠습니까?')){
						//로그인화면으로 이동
						location.href = '<%=request.getContextPath()%>/login'
						return;
					}else{
						return;
					}
				}
				$('.btn-co-cancel').click();
				$('.btn-reply-cancel').click();
				str = ''
				str += '<div class="media p-3 box-reply">'
		    str +=  '<div class="media-body">'
			  str +=    '<div class="form-group">'
				str +=		  '<textarea class="form-control" rows="5" name="co_reply_content"></textarea>'
				str +=		'</div>'
		    str +=  '</div>'
		    str +=  '<div class="box-btn">'
		    str +=  	'<button class="btn btn-outline-danger btn-reply-complete" style="display: block">등록</button>'
		    str +=		'<button class="btn btn-outline-success  mt-1 btn-reply-cancel" style="display: block">취소</button>'
		    str +=  '</div>'
		    str += '</div>' 
		    $(this).parent().siblings('.media-body').append(str);
		    $(this).parent().hide();//답글,수정,삭제버튼 감춤
			})
			
			//댓글 등록 버튼 클릭
			$(document).on('click','.btn-reply-complete', function(){
				
				//댓글 내용 체크
				let co_content = $('[name=co_reply_content]').val()
				//댓글 내용이 비었으면 입력하라고 함
				if(co_content == ''){
					alert('댓글 내용을 입력하세요.');
					$('[name=co_reply_content]').focus();
					return;
				}
				let co_ori_num = $(this).parents('.comment-body').find('.btn-co-reply').data('orinum');
				let co_depth = $(this).parents('.comment-body').find('.btn-co-reply').data('depth');
				let co_order = $(this).parents('.comment-body').find('.btn-co-reply').data('order');
				let obj = {
						co_content : co_content,
						co_bd_num  : '${board.bd_num}',
						co_ori_num : co_ori_num,
						co_depth   : co_depth,
						co_order   : co_order
				}
				
				ajaxPost(false, obj, '/ajax/comment/insert', commentInsertSuccess);
			})
			//댓글 취소 버튼 클릭
			$(document).on('click','.btn-reply-cancel', function(){
				$(this).parents('.comment-body').find('.btn-box').show();//답글,수정,삭제버튼 보여줌
				$(this).parents('.box-reply').remove();//답글창, 등록, 취소 버튼을 삭제
			})
			getCommentList(cri);
		})
		
		//전역변수들
		let cri = {
				page : 1,
				perPageNum : 5
		}
		
		//함수들
		function getCommentList(cri){
			if(cri == undefined ||cri == null || typeof cri !='object'){
				cri = {};
			}
			if(isNaN(cri.page))
				cri.page = 1;
			ajaxPost(false, cri, '/ajax/comment/list/'+${board.bd_num}, commentListSuccess);
		}
		
		function commentInsertSuccess(data){
			if(data.res)
				alert('댓글 등록이 완료됐습니다.')
			else
				alert('댓글 등록에 실패했습니다.')
			getCommentList(cri);
			$('[name=co_content]').val('');
		}
		function commentDeleteSuccess(data){
			if(data.res){
				alert('댓글 삭제가 완료됐습니다.');
			}else{
				alert('댓글 삭제에 실패했습니다.');
			}
			getCommentList(cri);
		}
		function commentUpdateSuccess(data){
			if(data.res){
				alert('댓글 수정 완료됐습니다.');
			}else{
				alert('댓글 수정에 실패했습니다.');
			}
			getCommentList(cri);
		}
		function commentListSuccess(data){
			let list = data.list;
			let str = '';
			//반복문을 이용하여 댓글들 구성
			for(co of list){
				str += '<div class="media border p-3 comment-body">';
			  str +=   '<div class="media-body">';
			  str +=     '<h4>'+co.co_me_id+'<small><i> '+co.co_reg_date_str+'</i></small></h4>';
			  str +=     '<p>';
			  str +=       '<span class="reply-icon">'
			  for(let i = 2; i<=co.co_depth; i++) 
					str+=        '-'
				str +=       '</span>'
				str +=       '<span class="reply-content">'
			  str +=         co.co_content;
				str +=       '</span>'
				str +=      '</p>';      
			  str +=   '</div>';
			  str +=   '<div class="btn-box">'
			  str +=      '<button data-orinum="'+co.co_ori_num+'" data-depth="'+co.co_depth+'" data-order="'+co.co_order+'" class="btn btn-outline-danger btn-co-reply" style="display: block">답글</button>'
			  if(co.co_me_id == '${user.me_id}'){
					str +=	 	'<button data-target="'+co.co_num+'" class="btn btn-outline-danger btn-co-update" style="display: block">수정</button>';
					str +=   	'<button data-target="'+co.co_num+'" class="btn btn-outline-success btn-co-delete mt-1" style="display: block">삭제</button>';
			  }
				str +=    '</div>';
			  str += '</div>';;
			}
			//댓글들을 화면에 출력
			$('.list-comment').html(str);
			//댓글 삭제버튼 이벤트 등록
			$('.btn-co-delete').click(function(){
				let co_num = $(this).data('target');
				let comment = {
						co_num : co_num
				}
				ajaxPost(false, comment, '/ajax/comment/delete', commentDeleteSuccess)
			});
			//댓글 수정버튼 클릭 이벤트 등록
			$('.btn-co-update').click(function(){
				$('.btn-co-cancel').click();
				$('.btn-reply-cancel').click();
				let contentEl = $(this).parent().siblings('.media-body').children('p');
				contentEl.hide();
				let content = contentEl.children('.reply-content').text();
				let str = '';
				str += '<div class="form-group box-content">'      
				str +=  	'<textarea class="form-control" rows="3">'+content+'</textarea>'
				str += '</div>'
				contentEl.after(str);
				$(this).parent().hide();
				let co_num = $(this).data('target');
				str = '';
				str += '<div class="btn-box2">'
				str +=	 	'<button data-target="'+co_num+'" class="btn btn-outline-danger btn-co-complete" style="display: block">등록</button>';
				str +=   	'<button class="btn btn-outline-success btn-co-cancel mt-1" style="display: block">취소</button>';
				str += '</div>'
				$(this).parent().after(str);
				//등록버튼 클릭
				$('.btn-co-complete').click(function(){
					let co_num = $(this).data('target');
					let co_content = $(this).parent().siblings('.media-body').find('textarea').val();
					let obj = {
							co_num : co_num,
							co_content : co_content
					}
					ajaxPost(false, obj, '/ajax/comment/update', commentUpdateSuccess)
				})
				//취소버튼 클릭
				$('.btn-co-cancel').click(function(){
					$(this).parent().siblings('.media-body').find('p').show();
					$(this).parent().siblings('.media-body').find('.box-content').remove();
					$(this).parent().siblings('.btn-box').show();
					$(this).parent().remove();
				})
			})
			
			let pm = data.pm;
			let pmStr = '';
			//댓글 페이지네이션 구성
			if(pm.prev)
				pmStr +=	'<li class="page-item" data-page="'+(pm.startPage-1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>';
			for(i = pm.startPage; i<= pm.endPage; i++){
				if(i == pm.cri.page)
					pmStr +=	'<li class="page-item active" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';
				else
		    	pmStr +=	'<li class="page-item" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';
			}
			if(pm.next)
		  	pmStr += 	'<li class="page-item" data-page="'+(pm.endPage+1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>';
		  //댓글 페이지네이션 화면에 출력
		  $('.pagination-comment').html(pmStr);
		  //페이지네이션에서 페이지 이벤트 등록
		  $('.pagination-comment .page-item').click(function(){
			  cri.page = $(this).data('page');
			  getCommentList(cri);
		  })
		}
		
		
		function ajaxPost(async, dataObj, url, success){
			$.ajax({
	      async:async,
	      type:'POST',
	      data:JSON.stringify(dataObj),
	      url:"<%=request.getContextPath()%>"+url,
	      dataType:"json",
	      contentType:"application/json; charset=UTF-8",
	      success : function(data){
	    	  success(data);
	      }
		  });
		}
	</script>
</body>
</html>