$('#addAppointmentform').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	add_appointment_firstName: {
                validators: {
                    notEmpty: {
                        message: 'Patient First Name is required'
                    }, regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'Patient First Name is Invalid!'
                    }
                }
            },
            add_appointment_lastName: {
                validators: {
                    notEmpty: {
                        message: 'Patient Last Name is required'
                    }, regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'Patient Last Name is Invalid'
                    }
                }
            },            
            add_appointment_serviceTypeId: {
                validators: {
                    notEmpty: {
                        message: 'Services Name is required'
                    }
                }
            },          
            add_appointment_age: {
                validators: {
                    notEmpty: {
                        message: 'Age is required'
                    }
                }
            },
            pcontact: {
                validators: {
                    notEmpty: {
                        message: 'Contact is required'
                    },
                    regexp: {
                        message: 'The phone number is Invalid',
                        regexp: /^[0-9\s\-()+\.]+$/
                    }
                }
            },
            add_appointment_address: {
                validators: {
                    notEmpty: {
                        message: 'Address is required'
                    }
                }
            },
            add_appointment_gender: {
                validators: {
                    notEmpty: {
                        message: 'Gender is required'
                    }
                }
            },
            add_appointment_email: {
                validators: {
                    notEmpty: {
                        message: 'Email is required'
                    },
                    emailAddress: {
                        message: 'Not a valid email address'
                    } 
                }
            },
            add_appointment_dateTime: {
                validators: {
                    notEmpty: {
                        message: 'Date Time is required'
                    }
                }
            },
            add_appointment_slot: {
                validators: {
                    notEmpty: {
                        message: 'Slot is required'
                    }
                }
            },
            add_appointment_referredByDoctorId: {
                validators: {
                    notEmpty: {
                        message: 'Doctor Name is required'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e) {
    	
    
		var firstName = $(".add_appointment_firstName")
				.val();
		var lastName = $(".add_appointment_lastName").val();
		var age = $(".add_appointment_age").val();
		var address = $(".add_appointment_address").val();
		var contactNo = $(".add_appointment_contact")
				.val();
		var gender = $(
				".add_appointment_gender option:selected")
				.text();
		var email = $(".add_appointment_email").val();
		var referredByDoctorId = $(
				".add_appointment_referredByDoctorId option:selected")
				.val();
		var serviceTypeId = $(
				".add_appointment_serviceTypeId option:selected")
				.val();
		
				
		var dateTime = $(".add_appointment_dateTime").val();

		var jsondata = {};
		
		var user = {};
		var doctor = {};
		var patient = {};	
		
        var serviceType = {};		
		var services = [];		
		serviceType["id"] = serviceTypeId;		
		services[0] = serviceType;			
		
		jsondata["serviceType"] = services;				
		jsondata["firstName"] = firstName;
		jsondata["lastName"] = lastName;
		jsondata["age"] = age;
		jsondata["address"] = address;
		jsondata["contactNo"] = contactNo;
		jsondata["gender"] = gender;
		jsondata["email"] = email;
		doctor["id"] = 1;
		
		jsondata["referredByDoctor"] = doctor;	
		jsondata["dateTime"] = "";
		jsondata["slot"] = 1;
		
		user["id"] = loggedInUserId;		
		jsondata["createdByUserId"] = user;
	
		var appointmentAddUrl = baseUrl + "/appointments";
		callAjaxPostJSON(appointmentAddUrl, "POST", "", jsondata);
		clearForm();
	    $("#addAppo").modal('hide');
		location.reload(true);
		 
    });
  




/*---------------------form Validation to Add User----------------------*/

 $('#addUserform').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	add_user_name: {
                validators: {
                    notEmpty: {
                        message: 'First Name is required'
                    }
                }
            },
            add_user_last_name: {
                validators: {
                    notEmpty: {
                        message: 'Last Name is required'
                    }
                }
            },            
            add_user_role: {
                validators: {
                    notEmpty: {
                        message: ' Role is required'
                    }
                }
            },          
            add_user_email: {
                validators: {
                    notEmpty: {
                        message: 'Email is required'
                    },
                    emailAddress: {
                        message: 'Not a valid email address'
                    } 
                }
            },
            add_user_password: {
                validators: {
                    notEmpty: {
                        message: 'Password is required'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e) {
    	
    	var name = $("#add_user_name").val();
		var lastName = $("#add_user_last_name").val();
		var email = $("#add_user_email").val();
		var password = $("#add_user_password").val();		
		var role = $("#add_user_role option:selected").text();
				
		var jsondata = {};
		jsondata["name"]= name;
		jsondata["lastName"]= lastName;
		jsondata["email"]= email;
		jsondata["password"]= password;
		jsondata["role"] = role;	
		
		 var userAddUrl = baseUrl + "/users";
		 callAjaxPostJSON(userAddUrl, "POST", "", jsondata);
		 $("#addUser").modal('hide');
		 location.reload(true);
		 
    });
  
 /*---------------------form Validation to Add User----------------------*/

 
 /*---------------------form Validation to Add Doctor----------------------*/

 $('#addDoctorform').formValidation({
	 
     framework: 'bootstrap',
     excluded: ':disabled',
     icon: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
    	 add_doctor_name: {
             validators: {
                 notEmpty: {
                     message: 'Doctor name is required'
                 },
                 /*stringLength: {
                     min: 6,
                     max: 30,
                     message: 'The username must be more than 6 and less than 30 characters long'
                 },*/
                 regexp: {
                     regexp: /^[a-zA-Z0-9_\.]+$/,
                     message: 'The username can only consist of alphabetical, number, dot and underscore'
                 }
             }
         },
         add_doctor_contactNo: {
             validators: {
                 notEmpty: {
                     message: 'The contact No. is required'
                 },
                 regexp: {
                     message: 'The phone number can only contain the digits, spaces, -, (, ), + and .',
                     regexp: /^[0-9\s\-()+\.]+$/
                 }
             }
         },
         add_doctor_email: {
             validators: {
                 notEmpty: {
                     message: 'The email is required'
                 },
                 emailAddress: {
                     message: 'The input is not a valid email address'
                 }
             }
         },
         add_doctor_qualification: {
             validators: {
                 notEmpty: {
                     message: 'The qualification is required'
                 }
             }
         },
         add_doctor_speciality: {
             validators: {
                 notEmpty: {
                     message: 'The doctor speciality is required'
                 }
             }
         },
         add_doctor_hospitalName: {
             validators: {
                 notEmpty: {
                     message: 'The hospital name is required'
                 }
             }
         },
         add_doctor_address: {
             validators: {
                 notEmpty: {
                     message: 'The doctor address is required'
                 }
             }
         }
         
        
     }
 }).on('success.form.fv', function(e) {
 		  	
 	var name = $(".add_doctor_name").val();				
	
	var contactNo =	$(".add_doctor_contactNo").val();
	var email =	$(".add_doctor_email").val();
	var hospitalName = $(".add_doctor_hospitalName").val();
	var qualification = $(".add_doctor_qualification").val();
	var speciality = $(".add_doctor_speciality").val();
	var address =	$(".add_doctor_address").val();
	var commission = $(".add_doctor_commission").val();

	var jsondata = {};
	jsondata["name"] = name;
	jsondata["contactNo"] = contactNo;
	jsondata["email"] = email;
	jsondata["hospitalName"] = hospitalName;
	jsondata["qualification"] = qualification;
	jsondata["speciality"] = speciality;
	jsondata["address"] = address;			
	jsondata["commission"] = commission;
	jsondata["addedByUserId"] = 1;


	
	var doctorAddUrl = baseUrl + "/doctors";
	callAjaxPostJSON(doctorAddUrl, "POST", "", jsondata);

		 $("#addDoctor").modal('hide');
		 location.reload(true);
 });

/*---------------------form Validation to Add doctor----------------------*/

 /*---------------------form Validation to Add service----------------------*/
/*
 
 /*---------------------form Validation to Edit Service Starts----------------------*/ 
 
 $('#addServiceform').formValidation({
     framework: 'bootstrap',
     excluded: ':disabled',
     icon: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
     	add_new_serviceType: {
             validators: {
                 notEmpty: {
                     message: 'The Service name is required'
                 }
             }
         },
         add_new_serviceType_price: {
             validators: {
                 notEmpty: {
                     message: 'The Service price is required'
                 },
                 regexp: {
                     message: 'The commission can only contain the digits, spaces, -, (, ), + and .',
                     regexp: /^[0-9\s\-()+\.]+$/
                 }
             }
         }
     }
 }).on('success.form.fv', function(e) {
 	
 	e.preventDefault();
 	
 		var name = $("#add_new_serviceType").val();
		var price = $("#add_new_serviceType_price").val();
		var jsondata = {};
		jsondata["name"] = name;
		jsondata["price"] = price;
		jsondata["createdByUserId"] = loggedInUserId;
		var serviceAddUrl = baseUrl + "/services";
		callAjaxPostJSON(serviceAddUrl, "POST", "", jsondata);
		 $("#addService").modal('hide');
		 location.reload(true);
 });

 /*---------------------form Validation to Edit Service ----------------------*/ 
 
 
 
 /*---------------------form Validation to Add Role Permission----------------------*/
 $('#addUserRoleform').formValidation({
     framework: 'bootstrap',
     excluded: ':disabled',
     icon: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
    	 add_user_type_role: {
              validators: {
                  notEmpty: {
                      message: 'The Role is required'
                  }
              }
          }
      }
 
 }).on('success.form.fv', function(e) {
 	
 	 	 	
 	var role = $("#add_user_type_role").val();
 	
 	if(role != " "){
 		var jsondata = {};
 		jsondata["role"] = role;
 	 	
 		var serviceAddUrl = baseUrl + "/roles";
 		callAjaxPostJSON(serviceAddUrl, "POST", "", jsondata);
 		 $("#addUserRole").modal('hide');
 		 location.reload(true);
 		
 	}else{
 		//alert("Please Enter Role Name!");
 	}
 	
	
 	
 });




