/* Test Data
var response = [
            {
                "id": "1",
                "NAME": "A",                 
                "AGE": "20"
            }, {
                "id": "2",
                "NAME": "B",                
                "AGE": "30"
            }
            ];
 */

response = [];


var baseUrl = "http://localhost:9900";
var getAllurl = baseUrl + "/condyn/all";

function getAllData() {
	alert('getAllData');
	createTableHeader(response[0]);
	createTableBody(response);
}

function getJSON(url) {
	$.ajax({
		url : url,
		type : "GET",
		crossDomain : true,
		crossOrigin :true,
		timeout : 50000,
		dataType : 'json',
		headers: {
             'Access-Control-Allow-Origin': '*'
         },
		success : function(result) {
			alert(JSON.stringify(result));
			response = result;
		},
		error : function(xhr, status, error) {
			alert("xhr : "+xhr +"  status: "+ status  +" error: "+  error);
		}
	});
}

url = getAllurl;
getJSON(url);
getAllData();

function createTableHeader(obj) {
	var headerdataStr = "";
	for ( var k in obj) {
		headerdataStr = headerdataStr + "<th class=''>" + k + "</th>";
	}
	headerdataStr = headerdataStr
			+ " <th width='100' style='text-align:center;'><td><a id='add-btn' class='btn btn-warning custom-width addBtn' onClick='form("
			+ 0 + ");'>Add New</a></td></th>";
	$("thead > tr").html(headerdataStr);
}

function createTableBody(response) {
	var rowDataStr = "";
	var actionId = "";
	for (i = 0; i < response.length; i++) {
		rowDataStr = rowDataStr + "<tr id='row_" + i + "'>";
		var tdStr = "";
		var jsonObj = response[i];
		for ( var key in jsonObj) {
			if (key == 'id') {
				actionId = jsonObj[key];
			}
			tdStr = tdStr + "<td id='" + key + "_" + actionId + "'>"
					+ jsonObj[key] + "</td>";
		}
		var actions = '<td><a id="edit-user-'
				+ actionId
				+ '"  onClick="form('
				+ actionId
				+ ');" class="btn btn-success custom-width editbtn">edit</a></td>'
				+ '<td><a id="delete-user-'
				+ actionId
				+ '" onClick="deleteMe('
				+ actionId
				+ ');" class="btn btn-danger custom-width delbtn">delete</a></td>';

		tdStr = tdStr + actions;
		rowDataStr = rowDataStr + tdStr;
	}
	$("tbody").html(rowDataStr);
}

function form(id) {
	$('.form-container').removeClass('hide');	
	var elemStr = "";
	var elemIdArr = [];
	var obj = response[0];
	for ( var k in obj) {
		elemIdArr.push(k);
	}
	var elemIdStr = "";
	var disableStr = '';
	var hideStr = '';
	var btnValueStr = '';
	var elemValStr = "";
	var idStr = "0";
	for (i = 0; i < elemIdArr.length; i++) {
		var key = elemIdArr[i];
		if (id == '0') {
			elemIdStr = "add_elem_" + key;
			btnValueStr = "Save";
			elemValStr = "";
			idStr = "0";
			if (key == 'id') {
				disableStr = "";
				hideStr = "hide";
			} else {
				disableStr = "";
				hideStr = "";
			}
		} else {
			elemIdStr = "edit_elem_" + key + '_' + id;
			btnValueStr = "Update";
			elemValStr = $('.data-container  tr #' + key + '_' + id).text();
			idStr = id;
			if (key == 'id') {
				disableStr = "disabled";
				hideStr = "";
			} else {
				disableStr = "";
				hideStr = "";
			}
		}

		var divStr = '<div class="form-group col-md-12  ' + hideStr + ' ">'
				+ '<label class="col-md-3 control-lable" for="' + key + '">'
				+ key + '</label>' + '<div class="col-md-7">'
				+ '<input type="text" id="' + elemIdStr
				+ '" required  maxlength="60"   value="' + elemValStr + '" '
				+ disableStr + ' class="form-control input-sm" />'
				+ '<div class="has-error">' + '<span class="help-inline" />'
				+ '</div>' + '</div>' + '</div>';
		elemStr = elemStr + divStr;

	}
	$('.form-elements').html("");
	$('.form-elements').html(elemStr);
	var actions = "<input type='submit' class='btn btn-primary btn-sm' onClick='save("
			+ idStr + ");' value='" + btnValueStr + "'/>" + " or <a style='cursor:pointer' onClick='closeForm();'>Cancel</a>";
	$('.form-actions').html("");
	$('.form-actions').html(actions);
}

function closeForm(){
	$('.form-container').addClass('hide');	
}

function deleteMe(id) {	
	var deleteUrl = baseUrl + "/condyn/delete/" + id;	
	var jsonObj = [];
	callAjax(deleteUrl, "DELETE", "", jsonObj);	
}

function save(id) {	
	var jsonObj = {};
	var actionName = "";
	var actionType = "";
	var actionEntity = "condyn";
	var elemIdArr = [];
	var obj = response[0];
	for ( var k in obj) {
		elemIdArr.push(k);
	}
	var tdStr = '';
	for (i = 0; i < elemIdArr.length; i++) {
		var key = elemIdArr[i];
		if (id != '0') {
			actionName = "update/" + id;
			actionType = "PUT";
			tdStr = 'edit_elem_' + key + '_' + id;
		} else {
			actionName = "add";
			actionType = "POST";
			tdStr = 'add_elem_' + key;
		}
		var val = $('.form-elements  #' + tdStr).val();
		jsonObj[key] = val;
	}
	var newUrl = baseUrl + "/" + actionEntity + "/" + actionName;	
	callAjax(newUrl, actionType, "", jsonObj);
}

function callAjax(urlMapping, callType, container, data) {
	$.ajax({
		type : callType,
		contentType : "application/json",
		url : urlMapping,
		data : JSON.stringify(data),
		crossDomain : true,
		dataType : 'json',
		timeout : 100000,
		headers: {
            'Access-Control-Allow-Origin': '*'
        },
		success : function(response) {
			console.log("SUCCESS: ", data);
			if (!data.error)
				location.reload(true);
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", error);
		}
	});

}