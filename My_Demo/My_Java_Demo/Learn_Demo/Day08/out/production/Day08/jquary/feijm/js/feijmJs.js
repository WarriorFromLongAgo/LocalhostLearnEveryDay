// 封装方法，根据id来获取元素对象
// function getById(id) {
//     var idObj = document.getElementById(id);
//     return idObj;
// }

function $(id) {
    var idObj = document.getElementById(id);
    return idObj;
}