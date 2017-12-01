var  prNum, tempOut;
prNum = Math.floor((Math.random() * 10) + 1);
tempOut = document.getElementById("temp-out");
// tempOut.innerHTML = prNum;
console.log(prNum);

function f1() {
    var num,  out;
    num = document.getElementById('myNum').value;
    out = document.getElementById("out");

    if (prNum == num) {
        out.innerHTML = "the answer is correct";
    }else if(prNum > num){
        out.innerHTML = "the number is less than the target";
    }else {
        out.innerHTML = "the number is more than the target";
    }
}