document.onwheel = function (event) {
    console.log(event);
    if (event.deltaY > 0) {
        document.getElementById("line")
            .innerHTML = "down";
    } else {
        document.getElementById("line")
            .innerHTML = "up";
    }
    var speed = event.deltaY;
    speed = Math.abs(speed);
    if (speed < 3) {
        document.getElementById("speed")
            .innerHTML = "low speed";
    } else if (speed < 4) {
        document.getElementById("speed")
            .innerHTML = "middle speed";
    } else if (speed < 5) {
        document.getElementById("speed")
            .innerHTML = "high speed";
    } else {
        document.getElementById("speed")
            .innerHTML = "very high speed";
    }
}
var left = 290;
document.getElementById("test").onwheel
    = function (event) {
    var line = event.deltaY;
    left += line;
    document.getElementById("test2")
        .style.left = left + "px";
    return false;
}