
function myCalculate(){
	var bal = parseFloat(document.getElementById("balance").value);
	var withdraw = parseFloat(document.getElementById("withdraw").value);
	var add = parseFloat(document.getElementById("add").value);
	
	if(withdraw < 0){
		withdraw = withdraw * -1;
	}
	
	if(add < 0){
		add = add * -1;
	}
	
	if((bal - withdraw + add)<0){
		bal = 0;
		alert("you cannot withdraw more then you have!!!");
	}
	else{
		bal = bal - withdraw + add;
	}
	
	document.getElementById("withdraw").value = 0;
	document.getElementById("add").value = 0;
	alert("Your new balance = "+bal);
	document.getElementById("balance").value = bal;
}

