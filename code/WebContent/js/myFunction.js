function addToobj(name, data, array){
	var obj = {}
	obj[name]=data;
	array.push(obj);
	return array;
}