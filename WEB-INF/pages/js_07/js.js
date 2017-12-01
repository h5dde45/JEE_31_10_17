function f1() {
    var n1 = document.getElementById("n1").value;
    n1 = parseInt(n1);
    var n2 = document.getElementById("n2").value;
    n2 = parseInt(n2);
    var p = document.getElementById("out");

    if (n1 == n2) {
        p.innerHTML = "n1 = n2";
    }else if (n1 > n2) {
        p.innerHTML = "n1 > n2";
    }else  {
        p.innerHTML = "n1 < n2";
    }


}