var CategoryList = function() {
	
    return {

        init: function() {
            var json_data = {};
            json_data.checkedRow = [];
            var format = 'table';
            $('#category_list_tree').jstree("destroy").empty();
            
            alert("asdgsdgsgd");
            
            
            var url = "172.30.66.149:8000/v1/category";
            
            getAjax(url, function (data) {
            	
            	// TODO
                var data = respData;
                $("#category_list_tree").jstree({
                  plugins: ["table","dnd","contextmenu","sort","checkbox"],
                  core: {
                    data: respData
                  },
                  // configure tree table
                  table: {
                    columns: [
                      {width: 200, header: "Category Name"},
                      {width: 150, value: "createdOn", header: "Created On", format: function(row) {
                            var monthNames = ["January", "February", "March", "April", "May", "June",
                                "July", "August", "September", "October", "November", "December"
                            ];

                            mydate = new Date(row);
                            var formattedDate = '' + mydate.getDate() + ' ' + monthNames[mydate.getMonth()] + ' ' + mydate.getFullYear();
                            return formattedDate;}},
                      {width: 150, value: "products", header: "Products"},
                      {width: 150, value: "categoryStatus", header: "Status", format: function(row) {
                          if(row === "0") {
                            return 'Active';                                  
                          } else if(row === "1") {
                            return 'InActive';
                          }
                        },
                        columnClass: 'dot dot-success'
                      }
                    ],
                    resizable: true,
                    draggable: true,
                    contextmenu: true,
                    width: 500,
                    height: 300
                  }
                }).on("select_node.jstree", function (evt, data) {
                    var childFunction = function(data) {
                        for(var child = 0; child < data.length; child++) {
                        json_data.checkedRow.push({
                            "categoryId": data[child]
                            });
                        }
                    }    
                    if(data.node.children.length > 0) {
                        childFunction(data.node.children);
                    }
                         json_data.checkedRow.push({
                            "categoryId": data.node.id
                            });
                    }).on('deselect_node.jstree', function(node, selectedNodes) {
                    for(var iCheck = 0; iCheck < json_data.checkedRow.length; iCheck ++) {
                        if(json_data.checkedRow[iCheck].categoryId === selectedNodes.node.id) {
                            json_data.checkedRow.splice(iCheck, 1);
                        }
                    }
                });
            }),
                $('#category_list_tree').on("select_node.jstree", function (evt, data) {
                    $('#categoryParentDisplay').val(data.node.text);
                    $('#categoryParent').val(data.node.id);
                }).on('loaded.jstree', function(e, data) {

                    $('#category_list_tree').jstree().select_node();
                });
            $("#activate").on('click', function(event) {
               console.log("activate the vendor");
                json_data.activate = 0;
                activateDeactivate(json_data.activate);
            });

            $("#deactivate").on('click', function(event) {
                console.log("activate the vendor");
                json_data.activate = 1;
                activateDeactivate(json_data.activate);
            });

            var activateDeactivate = function(data) {
                data = {
                    'data': json_data.checkedRow,
                    'status': data,
                    'csrfmiddlewaretoken': '{{ csrf_token }}'
                }
                postAjax('/category/changeStatus', data, "", "", function(data) {}, function(data, statuscode) {
                    $('#category_list_tree').jstree("refresh");
                });
                           
            },
        }
    }();
jQuery(document).ready(function() {
    CategoryList.init()
});
