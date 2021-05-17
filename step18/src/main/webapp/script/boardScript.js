function checkWrite() {
	//alert("함수진입 테스트");
	var frm = document.writeForm;
	
	if(!frm.subject.value){
		alert("제목을 입력하세요.");
		frm.subject.focus();
	} else if(!frm.content.value) {
		alert("내용을 입력하세요.");
		frm.content.focus();
	} else {
		frm.submit();
	}
}