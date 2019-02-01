

function setMessage(text, type) {
    $('.alert').show();
	$(".alert").text(text).css('font-weight', 'bold');
	$('.alert').removeClass(
			'alert-primary alert-danger alert-success alert-warning');
	$('.alert').addClass('alert-' + type);
	$(".alert").alert();
}

function addButton(tag){
    var topic = $('<button type="button" class="btn btn-success">' + tag.name + '</button>');
    $("#topics").append(topic);
    $("#topic").val("");
}


$(document).on("click", "#submit-topic", function(e) {
    e.stopPropagation();
	var topic = $("#topic").val();
	var url = "/tags/add?topic=" + topic;
	$.ajax({
		url : url,
		type : 'POST',
		error : function(request, status, error) {
			setMessage(request.responseJSON.message, "danger");
		},
		success : function(data) {
			addButton(data);
		}
	});
});