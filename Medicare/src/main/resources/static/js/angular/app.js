var app = angular.module('myapp', ["ngRoute", "mp.datePicker","ui-notification", "uiSwitch","blockingClick"]);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "./assets/partials/mainV1.html"
    })
    .when("/place_order", {
        templateUrl : "./assets/partials/ordersV1_3.html"
    })
	.when("/login", {
        templateUrl : "./assets/partials/loginV1_3.html"
    })
	.when("/checkout", {
        templateUrl : "./assets/partials/checkoutV1_5.html"
    })
	.when("/summary", {
        templateUrl : "./assets/partials/summaryV1.html"
    })
	.when("/refer", {
        templateUrl : "./assets/partials/referV1.html"
    })
    .otherwise({
        redirectTo:"/home"
    });
    
});

app.controller('mycontroller', function ($scope, $location, $http, Notification, $timeout) {
	
	//Scope variables Declaration
			$scope.appVariables = {};
			$scope.appVariables.host = 'fifokart.com';
			$scope.appVariables.showCalendar = false;
			$scope.appVariables.date='';
			$scope.submitOrderButton = true;
			
			$scope.appVariables.quantity = [];
			$scope.appVariables.quantity['loc'] = 0;
			$scope.appVariables.quantity['kin'] = 0;
			$scope.appVariables.quantity['liq'] = 0;
			$scope.appVariables.quantity['bis'] = 0;
			
			$scope.appVariables.price = [];
			$scope.appVariables.price['loc'] = 39.00;
			$scope.appVariables.price['kin'] = 99.00;
			$scope.appVariables.price['liq'] = 40.00;
			$scope.appVariables.price['bis'] = 70.00;
			
			$scope.appVariables.amount = [];
			$scope.appVariables.amount['loc'] = '00.00';
			$scope.appVariables.amount['kin'] = '00.00';
			$scope.appVariables.amount['liq'] = '00.00';
			$scope.appVariables.amount['bis'] = '00.00';
			
			$scope.appVariables.Totalamount = "00.00"; 
			$scope.appVariables.Totalamount1 = "00.00"; 
			$scope.appVariables.finalAmount = "00.00";
			$scope.appVariables.showMoney = "00.00";
			$scope.appVariables.orderTime = '';
			
			var tempDate = new Date();
			$scope.appVariables.dateError = false;
			$scope.appVariables.codeApplied = false;
			$scope.appVariables.promocode = '';
			$scope.appVariables.address='';
			$scope.appVariables.orderid='';

			$scope.appVariables.events = [];
			$scope.appVariables.slot = '';
			$scope.appVariables.quantityStock = [];
			
			//App variables login
			$scope.appVariables.login = {};
			
			$scope.appVariables.login.loginForm = false;
			$scope.appVariables.login.regForm = false;
			$scope.appVariables.login.forgotForm = false;
			$scope.appVariables.login.otpForm = false;
			$scope.appVariables.login.initialLoginForm = true;
			
			$scope.appVariables.login.name='';
			$scope.appVariables.login.address='';
			$scope.appVariables.login.password='';
			$scope.appVariables.login.otp = '';
			$scope.appVariables.login.phoneNumberError = false;
			$scope.appVariables.login.nameError=false;
			$scope.appVariables.login.passwordError=false;
			
			$scope.appVariables.sessionph = '';
			$scope.appVariables.sessionname = '';
			$scope.appVariables.showLogin = true;
			$scope.appVariables.showLogout = false;
			
			$scope.appVariables.switchValue = true;
			
			$scope.appVariables.serverDate = '';
			$scope.appVariables.serverTime = '';	
			$scope.appVariables.tempServerDate = '';
			$scope.appVariables.time = '';
			
			$scope.appVariables.refer = {};
			$scope.appVariables.refer.phoneNumber = '';
			$scope.appVariables.login.refNumber = '';
			$scope.appVariables.reference = '';
			$scope.appVariables.money = '0';
			$scope.appVariables.checkRef = false;
			$scope.appVariables.path = '';
			$scope.appVariables.login.forgotPass = true;
			
			$scope.appVariables.allSlots = [
				{id:1, slotName: '09:00am - 10:00am'},
				{id:2, slotName: '10:00am - 11:00am'},
				{id:3, slotName: '11:00am - 01:00pm'},
				{id:4, slotName: '02:00pm - 04:00pm'},
				{id:5, slotName: '04:00pm - 06:00pm'},
				{id:6, slotName: '06:00pm - 07:00pm'},
				{id:7, slotName: '07:00pm - 08:00pm'},
				{id:8, slotName: '08:00pm - 09:00pm'},
				{id:9, slotName: '09:00pm - 11:00pm'}
			];
			
			$scope.appVariables.mandatoryChecks={};
			$scope.appVariables.mandatoryChecks.doorno = false;
			$scope.appVariables.mandatoryChecks.street = false;
			$scope.appVariables.mandatoryChecks.zip = false;
			$scope.appVariables.mandatoryChecks.locality = false;
			$scope.appVariables.mandatoryChecks.address = false;
			
			$scope.appVariables.imageURL = 'http://fifokart.com/assets/img/localhero.jpg';
			$scope.appVariables.brand = 'loc';
			
			$scope.appVariables.orderPlaced=false;
			
			//Scope variables Declaration
		
			$scope.sessionLogin = function(){
				$('html, body').animate({ scrollTop: 0 }, 'slow')
			$location.path('/login');
						
		}
	
		$scope.sessionExpire = function(){
			$http({
			method: 'GET',
			  url: 'http://'+$scope.appVariables.host+'/assets/scripts/expireSessionV1.php'
			}).then(function successCallback(response) {
				$scope.appVariables.showLogin = true;
				$scope.appVariables.showLogout = false;
				$('html, body').animate({ scrollTop: 0 }, 'slow');
				Notification.success("Thank You. Please visit again.");
				
				$location.path('/home');
			}, function errorCallback(response) {
		 });
		}
		
	$scope.isSessionOn = function(){
		if(typeof($scope.appVariables.sessionph) != 'undefined' && typeof($scope.appVariables.sessionname) != 'undefined' && $scope.appVariables.sessionph != '' && $scope.appVariables.sessionname != ''){
			$scope.appVariables.showLogin = false;
			$scope.appVariables.showLogout = true;
		}
		else{
			$scope.appVariables.showLogin = true;
			$scope.appVariables.showLogout = false;
		}
	}
	
	$scope.refer = function(){
		$location.path('/refer');
	}
	
	$scope.sendRefer = function(){
		if(!$scope.phonenumberValidation($scope.appVariables.refer.phoneNumber))
			Notification.error("Please enter a valid 10 digit number");
		else if($scope.appVariables.showLogin)
			Notification.warning("Please login to refer.");	
		
		else{
			var data = $.param({
             phno : $scope.appVariables.refer.phoneNumber 
             
        });
        var config={
            headers: {
               'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }
        
         $http.post('http://' + $scope.appVariables.host + '/assets/scripts/refregviewV1.php', data, config)
	   
			.success(function (data, status, headers, config) {
           
					if(data[0].phone == $scope.appVariables.refer.phoneNumber)
						Notification.warning("The number is already registered");
					else
						$scope.sendreference();
			})
			.error(function (data, status, header, config) {
				Notification.error("failed");
		});
		}
	}
	
	$scope.sendreference = function(){
		var data = $.param({
             msgnumber : $scope.appVariables.refer.phoneNumber ,
             refNumber : $scope.appVariables.login.phoneNumber
        });
        var config={
            headers: {
               'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }
        
         $http.post('http://' + $scope.appVariables.host + '/assets/scripts/referSmsV1.php', data, config)
	   
			.success(function (data, status, headers, config) {
           
         
				Notification.info("Thank You! you will earn after first booking from your referal.");
					
			})
			.error(function (data, status, header, config) {
				Notification.error("failed");
		});	
	}
	$scope.getSessionInfo = function(){
		$http({
		method: 'GET',
		  url: 'http://'+$scope.appVariables.host+'/assets/scripts/getSessionV1.php'
		}).then(function successCallback(response) {
		    $scope.appVariables.sessionph = '';
			$scope.appVariables.sessionname = '';
			if(response.data[0].mob && response.data[0].name){
				$scope.appVariables.sessionph = response.data[0].mob;
				$scope.appVariables.sessionname = response.data[0].name;
				$scope.appVariables.login.name = response.data[0].name;
				$scope.appVariables.login.phoneNumber = response.data[0].mob;
				$scope.appVariables.address = response.data[0].address;
				$scope.appVariables.reference = response.data[0].ref;
				$scope.appVariables.money = isNaN(parseInt(response.data[0].money))?0:parseInt(response.data[0].money);
				$scope.appVariables.address = $scope.appVariables.address.replace(/\\n/g,"\n");
				$scope.viewMoney();
				$scope.isSessionOn();
			}	
		  }, function errorCallback(response) {
		  });
	}
	
	$scope.gotoReg = function(){
		$scope.appVariables.login.loginForm = true;
		$scope.appVariables.login.regForm = false;
		$scope.appVariables.login.forgotForm = false;
		$scope.appVariables.login.otpForm = false;
		$scope.appVariables.login.initialLoginForm = false;
		$scope.appVariables.login.forgotPass = true;
	}
	$scope.forgotPass = function(){
		$scope.appVariables.login.loginForm = true;
		$scope.appVariables.login.regForm = false;
		$scope.appVariables.login.forgotForm = false;
		$scope.appVariables.login.otpForm = false;
		$scope.appVariables.login.initialLoginForm = false;
		$scope.appVariables.login.forgotPass = false;
	}
    
    $scope.gotoActualReg = function(){
        $scope.appVariables.login.loginForm = false;
		$scope.appVariables.login.regForm = true
		$scope.appVariables.login.forgotForm = false;
		$scope.appVariables.login.otpForm = false;
		$scope.appVariables.login.initialLoginForm = false;
    }
	
	
	$scope.loginFifort = function(){
		$scope.appVariables.address = '';
		$scope.appVariables.login.loginForm = false;
		$scope.appVariables.login.regForm = false;
		$scope.appVariables.login.forgotForm = false;
		$scope.appVariables.login.otpForm = false;
		$scope.appVariables.login.initialLoginForm = true;
		
		if(!$scope.phonenumberValidation($scope.appVariables.login.phoneNumber))
			$scope.appVariables.login.phoneNumberError = true;
		else if($scope.appVariables.login.password == '')
			$scope.appVariables.login.passwordError=true;
		else{
			$scope.appVariables.login.phoneNumberError = false;
			$scope.appVariables.login.passwordError=false;
			
			var data = $.param({
				phno: $scope.appVariables.login.phoneNumber,
                pswd: $scope.appVariables.login.password
			});
		
			var config = {
					headers : {
						'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
					}
				}

            $http.post('http://'+$scope.appVariables.host+'/assets/scripts/registerviewV1.php', data, config)
			.success(function (data, status, headers, config) {
                if(data && data[0] && data[0].password == "matched"){
                    $scope.appVariables.login.name = data[0].name;
					$scope.appVariables.address = data[0].address;
					
					$scope.appVariables.address = $scope.appVariables.address.replace(/\\n/g,"\n");
                    $scope.orderWater();
					$scope.getSessionInfo();
					Notification.success("Hey "+$scope.appVariables.login.name+"!! Welcome to Fifokart.");
                }
                
                else
                   Notification.error("Incorrect username or password. Please try again");			
			})
			.error(function (data, status, header, config) {
			});
		}
	}
	
	$scope.insertRegData = function(){
		var nameRegEx = /^[a-zA-Z ]+$/
		if(!($scope.appVariables.login.name.match(nameRegEx))){
			$scope.appVariables.login.nameError = true;
			Notification.error("Please enter a valid name.");
		}
		else if($scope.appVariables.login.password == ''){
			$scope.appVariables.login.passwordError=true;
			Notification.error("Password cannot be blank.");
		}
		else if($scope.phonenumberValidation($scope.appVariables.reference) == false && $scope.appVariables.reference != "")
			Notification.error("Please enter valid reference number");
		else{
			$scope.appVariables.login.nameError = false;
			$scope.appVariables.login.passwordError=false;
			$scope.appVariables.checkRef = false;
			if($scope.appVariables.reference == ""){
				$scope.appVariables.checkRef = true;
				$scope.insertData(); 
			}
			else
				$scope.referCheck();
			
			

			
			
		}
	}
	$scope.insertData = function(){
		var data = $.param({
				name: $scope.appVariables.login.name,
				phno: $scope.appVariables.login.phoneNumber,
				pswd: $scope.appVariables.login.password,
				refnumber: $scope.appVariables.reference,
				checkref: $scope.appVariables.checkRef
			});
			
			
			
			
			var config = {
					headers : {
						'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
					}
				}
				
            $http.post('http://'+$scope.appVariables.host+'/assets/scripts/registerinsertV1.php', data, config)
			.success(function (data, status, headers, config) {
					Notification.success("Rgisteration Successful.");
					
					$scope.orderWater();
					$scope.getSessionInfo();
			})
			.error(function (data, status, header, config) {
                Notification.error("Failed to register. Please try again ");
				
			});	
	}
	$scope.referCheck= function(){
		var data = $.param({
				phno: $scope.appVariables.login.phoneNumber,   
				refno: $scope.appVariables.reference
			});
			
			var config = {
				headers : {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
				}
			}
			
			var flag=0;
			$http.post('http://'+$scope.appVariables.host+'/assets/scripts/referViewV1.php', data, config)
			.success(function (data, status, headers, config) {
				
					for(var i=0; i<data.length;i++){
						
						if((data[i].reference == $scope.appVariables.reference)){
							flag = 1;
						break;
						}
				}
				if(flag == 1)
					$scope.insertData();
				else
					Notification.error("Please enter correct reference number");
				
				
						})
				
			
			.error(function (data, status, header, config) {
			});
	}
	
	$scope.gotoFrg = function(){
		$scope.appVariables.login.loginForm = false;
		$scope.appVariables.login.regForm = false;
		$scope.appVariables.login.forgotForm = true;
		$scope.appVariables.login.otpForm = false;
		$scope.appVariables.login.initialLoginForm = false;
	}
	
	$scope.gotoOTP = function(){
		$scope.appVariables.login.loginForm = false;
		$scope.appVariables.login.regForm = false;
		$scope.appVariables.login.forgotForm = false;
		$scope.appVariables.login.otpForm = true;
		$scope.appVariables.login.initialLoginForm = false;
	}
	
	$scope.phonenumberValidation = function(inputtxt)  
	{  
	  var phoneno = /^\d{10}$/;  
		if((inputtxt.match(phoneno))) 
			return true;  
		else  
			return false;  
	}  
	
	$scope.verifyOtp = function(){
		if($scope.phonenumberValidation($scope.appVariables.login.phoneNumber))
		{
			$scope.appVariables.login.phoneNumberError = false;
			var data = $.param({
				countryCode: '91',
				mobileNumber: $scope.appVariables.login.phoneNumber,
				oneTimePassword: $scope.appVariables.login.otp		
			});
		
			var config = {
					headers : {
						'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
					}
				}
            $http.post('http://'+$scope.appVariables.host+'/assets/scripts/verifyOTPV1.php', data, config)
			.success(function (data, status, headers, config) {
				if(data && data.response && data.response.code.toLowerCase()=="number_verified_successfully"){
					Notification.success("Thanks, you have entered a valid OTP.");
					$scope.gotoActualReg();
				}
				else
					Notification.error("Incorrect OTP. Please try again.");
			})
			.error(function (data, status, header, config) {
                 Notification.error("Incorrect OTP. Please try again.");
				console.info("OTP failed");
			});
		}
	}
	
	$scope.getOtp = function(){
	
			var data = $.param({
						phno: $scope.appVariables.login.phoneNumber
					});
				
					var config = {
							headers : {
								'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}

					$http.post('http://'+$scope.appVariables.host+'/assets/scripts/registerForgotView.php', data, config)
					.success(function (data, status, headers, config) {
						if($scope.appVariables.login.forgotPass == false){
							if($scope.appVariables.login.phoneNumber == data[0].phone)
							{
								$scope.gettingOtp();
							}
						
							else{
								Notification.error("You are not registered! Please Register");	
								$scope.appVariables.login.forgotPass = true;
								$scope.gettingOtp();
							}
						}
						else
						{
							if($scope.appVariables.login.phoneNumber == data[0].phone)
							{
								Notification.error("You are already register!");	
								$scope.appVariables.login.forgotPass = false;
								$scope.gettingOtp();
								Notification.info("Please enter new password!");
							}
						
							else{
								$scope.gettingOtp();
							}
						}
					})
					.error(function (data, status, header, config) {
					});	
		
	
	}
	$scope.gettingOtp = function(){
		if($scope.phonenumberValidation($scope.appVariables.login.phoneNumber))
			{
				
				$scope.appVariables.login.phoneNumberError = false;
				var data = $.param({
					countryCode: '91',
					mobileNumber: $scope.appVariables.login.phoneNumber,
					getGeneratedOTP: true
				});
			
				var config = {
						headers : {
							'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
						}
					}
				$http.post('http://'+$scope.appVariables.host+'/assets/scripts/getOTPV1.php', data, config)
				.success(function (data, status, headers, config) {
					 Notification.success("Please check your registered mobile number for OTP ");
						$scope.gotoOTP();
				})
				.error(function (data, status, header, config) {
					
					console.info("OTP failed");
				});
		}
				else{
				 Notification.error("Invalid mobile number ");
				$scope.appVariables.login.phoneNumberError = true;
			}
	}
		
		$scope.buildSlotsJSON = function(){
		$scope.appVariables.slotData = [];
		
		if($scope.appVariables.orderTime>=21 || $scope.appVariables.orderTime<9){
			for(var i=0;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=9 && $scope.appVariables.orderTime<10){
			for(var i=1;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=10 && $scope.appVariables.orderTime<11){
			for(var i=2;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=11 && $scope.appVariables.orderTime<13){
			for(var i=3;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=13 && $scope.appVariables.orderTime<16){
			for(var i=4;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=16 && $scope.appVariables.orderTime<18){
			for(var i=5;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=18 && $scope.appVariables.orderTime<19){
			for(var i=6;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=19 && $scope.appVariables.orderTime<20){
			for(var i=7;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		else if($scope.appVariables.orderTime>=20 && $scope.appVariables.orderTime<21){
			for(var i=8;i<9;i++){
				$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
			}
		}
		
		$scope.appVariables.slot = $scope.appVariables.slotData[0].slotName;
	}
	
	$scope.placeOrder = function(){
		$location.path('/place_order');
	}
	
	$scope.orderWater = function() {
		if($scope.appVariables.path == "/place_order")
			$location.path('/place_order');
		else if($scope.appVariables.path == "/checkout")
			$location.path('/checkout');
		else
		$location.path('/home');
		
		$scope.appVariables.date= $scope.checkHoliday($scope.appVariables.tempServerDate);
		$scope.appVariables.orderTime = $scope.appVariables.serverTime;
		$scope.buildSlotsJSON();
	}
	
	$scope.changeInDate = function(){
		var tempYear = $scope.appVariables.tempServerDate[6]+''+$scope.appVariables.tempServerDate[7]+''+$scope.appVariables.tempServerDate[8]+''+$scope.appVariables.tempServerDate[9];
		tempDate = $scope.appVariables.tempServerDate[0]+''+$scope.appVariables.tempServerDate[1];
		var tempMon = $scope.appVariables.tempServerDate[3]+''+$scope.appVariables.tempServerDate[4];
		$scope.appVariables.dateError = false;
		var temp = $scope.appVariables.date.split('/');
		$scope.appVariables.slotData=[];
		
		if((parseInt(temp[2])==tempYear && parseInt(temp[1])>tempMon) || (parseInt(temp[2])==tempYear && parseInt(temp[1])==tempMon && parseInt(temp[0])>tempDate) || parseInt(temp[2])>tempYear){
			
			$scope.appVariables.date= $scope.checkHoliday(temp[0] + "/" + temp[1] + "/" + temp[2]);
			for(var i=0;i<9;i++){
					$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
				}
			console.info($scope.appVariables.slotData);
		}
		else if((parseInt(temp[2])==tempYear && parseInt(temp[1])<tempMon) || (parseInt(temp[2])==tempYear && parseInt(temp[1])==tempMon &&parseInt(temp[0])<tempDate) || parseInt(temp[2])<tempYear){
			$scope.appVariables.dateError = true;
			Notification.error("Please select a future date.");
					$scope.orderWater();
		}
		else
			$scope.orderWater();
	}
	
	
	$scope.toggleCalendar = function(){
		$scope.appVariables.path = "/checkout";
		$scope.appVariables.showCalendar = !$scope.appVariables.showCalendar;
		$scope.changeInDate();
	}
	
	$scope.showMoneyAdd = function(){
		if(parseInt($scope.appVariables.money) > parseInt($scope.appVariables.Totalamount)){
					$scope.appVariables.showMoney = parseFloat($scope.appVariables.Totalamount).toFixed(2);
					$scope.appVariables.finalAmount = parseFloat(parseInt($scope.appVariables.Totalamount) - parseInt($scope.appVariables.showMoney)).toFixed(2);
				}
				else{
					$scope.appVariables.finalAmount = parseFloat(parseInt($scope.appVariables.Totalamount) - parseInt($scope.appVariables.money)).toFixed(2);
					$scope.appVariables.showMoney = parseFloat($scope.appVariables.money).toFixed(2);
				}
	}
	
	$scope.increaseQ = function(brand){
		
		if($scope.appVariables.codeApplied)
			$scope.appVariables.price['loc'] = 35.00;
		else
			$scope.appVariables.price['loc'] = 39.00;
		
		$scope.viewcan();			
								
		if(brand == 'liq'){
			if($scope.appVariables.quantity['liq'] < $scope.appVariables.quantityStock['liqua']){
				$scope.appVariables.quantity['liq'] = parseInt($scope.appVariables.quantity['liq'])+1;
				$scope.appVariables.amount['liq'] = parseFloat($scope.appVariables.price['liq']*$scope.appVariables.quantity['liq']).toFixed(2);
				$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
				$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
				$scope.showMoneyAdd();
			}
			else {
				if($scope.appVariables.quantityStock['liqua']  > 0)
			Notification.error('Only '+$scope.appVariables.quantityStock['liqua'] + ' cans of Liqua are left');
		else
			Notification.error("All stock of Liqua are booked");}
		}
		if(brand == 'loc'){
		if($scope.appVariables.quantity['loc'] < $scope.appVariables.quantityStock['daily']){
			$scope.appVariables.quantity['loc'] = parseInt($scope.appVariables.quantity['loc'])+1;
			$scope.appVariables.amount['loc'] = parseFloat($scope.appVariables.price['loc']*$scope.appVariables.quantity['loc']).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		}
		else {
			if($scope.appVariables.quantityStock['daily']  > 0)
			Notification.error('Only '+$scope.appVariables.quantityStock['daily'] + ' cans of Daily can are left');
			else
			Notification.error("All stock of Daily special are booked");}
		}
		if(brand == 'bis'){
		if($scope.appVariables.quantity['bis'] < $scope.appVariables.quantityStock['bislery']){
			$scope.appVariables.quantity['bis'] = parseInt($scope.appVariables.quantity['bis'])+1;
			$scope.appVariables.amount['bis'] = parseFloat($scope.appVariables.price['bis']*$scope.appVariables.quantity['bis']).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		}
		else {
			if($scope.appVariables.quantityStock['bislery']  > 0)
			Notification.error('Only '+$scope.appVariables.quantityStock['bislery'] + ' cans of Bislery are left');
			else
			Notification.error("All stock of Bislery are booked");}
		}
		if(brand == 'kin'){
		if($scope.appVariables.quantity[brand] < $scope.appVariables.quantityStock['kinley']){
			$scope.appVariables.quantity[brand] = parseInt($scope.appVariables.quantity[brand])+1;
			$scope.appVariables.amount[brand] = parseFloat($scope.appVariables.price[brand]*$scope.appVariables.quantity[brand]).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
			}
		else {
			if($scope.appVariables.quantityStock['kinley']  > 0)
			Notification.error('Only '+$scope.appVariables.quantityStock['kinley'] + ' cans of Kinley are left');
			else
			Notification.error("All stock of Kinley are booked");}
		}
	}
	
	$scope.decreaseQ = function(brand){
		if($scope.appVariables.codeApplied)
			$scope.appVariables.price['loc'] = 35.00;
		else
			$scope.appVariables.price['loc'] = 39.00;
		
		if(parseInt($scope.appVariables.quantity[brand])>0)
		{
			$scope.appVariables.quantity[brand] = parseInt($scope.appVariables.quantity[brand])-1;
			$scope.appVariables.amount[brand] = parseFloat($scope.appVariables.price[brand]*$scope.appVariables.quantity[brand]).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		}
		
		
		if(parseInt($scope.appVariables.quantity.loc)==0 && parseInt($scope.appVariables.quantity.liq)==0 && parseInt($scope.appVariables.quantity.bis)==0 && parseInt($scope.appVariables.quantity.kin)==0)
				$location.path('/place_order');		
	}
	
	$scope.emptyQ = function(brand){
		$scope.appVariables.quantity[brand] = 0;
		$scope.appVariables.amount[brand] = parseFloat($scope.appVariables.price[brand]*$scope.appVariables.quantity[brand]).toFixed(2);
		$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
		$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
		$scope.showMoneyAdd();
	}
	$scope.checkoutEmptyQ = function(brand){
		$scope.appVariables.quantity[brand] = 0;
		$scope.appVariables.amount[brand] = parseFloat($scope.appVariables.price[brand]*$scope.appVariables.quantity[brand]).toFixed(2);
		$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
		$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
		$scope.showMoneyAdd();
		
		if(parseInt($scope.appVariables.quantity.loc)==0 && parseInt($scope.appVariables.quantity.liq)==0 && parseInt($scope.appVariables.quantity.bis)==0 && parseInt($scope.appVariables.quantity.kin)==0){
				$location.path('/place_order');
		}
	}
	
	
	$scope.applyCode = function(){
		if($scope.appVariables.promocode.toLowerCase() == "fifo70" && $scope.appVariables.codeApplied == false){
			if(parseInt($scope.appVariables.quantity.loc) == 0)
				Notification.info("Promocode is only for Daily Special can");
			else{
				Notification.success("Promo code applied successfully");
			$scope.appVariables.codeApplied = true;
			$scope.appVariables.amount.loc = parseFloat(35*$scope.appVariables.quantity.loc).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		  }
		}
		else if($scope.appVariables.codeApplied == true)
			Notification.info("Promo code already applied");
		else if($scope.appVariables.promocode.toLowerCase() =='')
			Notification.error("Please enter a promocode");
		
		else if($scope.appVariables.promocode.toLowerCase() != ''){
            		Notification.error("Please enter a valid Promocode.");
			$scope.appVariables.codeApplied = false;
			$scope.appVariables.amount.loc = parseFloat(39*$scope.appVariables.quantity.loc).toFixed(2);
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		}
	}
	
	$scope.removeCode = function(){
		$scope.appVariables.codeApplied = false;
		Notification.info("Promo Code removed");
		$scope.appVariables.promocode = "";
		$scope.appVariables.amount.loc = parseFloat(39*$scope.appVariables.quantity.loc).toFixed(2);
		$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
		$scope.showMoneyAdd();
	}
    $scope.checkOut = function(){
		
					
		if($scope.appVariables.showLogout){
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			$scope.showMoneyAdd();
		
			if(parseInt($scope.appVariables.quantity.loc)>0 || parseInt($scope.appVariables.quantity.liq)>0 || parseInt($scope.appVariables.quantity.bis)>0 || parseInt($scope.appVariables.quantity.kin)>0){
				
				$location.path('/checkout');
			}
			else
				Notification.error('Please select atleast one can.');
		}
		else{
			$scope.appVariables.path = "/checkout";
			$location.path('/login');
			Notification.warning("Please login to place the order.");
		}	
	}
    
    
   $scope.contactUs = function() {
       
         var data = $.param({
				name: $scope.appVariables.name,
                email: $scope.appVariables.email,
                msg:$scope.appVariables.msg   		
			});
		
			var config = {
					headers : {
						'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
					}
				}
			if($scope.validateEmail()) {
               $http.post('http://'+$scope.appVariables.host+'/assets/scripts/contactV1.php', data, config)
					.success(function (data, status, headers, config) {
						Notification.success("Request submitted sucessfully ");
					})
					.error(function (data, status, header, config) {
					});
               }
				else 
                       Notification.error("Request not submitted ");
   }
	
   
   $scope.validateEmail=function() {
    var x = $scope.appVariables.email;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
        return false;
     else 
       return true;
}

 $scope.viewDate1 = function(){
		  $http({
					method: 'GET',
					  url: 'http://' + $scope.appVariables.host + '/assets/scripts/dateV1.php'
					}).then(function successCallback(response) {
              
						$scope.appVariables.serverDate = response.data[0].Date;
						$scope.appVariables.serverTime = $scope.appVariables.serverTime;
						$scope.appVariables.time = response.data[0].Time + ':' +response.data[0].Time_min + ':' + response.data[0].Time_sec;
						
						var temp;
			$scope.appVariables.tempServerDate = $scope.appVariables.serverDate;
			temp = $scope.appVariables.tempServerDate.split('/');
			if($scope.appVariables.serverTime >=21){
							temp[0] = (parseInt(temp[0])+1).toString();
						}
						
						$scope.appVariables.tempServerDate = temp[0] + '/' + temp[1] +'/' + temp[2];
						if(parseInt($scope.appVariables.serverTime) > parseInt($scope.appVariables.orderTime))
						 {
							 var checkoutDate = $scope.appVariables.tempServerDate;

							$scope.appVariables.date= $scope.checkHoliday(checkoutDate);
							$scope.appVariables.orderTime = $scope.appVariables.serverTime;
							$scope.buildSlotsJSON();
							Notification.info("The selected slot is expired! Please select different slots");
						 }
						 else{
							 $scope.checkBilling();
						 }
					}, function errorCallback(response) {
						});
	  }
$scope.submitBilling = function(){
	$scope.viewDate1();
		
			 
}

$scope.checkBilling = function(){
	
				$scope.submitOrderButton = false;
				$http({
					method: 'GET',
					  url: 'http://' + $scope.appVariables.host + '/assets/scripts/canviewV1.php'
					}).then(function successCallback(response) {
		  				for(var i=0; i<response.data.length; i++)
							$scope.appVariables.quantityStock[response.data[i].brand] = parseInt(response.data[i].quantity); 
					
					if($scope.appVariables.quantity.loc > $scope.appVariables.quantityStock['daily']){
					$scope.appVariables.quantity.loc = $scope.appVariables.quantityStock['daily'];
					$scope.appVariables.amount['loc'] = parseFloat($scope.appVariables.price['loc']*$scope.appVariables.quantity['loc']).toFixed(2);
					if($scope.appVariables.quantityStock['daily'] > 0)
						Notification.error("Only " +  $scope.appVariables.quantityStock['daily'] + " stocks are left of Daily can");
					else
						Notification.error("There is no Daily cans in stock");
				}
					
					if($scope.appVariables.quantity.liq > $scope.appVariables.quantityStock['liqua']){
					$scope.appVariables.quantity.liq = $scope.appVariables.quantityStock['liqua'];
						$scope.appVariables.amount['liq'] = parseFloat($scope.appVariables.price['liq']*$scope.appVariables.quantity['liq']).toFixed(2);
						if($scope.appVariables.quantityStock['liqua'])
				Notification.error("Only " +  $scope.appVariables.quantityStock['liqua'] + " stocks are left of Liqua can");
				else
						Notification.error("There is no Daily cans in stock");
					}
						
						if($scope.appVariables.quantity.bis > $scope.appVariables.quantityStock['bislery']){
					$scope.appVariables.quantity.bis = $scope.appVariables.quantityStock['bislery'];
							$scope.appVariables.amount['bis'] = parseFloat($scope.appVariables.price['bis']*$scope.appVariables.quantity['bis']).toFixed(2);
							if($scope.appVariables.quantityStock['bislery'])
				Notification.error("Only " +  $scope.appVariables.quantityStock['bislery'] + " stocks are left of Bislery can");
				else
						Notification.error("There is no Bislery in stock");
						}
							
							if($scope.appVariables.quantity.kin > $scope.appVariables.quantityStock['kinley']){
					$scope.appVariables.quantity.kin = $scope.appVariables.quantityStock['kinley'];
								$scope.appVariables.amount['kin'] = parseFloat($scope.appVariables.price['kin']*$scope.appVariables.quantity['kin']).toFixed(2);
					if($scope.appVariables.quantityStock['kinley'])
				Notification.error("Only " +  $scope.appVariables.quantityStock['kinley'] + " stocks are left of kinley can");
				else
						Notification.error("There is no Kinley in stock");
				
			}
				
					$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
					
					
					if(!($scope.appVariables.quantityStock['daily']) && !($scope.appVariables.quantityStock['liqua']) && !($scope.appVariables.quantityStock['bislery']) && !($scope.appVariables.quantityStock['kinley'])){
								Notification.error("All stock are empty");
								$location.path('/place_order');
								$scope.submitOrderButton = true;}
					
					
					else if($scope.appVariables.Totalamount == 0)
						{
							Notification.error("Stocks are Empty which you choosen");
							$location.path('/place_order');
							$scope.submitOrderButton = true;
						}
					else					
						$scope.billing();
	
					
					}, function errorCallback(response) {
						$scope.submitOrderButton = true;
					  }); 
	
	
	
				

   
$scope.billing = function(){
	
	
	var addRegEx = /(.*[a-zA-Z0-9]){10}/;
	if(!($scope.appVariables.address.match(addRegEx))){
		$scope.appVariables.mandatoryChecks.address = true;
		$scope.submitOrderButton = true;
		Notification.error("Please enter the delivery Address.");
	}
	else{
		$scope.appVariables.login.address = $scope.appVariables.address.replace(/\r?\n|\r/g, "\\\\n");
		$scope.appVariables.mandatoryChecks.address = false;
	}
	if($scope.appVariables.codeApplied){
			$scope.appVariables.price['loc'] = 35.00;
		}
		else{
			$scope.appVariables.price['loc'] = 39.00;
		}
		
		if(parseInt($scope.appVariables.quantity['loc'])>0)
		{
			$scope.appVariables.quantity['loc'] = parseInt($scope.appVariables.quantity['loc']);
			$scope.appVariables.amount['loc'] = parseFloat($scope.appVariables.price['loc']*$scope.appVariables.quantity['loc']).toFixed(2);
			
			
		}	
	if(parseInt($scope.appVariables.quantity['bis'])>0)
		{
			$scope.appVariables.quantity['bis'] = parseInt($scope.appVariables.quantity['bis']);
			$scope.appVariables.amount['bis'] = parseFloat($scope.appVariables.price['bis']*$scope.appVariables.quantity['bis']).toFixed(2);
			
		}	
	if(parseInt($scope.appVariables.quantity['liq'])>0)
		{
			$scope.appVariables.quantity['liq'] = parseInt($scope.appVariables.quantity['liq']);
			$scope.appVariables.amount['liq'] = parseFloat($scope.appVariables.price['liq']*$scope.appVariables.quantity['liq']).toFixed(2);
			
			
		}	
	if(parseInt($scope.appVariables.quantity['kin'])>0)
		{
			$scope.appVariables.quantity['kin'] = parseInt($scope.appVariables.quantity['kin']);
			$scope.appVariables.amount['kin'] = parseFloat($scope.appVariables.price['kin']*$scope.appVariables.quantity['kin']).toFixed(2);
			
			
		}	
	$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
	
	$scope.appVariables.particulars='';
	
	if(!$scope.appVariables.mandatoryChecks.address)
	{
		var switchVal = '';
		
		if($scope.appVariables.quantity['loc'] > 0){
			if($scope.appVariables.particulars != '')
				$scope.appVariables.particulars = $scope.appVariables.particulars+', ';
			$scope.appVariables.particulars = $scope.appVariables.particulars + 'Daily_Special-'+$scope.appVariables.quantity['loc'];
		}
		if($scope.appVariables.quantity['liq'] > 0){
			if($scope.appVariables.particulars != '')
				$scope.appVariables.particulars = $scope.appVariables.particulars+',';
			$scope.appVariables.particulars = $scope.appVariables.particulars + 'Liqua-'+$scope.appVariables.quantity['liq'];
		}
		if($scope.appVariables.quantity['kin'] > 0){
			if($scope.appVariables.particulars != '')
				$scope.appVariables.particulars = $scope.appVariables.particulars+',';
			$scope.appVariables.particulars = $scope.appVariables.particulars + 'Kinley-'+$scope.appVariables.quantity['kin'];
		}
		if($scope.appVariables.quantity['bis'] > 0){
			if($scope.appVariables.particulars != '')
				$scope.appVariables.particulars = $scope.appVariables.particulars+',';
			$scope.appVariables.particulars = $scope.appVariables.particulars + 'Bisleri-'+$scope.appVariables.quantity['bis'];
		}
		
		
		if($scope.appVariables.switchValue)
			switchVal = 'Yes';
		else
			switchVal = 'No';
		var data = $.param({
			phno: $scope.appVariables.login.phoneNumber,   
			refno: $scope.appVariables.reference
		});
		
		var config = {
			headers : {
				'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}
		
		var flag=0;
		$http.post('http://'+$scope.appVariables.host+'/assets/scripts/referViewV1.php', data, config)
		.success(function (data, status, headers, config) {
			
				for(var i=0; i<data.length;i++){
					
					if((data[i].reference == $scope.appVariables.reference) && parseInt(data[i].fb) == 0){
						flag = 1;
					break;
					}
			}
			if(flag == 1)
				$scope.refermoney();
			else
			$scope.insertRegReferData();
			
			
					})
			
		
		.error(function (data, status, header, config) {
			$scope.submitOrderButton = true;
		});
		
		
	}	
}
   
   $scope.refermoney = function(){
	   var refNo= $.param({
			phno: $scope.appVariables.login.phoneNumber,   
			refno:$scope.appVariables.reference
		})
		
		var config = {
			headers : {
				'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}
	   $http.post('http://'+$scope.appVariables.host+'/assets/scripts/referMoneyV1.php', refNo, config)
					.success(function (refNo, status, headers, config) {
								
								
							})
					$scope.insertRegReferData();
			   }
			   
		$scope.insertRegReferData = function(){
			if($scope.appVariables.switchValue)
			switchVal = 'Yes';
			else
			switchVal = 'No';
			var data = $.param({
			name: $scope.appVariables.login.name,
			phno: $scope.appVariables.login.phoneNumber,   
			address: $scope.appVariables.login.address, 
			date: $scope.appVariables.date, 
			switchval:switchVal, 
			particulars:$scope.appVariables.particulars,
			price:$scope.appVariables.finalAmount,
			slot:$scope.appVariables.slot,
			bookDate: $scope.appVariables.serverDate,
			bookTime: $scope.appVariables.time
		});
			
			var config = {
			headers : {
				'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}
			//Call to insert into booking table
		$http.post('http://'+$scope.appVariables.host+'/assets/scripts/bookinginsertV1.php', data, config)
		.success(function (data, status, headers, config) {
			$scope.appVariables.orderid = data.orderid;
			
			 Notification.success("Thank you.. your order accepted ");
			$location.path('/summary');
		})
		.error(function (data, status, header, config) {
			$scope.submitOrderButton = true;
		});
		
		//Call to Send the mail
		$http.post('http://'+$scope.appVariables.host+'/assets/scripts/mailV1.php', data, config)
		.success(function (data, status, headers, config) {
		})
		.error(function (data, status, header, config) {
		});
		
		//Call to update the address in register table
		 var registerdata= $.param({
			phno: $scope.appVariables.login.phoneNumber,   
			address:$scope.appVariables.login.address,
			refno: $scope.appVariables.reference,
			totalamount: $scope.appVariables.Totalamount  
		})
		
		$http.post('http://'+$scope.appVariables.host+'/assets/scripts/registerupdateV1.php', registerdata, config)
		.success(function (registerdata, status, headers, config) {
		})
		.error(function (data, status, header, config) {
		});
	}
}
  	 $scope.viewcan=function()
    {
   	  $http({
					method: 'GET',
					  url: 'http://' + $scope.appVariables.host + '/assets/scripts/canviewV1.php'
					}).then(function successCallback(response) {
		  				for(var i=0; i<response.data.length; i++)
							$scope.appVariables.quantityStock[response.data[i].brand] = parseInt(response.data[i].quantity); 
					}, function errorCallback(response) {
					  }); 
    }
   
	 $scope.checkTime = function(){
				if($scope.appVariables.quantity.loc > $scope.appVariables.quantityStock['daily']){
					$scope.appVariables.quantity.loc = $scope.appVariables.quantityStock['daily'];
					$scope.appVariables.amount['loc'] = parseFloat($scope.appVariables.price['loc']*$scope.appVariables.quantity['loc']).toFixed(2);
					if($scope.appVariables.quantityStock['daily'] > 0)
				Notification.error("Only " +  $scope.appVariables.quantityStock['daily'] + " stocks are left of Daily can");
				else
					Notification.error("Stock of Daily Special cans are empty");
				}
			if($scope.appVariables.quantity.liq > $scope.appVariables.quantityStock['liqua']){
					$scope.appVariables.quantity.liq = $scope.appVariables.quantityStock['liqua'];
					$scope.appVariables.amount['liq'] = parseFloat($scope.appVariables.price['liq']*$scope.appVariables.quantity['liq']).toFixed(2);
					if($scope.appVariables.quantityStock['liqua'] > 0)
				Notification.error("Only " +  $scope.appVariables.quantityStock['liqua'] + " stocks are left of Liqua can");
				else
					Notification.error("Stock of Liqua cans are empty");
					}			
			if($scope.appVariables.quantity.bis > $scope.appVariables.quantityStock['bislery']){
					$scope.appVariables.quantity.bis = $scope.appVariables.quantityStock['bislery'];
					$scope.appVariables.amount['bis'] = parseFloat($scope.appVariables.price['bis']*$scope.appVariables.quantity['bis']).toFixed(2);
					if($scope.appVariables.quantityStock['bislery'] > 0)
				Notification.error("Only " +  $scope.appVariables.quantityStock['bislery'] + " stocks are left of Bislery can");
				else
					Notification.error("Stock of Bisleri cans are empty");
						}
				if($scope.appVariables.quantity.kin > $scope.appVariables.quantityStock['kinley']){
					$scope.appVariables.quantity.kin = $scope.appVariables.quantityStock['kinley'];
					$scope.appVariables.amount['kin'] = parseFloat($scope.appVariables.price['kin']*$scope.appVariables.quantity['kin']).toFixed(2);
					if($scope.appVariables.quantityStock['kinley'] > 0)
				Notification.error("Only " +  $scope.appVariables.quantityStock['kinley'] + " stocks are left of kinley can");
				else
					Notification.error("Stock of Kinley cans are empty");				
			}
			$scope.appVariables.Totalamount = parseFloat(parseInt($scope.appVariables.amount.loc)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			if((parseInt($scope.appVariables.quantity.loc)==0 && parseInt($scope.appVariables.quantity.liq)==0 && parseInt($scope.appVariables.quantity.bis)==0 && parseInt($scope.appVariables.quantity.kin)==0) || $scope.appVariables.orderPlaced)
					$location.path('/place_order');
			}
	 
	 
	 $scope.viewEvent=function()
    {
            $http({
					method: 'GET',
					  url: 'http://' + $scope.appVariables.host + '/assets/scripts/eventviewV1.php'
					}).then(function successCallback(response) {
              
						$scope.appVariables.events = response.data;
					}, function errorCallback(response) {
						});
    }
	  
	  $scope.viewDate = function(){
		  $http({
					method: 'GET',
					  url: 'http://' + $scope.appVariables.host + '/assets/scripts/dateV1.php'
					}).then(function successCallback(response) {
              
						$scope.appVariables.serverDate = response.data[0].Date;
						$scope.appVariables.serverTime = response.data[0].Time;
						$scope.appVariables.time = response.data[0].Time + ':' +response.data[0].Time_min + ':' + response.data[0].Time_sec;
						
						var temp;
			$scope.appVariables.tempServerDate = $scope.appVariables.serverDate;
			temp = $scope.appVariables.tempServerDate.split('/');
			if($scope.appVariables.serverTime >=21){
							temp[0] = (parseInt(temp[0])+1).toString();
						}
						
						$scope.appVariables.tempServerDate = temp[0] + '/' + temp[1] +'/' + temp[2];
					}, function errorCallback(response) {
						});
	  }
	 $scope.checkDate = function(date1){
		 var tempDate2 = date1;
			var tempMon2 = (tempDate2.getMonth()+1).toString();
			var tempDay2 = (tempDate2.getDate()).toString();
			if(tempDate2.getHours() > 20)
				tempDay2 = tempDate2.getDate()+1;
			if(parseInt(tempDay2) < 10 && parseInt(tempDay2) > 0)
				tempDay2 = '0'+tempDay2;
			if(parseInt(tempMon2) < 10 && parseInt(tempMon2) > 0)
				tempMon2 = '0'+tempMon2;
		 return tempDay2 + '-' + tempMon2 + '-' + tempDate2.getFullYear();
	 }
	 
	 $scope.checkDate1 = function(date1){
		 var tempDate2 = date1;
			var tempMon2 = tempDate2.getMonth()+1;
			var tempDay2 = tempDate2.getDate();
			if(tempDate2.getHours() > 20)
				tempDay2 = tempDate2.getDate()+1;
			if(tempMon2>='1' && tempMon2 <=9)
				tempMon2 = '0'+tempMon2;
		 return tempDay2 + '/' + tempMon2 + '/' + tempDate2.getFullYear();
	 }
	 $scope.checkHoliday = function(dateHoliday){
		 var i = 0;
		 var parts = dateHoliday.split('/');
		 var dateHoliday1 = parts[0] + "-" + parts[1] + "-" + parts[2];
		 var tempDate = new Date(parts[2],parts[1]-1,parts[0]); 
		 while(i < $scope.appVariables.events.length){
		 	if($scope.checkDate(tempDate) == $scope.appVariables.events[i].Date){
				Notification.error($scope.appVariables.events[i].Event);
				tempDate.setDate(tempDate.getDate() + 1);
				i = 0;
				
			}
			 else
				 i++;
			 }
			 
			 var t = $scope.checkDate1(tempDate);
			 if(t[1] == '/')
		 return '0'+$scope.checkDate1(tempDate);
	 else
		 return $scope.checkDate1(tempDate);
	 }

	 $scope.viewMoney = function(){
		 
		 var data = $.param({
			phno: $scope.appVariables.login.phoneNumber,   
			
		});
			
			var config = {
			headers : {
				'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}
			//Call to insert into booking table
		$http.post('http://'+$scope.appVariables.host+'/assets/scripts/refeemoneyviewV1.php', data, config)
		.success(function (data, status, headers, config) {
			$scope.appVariables.money = data[0].Money;
		})
		.error(function (data, status, header, config) {
		});
	 }
	$scope.init = function () {
		
		$scope.getSessionInfo();
		if(screen.width > 1024)
			$('select').select2();
		$scope.viewDate();
		$scope.viewcan();
		
        if(window.location.hash.split('/')[1] == "place_order"){
			$scope.submitOrderButton = true;
			if($scope.appVariables.path != "/checkout")
				$scope.appVariables.path = $location.path();
			$scope.viewEvent();
			$scope.appVariables.quantity['loc'] = 0;
				$scope.appVariables.quantity['kin'] = 0;
				$scope.appVariables.quantity['liq'] = 0;
				$scope.appVariables.quantity['bis'] = 0;
				
				$scope.appVariables.amount = [];
				$scope.appVariables.amount['loc'] = '00.00';
				$scope.appVariables.amount['kin'] = '00.00';
				$scope.appVariables.amount['liq'] = '00.00';
				$scope.appVariables.amount['bis'] = '00.00';
				
				$scope.appVariables.Totalamount = "00.00";
			if($scope.appVariables.orderPlaced){
				$scope.appVariables.codeApplied = false;
				$scope.appVariables.quantity = [];
				$scope.appVariables.quantity['loc'] = 0;
				$scope.appVariables.quantity['kin'] = 0;
				$scope.appVariables.quantity['liq'] = 0;
				$scope.appVariables.quantity['bis'] = 0;
				
				$scope.appVariables.amount = [];
				$scope.appVariables.amount['loc'] = '00.00';
				$scope.appVariables.amount['kin'] = '00.00';
				$scope.appVariables.amount['liq'] = '00.00';
				$scope.appVariables.amount['bis'] = '00.00';
				
				$scope.appVariables.Totalamount = "00.00"; 
				
				$scope.appVariables.imageURL = 'http://fifokart.com/assets/img/localhero.jpg';
				$scope.appVariables.brand = 'loc';
				
				$scope.appVariables.orderPlaced = false;
		}
	}
		else if(window.location.hash.split('/')[1] == "login"){
			
			if($scope.appVariables.showLogout)
				$location.path('/place_order');
			else{
				$scope.appVariables.login.loginForm = false;
				$scope.appVariables.login.regForm = false;
				$scope.appVariables.login.forgotForm = false;
				$scope.appVariables.login.otpForm = false;
				$scope.appVariables.login.initialLoginForm = true;
				$scope.appVariables.orderPlaced = false;
			}
		}
		else if(window.location.hash.split('/')[1] == "summary"){
			$scope.submitOrderButton = true;
			if($scope.appVariables.login.name == '' || $scope.appVariables.login.phoneNumber =='' || parseInt($scope.appVariables.Totalamount) == 0 || $scope.appVariables.date == '' || $scope.appVariables.slot == '' || $scope.appVariables.address == '')
			{
				$location.path('/home');
				$scope.appVariables.orderPlaced = false;
			}
			else
				$scope.appVariables.orderPlaced = true;
		}
		else if(window.location.hash.split('/')[1] == "checkout"){
					
							
			//$scope.viewDate();
			
			$scope.appVariables.Totalamount1 = parseFloat((parseInt($scope.appVariables.quantity.loc)*39)+parseInt($scope.appVariables.amount.liq)+parseInt($scope.appVariables.amount.bis)+parseInt($scope.appVariables.amount.kin)).toFixed(2);
			
			
			//var checkoutDate = tempDay + '/' + tempMon + '/' + tempDate.getFullYear();
						var checkoutDate = $scope.appVariables.tempServerDate;

						$scope.appVariables.date= $scope.checkHoliday(checkoutDate);
			$scope.appVariables.slotData = [];
				for(var i=0;i<9;i++){
					$scope.appVariables.slotData.push($scope.appVariables.allSlots[i]);
				}
				$scope.appVariables.slot = $scope.appVariables.slotData[0].slotName;
			if($scope.appVariables.tempServerDate == $scope.appVariables.date)
			{
				$scope.appVariables.orderTime = $scope.appVariables.serverTime;
				$scope.buildSlotsJSON();
			}
			
			$timeout($scope.checkTime , 500);
			if((parseInt($scope.appVariables.quantity.loc)==0 && parseInt($scope.appVariables.quantity.liq)==0 && parseInt($scope.appVariables.quantity.bis)==0 && parseInt($scope.appVariables.quantity.kin)==0) || $scope.appVariables.orderPlaced)
					$location.path('/place_order');
		}
		
		else if(window.location.hash.split('/')[1] == "refer"){
			
			
		}
		else if(window.location.hash.split('/')[1] == "home"){
			$scope.appVariables.path = $location.path();
			
		}
    }
	
	var IDLE_TIMEOUT = 3600; //seconds
	var _idleSecondsCounter = 0;
	document.onclick = function() {
		_idleSecondsCounter = 0;
	};
	document.onmousemove = function() {
		_idleSecondsCounter = 0;
	};
	document.onkeypress = function() {
		_idleSecondsCounter = 0;
	};
	
	$scope.CheckIdleTime = function() {
		_idleSecondsCounter++;
		var oPanel = document.getElementById("SecondsUntilExpire");
		if (oPanel)
			oPanel.innerHTML = (IDLE_TIMEOUT - _idleSecondsCounter) + "";
		if (_idleSecondsCounter >= IDLE_TIMEOUT && $scope.appVariables.showLogout) 
			$scope.sessionExpire();
	}
	window.setInterval($scope.CheckIdleTime, 1000);
	
	$scope.emptyCanSwitchChange = function(){
		if(!$scope.appVariables.switchValue)
			Notification('A refundable deposit of Rs.150 is applicable in the absence of empty cans.');
		}
	
	$scope.loadCanImages = function(url, brand){
		$scope.appVariables.imageURL = url;
		$scope.appVariables.brand = brand;
	}
	
	$scope.refundCan = function(){
		if($scope.appVariables.showLogin)
			Notification.warning("Please login to submit the request.");
		else{
			var data = $.param({
				name: $scope.appVariables.login.name,
				phno: $scope.appVariables.login.phoneNumber,   
				address: $scope.appVariables.address, 
				date: $scope.appVariables.serverDate,
				
			});
			
			var config = {
				headers : {
					'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
				}
			}
			$http.post('http://'+$scope.appVariables.host+'/assets/scripts/refundMailV1.php', data, config)
			.success(function (data, header, config) {
				Notification.success("your request is submitted. We can contact you shortly");
			})
			.error(function (data, header, config) {
			});
		}
	}
});


