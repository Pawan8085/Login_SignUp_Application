function myFunction(){
	let bool=false
	if(!bool){
		var str=document.getElementById('username').value;
	}
		
	if(str.length==1){
		bool=true
		let isNull = document.getElementById("messageSection")
		if(isNull !=null)
		document.getElementById("messageSection").innerText=""
	}	
		
}
alert("invoked")