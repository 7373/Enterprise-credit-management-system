//添加string的trim方法
String.prototype.trim=function() {
    return this.replace(/(^\s*)|(\s*$)/g,'');
};