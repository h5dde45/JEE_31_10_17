window.onload = function () {
    var todoList = [];

    document.getElementById("add").onclick = function () {
        var d = document.getElementById("in").value;
        var temp = {};
        temp.todo = d;
        temp.check = false;

        var length = todoList.length;
        todoList[length] = temp;

        console.log(todoList);
        out();
    }

    function out() {
        var out = "";
        for (var key in todoList) {
            out += todoList[key].todo + "<br>";
            if(todoList[key].check==true){

            }
        }
        document.getElementById("out").innerHTML = out;
    }
}