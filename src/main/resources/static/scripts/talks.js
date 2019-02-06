function setMessage(text, type) {
	$('.alert').show();
	$(".alert").text(text).css('font-weight', 'bold');
	$('.alert').removeClass(
		'alert-primary alert-danger alert-success alert-warning');
	$('.alert').addClass('alert-' + type);
	$(".alert").alert();
}

function addButton(tag) {
	var topic = $('<button type="button" class="btn btn-success">' + tag.name + '</button>');
	$("#topics").append(topic);
	$("#topic").val("");
}
function getTalk(){
	var title = $("#title").val();
	var description = $("#description").val();
	var topics = []; 
	$("#selectedTopics .btn-success").each (function() {
		var tag = {
			id : this.id,
			name : this.value
		}
		topics.push(tag);
	});
	var proposedTalk = {
		title : title,
		description : description,
		tags : topics
	}
	return proposedTalk;
}
$(document).on("click", "#selectedTopics .btn-primary, .btn-success", function (e) {
	$(e.target).toggleClass("btn-primary btn-success");
});
$(document).on("click", "#submit-topic", function (e) {
	e.stopPropagation();
	var topic = $("#topic").val();
	var url = "/tags/add?topic=" + topic;
	$.ajax({
		url: url,
		type: 'POST',
		error: function (request, status, error) {
			setMessage(request.responseJSON.message, "danger");
		},
		success: function (data) {
			addButton(data);
		}
	});
});

$(document).on("click", "#summit-talk", function (e) {
	e.stopPropagation();
	var proposedTalk = getTalk();
	var url = "/proposedtalks/add"
	$.ajax({
		url: url,
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		data: JSON.stringify(proposedTalk),
		type: 'POST',
		error: function (request, status, error) {
			setMessage(request.responseJSON.message, "danger");
		},
		success: function (data) {
			debbuger;
			console.log(data);
		}
	});
});