function checknumber(Obj){//检查输入是否为数字
	var ze = /^[0-9]+.?[0-9]*$/;
	if(ze.test(Obj)){
		return true;
	}
	return false;
}
function checknull(Obj){//检查输入是否为空
	var ze = /^\s*$/;
	if(ze.test(Obj)){
		return true;
	}
	return false;
}
function checkip(Obj){//检查输出是否为ip地址
	var ze = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$"
    if(Obj.match(ze)){
    	return true;
    }
    return false;
}
function secondsTotime(s) { 
	var day = Math.floor( s/ (24*3600) );
	var hour = Math.floor( (s - day*24*3600) / 3600); 
	var minute = Math.floor( (s - day*24*3600 - hour*3600) /60 ); 
	var second = Math.floor( s - day*24*3600 - hour*3600 - minute*60 ); 
	return day + "天"  + hour + "时" + minute + "分" + second + "秒"; 
}