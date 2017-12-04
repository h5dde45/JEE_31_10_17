var value = "";

document.getElementById("in")
    .onkeypress = function (event) {
    console.log(event);
    var randomArbitrary = getRandomArbitrary(65,122);
    var pass = String.fromCharCode(randomArbitrary);
    this.value+=pass;
    value += event.key;

    console.log(event.key);
    console.log(pass);
    console.log(event.charCode);
    console.log(randomArbitrary);
    console.log(value);

    return false;
}

function getRandomArbitrary(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}
