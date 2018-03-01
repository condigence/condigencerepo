function callAjax(url, container, callType) {
	$.ajax({
		url : url,
		type : callType,
		crossDomain : true,
		timeout : 50000,
		success : function(response) {
			console.log("SUCCESS: ", response);
			$('.' + container).html(response);
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", error);
		}
	});
}




function callAjaxPostJSON(urlMapping, callType, container, data) {
	$.ajax({
		type : callType,
		contentType : "application/json; charset=utf-8",
		url : urlMapping,
		data : JSON.stringify(data),
		crossDomain : true,
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("SUCCESS: ", data);
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", error);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function getJSON(serviceurl) {
	$.ajax({
		url : serviceurl,
		type : "GET",
		crossDomain : true,
		timeout : 50000,
		success : function(response) {
			console.log("SUCCESS: ", response);
			jsonData = response;
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", error);
		}
	});
}


//////////////////////////////////////////////
//////////////////////////////////////////////

// Using promise

/*function test() {
	return $.getJSON('/vishtest');
}*/

/*$.when(test()).then(function(data) {
	console.log(data);
});
*/
/*function test(callback) {
	$.getJSON('/vishtest', function(data) {
		callback(data);
	});
}*/

//Using Callback

/*test(function(data) {
	console.log(data);
});
*/