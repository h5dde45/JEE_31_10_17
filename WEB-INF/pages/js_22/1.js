// var block = document.getElementById("one");
// block.onclick = function () {
//     this.style.background = "green";
//     // this.onclick=null;
// };
//
// block.ondblclick=function () {
//     this.style.background="red";
// };
//
// block.oncontextmenu=function () {
//     this.style.background="black";
//     return false;
// };
// document.oncontextmenu=function () {
//     return false;
// }
//
// block.onmouseenter=function () {
//     this.style.background="yellow";
//    console.log("mouse....")
// };
//
// block.onmouseleave=function () {
//     this.style.background="gold";
//    // console.log("mouse....")
// };
// var a = 0;
//
// block.onmousemove = function () {
//     ++a;
//     this.style.width = 100 + a + "px";
//     // console.log("mouse....")
// };
// block.onmousedown = function (event) {
//     this.style.background = "red";
//     console.log("button: "+event.button);
//     console.log("which: "+event.which);
// };
// block.onmouseup = function (event) {
//     this.style.background = "red";
// console.log("button: "+event.button);
// console.log("which: "+event.which);
// };
document.onmousemove=function () {
    document.getElementsByTagName("body")
    [0].insertAdjacentHTML("beforeEnd",'<img ' +
        'src="https://cdn4.iconfinder.com/data/icons/'+
        'small-n-flat/24/cat-alt-48.png" ' +
        'id="cat">');

    var cat = document.getElementById("cat");
    cat.style.position = "fixed";

    document.onmousemove = function (event) {
        cat.style.left=event.clientX+15+"px";
        cat.style.top=event.clientY+15+"px";
    }

}


