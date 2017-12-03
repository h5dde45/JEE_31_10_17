var shift = 0;
var timer;
var test = document.getElementById("test");
// move();


function move() {
    test.style.marginLeft = shift + "px";
    shift += 11;
    timer = setTimeout(move, 100);
}
// var timer = setInterval(move, 100);

document.getElementById("stop")
    .onclick = function () {
    clearInterval(timer);
}

// document.getElementById("start")
//     .onclick = function () {
//     timer = setInterval(move, 100);
// };
// setTimeout(move, 3000);
var a = 5;
f();
function f() {
    document.getElementById("out").innerHTML = a;
    if (a == 0) {
        clearInterval(timer);
        // alert("===");
        move();
    }else {
        timer = setTimeout(f, 1000);
    }
    --a;
}