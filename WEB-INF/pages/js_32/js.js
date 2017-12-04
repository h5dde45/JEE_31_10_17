window.onload = function () {
        if(localStorage.getItem("bgColor")!=null){
            document.getElementsByTagName("body")[0].style.background =
                localStorage.getItem("bgColor");
        }

    document.getElementById("green").onclick = function () {
        // document.body.style.background = "green";
        document.getElementsByTagName("body")[0].style.background = "green";
        localStorage.setItem("bgColor","green");
    }
    document.getElementById("red").onclick = function () {
        // document.body.style.background = "red";
        document.getElementsByTagName("body")[0].style.background = "red";
        localStorage.setItem("bgColor","red");
    }
}

