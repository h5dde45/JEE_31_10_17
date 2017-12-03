// function one() {
//     return 5;
// }
// console.log(6 + one());
function sum(a, b) {
    alert(a + b);
    // return a + b;
}
// var result = sum(3, 5);
document.getElementById("b").onclick = function () {
    sum(6, 7);
}
// p.innerHTML = result;
// console.log(sum(22, 3));
var a=function () {
    alert("+++++")
}
a();