var block = document.getElementById("test");

var left = 0;
var top1 = 0;

document.onkeydown = function (event) {
    console.log(event);
    if (event.key == "ArrowRight") {
        left+=10;
        block.style.left = left + "px";
    }
    if (event.key == "ArrowDown") {
        top1+=10;
        block.style.top = top1 + "px";
    }
    if (event.key == "ArrowLeft") {
        left-=10;
        block.style.left = left + "px";
    }
    if (event.key == "ArrowUp") {
        top1-=10;
        block.style.top = top1 + "px";
    }

}