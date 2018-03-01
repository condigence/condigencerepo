var container = document.querySelector("#switchContainer");
var switchBg = document.querySelector("#switchBg");
function onOffSwitch(){
 if(switchBg.classList.contains("switchOn")){
    switchBg.classList.remove("switchOn");
    switchBg.classList += " switchOff";
  }
  else{
    switchBg.classList.remove("switchOff");
    switchBg.classList += " switchOn";
  }
}
          
container.addEventListener("click", onOffSwitch, false);