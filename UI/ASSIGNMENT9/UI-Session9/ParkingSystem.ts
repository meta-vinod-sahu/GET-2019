let vehicleType : string;
let password : string;

//Changes label to input Email
function next(){
    let n :string = (<HTMLInputElement>document.getElementById("input")).value;
    document.getElementById("label").innerHTML="Hi "+ n + "!" +" Enter Your Email ";
    (<HTMLInputElement>document.getElementById("input")).type = "email";
    (<HTMLInputElement>document.getElementById("input")).value="";
    document.getElementById("next").onclick = next1;
}

//Changes label to input password
function next1(){
    let email: string = (<HTMLInputElement>document.getElementById("input")).value;
    let regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(regexp.test(email)){
       document.getElementById("label").innerHTML="Enter Your Password !";
       (<HTMLInputElement>document.getElementById("input")).type = "password";
       (<HTMLInputElement>document.getElementById("input")).value="";
       document.getElementById("next").onclick = next2;
    }else{
        alert("Email should be in Proper Format!");
    }
}

//Changes label to confirm password
function next2(){
    password = (<HTMLInputElement>document.getElementById("input")).value;
    document.getElementById("label").innerHTML="Please Confirm Your Password !";
    (<HTMLInputElement>document.getElementById("input")).type = "password";
    (<HTMLInputElement>document.getElementById("input")).value="";
    document.getElementById("next").onclick = next3;
}

//Changes label to match passwords
function next3(){
  var repass = (<HTMLInputElement>document.getElementById("input")).value;
  if(password != repass){
     alert("Passwords Don't Match!");
  }else{
     document.getElementById("label").innerHTML="Enter Your Contact Number!";
     (<HTMLInputElement>document.getElementById("input")).type = "tel";
     (<HTMLInputElement>document.getElementById("input")).value="";
     document.getElementById("next").onclick = next4;
  }
 }

 //Changes label to input vehicle number
 function next4(){
    document.body.style.background = "gray";
     document.getElementById("label").innerHTML="Enter your vehicle number!";
     (<HTMLInputElement>document.getElementById("input")).type = "number";
     (<HTMLInputElement>document.getElementById("input")).value="";
     document.getElementById("next").onclick = next5;
 }

 //Changes label to input vehicle Type
 function next5(){
     document.getElementById("label").innerHTML="What's Your Vehicle Type [Cycle/MotorCycle/FourWheeler] ?";
     (<HTMLInputElement>document.getElementById("input")).type = "text";
     (<HTMLInputElement>document.getElementById("input")).value="";
     document.getElementById("next").onclick = next6;
 }

 //Changes label to input Employee id
 function next6(){
     vehicleType = (<HTMLInputElement>document.getElementById("input")).value;
     document.getElementById("label").innerHTML = "Enter Your Employee Id!";
     (<HTMLInputElement>document.getElementById("input")).type = "id";
     (<HTMLInputElement>document.getElementById("input")).value="";
     document.getElementById("next").onclick = next7;
 }

 //Changes label to input pass price
 function next7(){
     document.body.style.background = "DarkSeaGreen";
     if("Cycle" == vehicleType){
        document.getElementById("label").innerHTML="Choose Your Pass[5 Daily/100 Monthly/500 Yearly]!";
     }else if("MotorCycle" == vehicleType){
        document.getElementById("label").innerHTML="Choose Your Pass[10 Daily/200 Monthly/1000 Yearly]!";
     }else{
        document.getElementById("label").innerHTML="Choose Your Pass[20 Daily/500 Monthly/3500 Yearly]!";
     }

     (<HTMLInputElement>document.getElementById("input")).type = "text";
     (<HTMLInputElement>document.getElementById("input")).value="";
     document.getElementById("next").onclick = next8;
 }

 //Changes label to show final pass price
 function next8(){
     let pass:number = parseInt((<HTMLInputElement>document.getElementById("input")).value);
     document.getElementById("field").innerHTML=" Your pass price is " + pass +"  !!!!!";
     document.getElementById("field").style.animation = "end 4s";
     document.body.style.background = "RosyBrown";
 }