var vehicleType;
var password;

function next(){
    var n = document.getElementById("inputValue").value;
    document.getElementById("label").innerHTML="Hi "+ n + "!" +" Enter Your Email ";
    document.getElementById("inputValue").type = "email";
    document.getElementById("inputValue").value="";
    document.getElementById("linkButton").onclick = next1;
}

function next1(){
    var email = document.getElementById("inputValue").value;
    var regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(regexp.test(email)){
       document.getElementById("label").innerHTML="Enter Your Password !";
       document.getElementById("inputValue").type = "password";
       document.getElementById("inputValue").value="";
       document.getElementById("linkButton").onclick = next2;
    }else{
        alert("Email should be in Proper Format!");
    }
}

function next2(){
    password = document.getElementById("inputValue").value;
    document.getElementById("label").innerHTML="Please Confirm Your Password !";
    document.getElementById("inputValue").type = "password";
    document.getElementById("inputValue").value="";
    document.getElementById("linkButton").onclick = next3;
}

function next3(){
  var repass = document.getElementById("inputValue").value;
  if(password != repass){
     alert("Passwords Don't Match!");
  }else{
     document.getElementById("label").innerHTML="Enter Your Contact Number!";
     document.getElementById("inputValue").type = "tel";
     document.getElementById("inputValue").value="";
     document.getElementById("linkButton").onclick = next4;
  }
 }

 function next4(){
    document.body.style.background = "gray";
     document.getElementById("label").innerHTML="Enter your vehicle number!";
     document.getElementById("inputValue").type = "number";
     document.getElementById("inputValue").value="";
     document.getElementById("linkButton").onclick = next5;
 }

 function next5(){
     document.getElementById("label").innerHTML="What's Your Vehicle Type [Cycle/MotorCycle/FourWheeler] ?";
     document.getElementById("inputValue").type = "text";
     document.getElementById("inputValue").value="";
     document.getElementById("linkButton").onclick = next6;
 }

 function next6(){
     vehicleType = document.getElementById("inputValue").value;
     document.getElementById("label").innerHTML = "Enter Your Employee Id!";
     document.getElementById("inputValue").type = "id";
     document.getElementById("inputValue").value="";
     document.getElementById("linkButton").onclick = next7;
 }

 function next7(){
     document.body.style.background = "DarkSeaGreen";
     if("Cycle" == vehicleType){
        document.getElementById("label").innerHTML="Choose Your Pass[5 Daily/100 Monthly/500 Yearly]!";
     }else if("MotorCycle" == vehicleType){
        document.getElementById("label").innerHTML="Choose Your Pass[10 Daily/200 Monthly/1000 Yearly]!";
     }else{
        document.getElementById("label").innerHTML="Choose Your Pass[20 Daily/500 Monthly/3500 Yearly]!";
     }

     document.getElementById("inputValue").type = "text";
     document.getElementById("inputValue").value="";
     document.getElementById("linkButton").onclick = next8;
 }

 function next8(){
     var pass = document.getElementById("inputValue").value;
     document.getElementById("field").innerHTML=" Your pass price is " + pass +"  !!!!!";
     document.getElementById("field").style.animation = "end 4s";
     document.body.style.background = "RosyBrown";
 }