// function f1() {
//     var p6, p1;
//     p6 = document.getElementById('out');
//     p1 = document.getElementById('out1');
//
//     // for (var i = 1; i <= 100; i=i+3) {
//     //     p6.innerHTML += i + ' ';
//     // }
//     var i = 0;
//     while (i < 100) {
//         p6.innerHTML += i++ + ' ';
//     }
//     var j = 0;
//     do {
//         p1.innerHTML += j++ + ' ';
//     } while (j < 100);
// }

var m = [44, 33, 'hello'];
m[3] = 55;
m[4] = 88;
console.log(m);
// alert(m.length)


function masOut() {
    var p = document.getElementById('out');
    var str = '';
    for (var i = 0; i < m.length; i++) {
        str += i + ' =>  ' + m[i] + '<br>';
    }
    p.innerHTML = str;
}

masOut();

function p1() {
    var i=document.getElementById("in").value;
    m.push(i);
    masOut();
}

function p2() {
    m.pop();
    masOut();
}