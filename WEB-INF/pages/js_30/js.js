var number = Math.floor(Math.random() * 10) + 1;
console.log(number);
var count = 3;

document.getElementById("check")
    .onclick = function () {
    if (count > 0) {
        var value = document.getElementById("myNum").value;
        value = parseInt(value);
        var out = document.getElementById("out");

        if (value > number) {
            out.innerHTML = "It's a lot";
        } else if (value < number) {
            out.innerHTML = "It is a little";
        } else {
            out.innerHTML = "ok";
            return;
        }
        document.getElementById("count").innerHTML =
            "There were " + count + " attempts";
        count--;
    } else {
        alert("Game over");
        location.reload();
    }
}