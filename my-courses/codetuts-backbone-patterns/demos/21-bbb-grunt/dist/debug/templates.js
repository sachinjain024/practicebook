this['JST'] = this['JST'] || {};

this['JST']['app/templates/layouts/main.html'] = function(obj){
var __p='';var print=function(){__p+=Array.prototype.join.call(arguments, '')};
with(obj||{}){
__p+='<h1> User Tracker </h1>\n<div id="form"></div>\n<div id="users"></div>\n';
}
return __p;
};

this['JST']['app/templates/users/collection.html'] = function(obj){
var __p='';var print=function(){__p+=Array.prototype.join.call(arguments, '')};
with(obj||{}){
__p+='<h1>'+
( count )+
' Users</h1>\n';
}
return __p;
};

this['JST']['app/templates/users/form.html'] = function(obj){
var __p='';var print=function(){__p+=Array.prototype.join.call(arguments, '')};
with(obj||{}){
__p+='<input type="text" id="name" />\n<button> Add </button>\n';
}
return __p;
};

this['JST']['app/templates/users/model.html'] = function(obj){
var __p='';var print=function(){__p+=Array.prototype.join.call(arguments, '')};
with(obj||{}){
__p+='<h2>'+
( name )+
'</h2>\n';
}
return __p;
};