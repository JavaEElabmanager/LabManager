function checknumber(Obj){
	var ze = /^[0-9]+.?[0-9]*$/;
	if(ze.test(Obj)){
		return true;
	}
	return false;
}
function checknull(Obj){
	var ze = /^\s*$/;
	if(ze.test(Obj)){
		return true;
	}
	return false;
}
