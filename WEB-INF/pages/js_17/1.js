// var m=[23,45,'dfg'];
//
// console.log(m[1]);
// var m = {
//     "one": 12,
//     "two": "wold",
//     "prim": 2000,
//     "double key": 789
// };
// m.two = 44;
// console.log(m['double key']);
// console.log(m.two);
// console.log(m.one);
// var ppp = "one";
// console.log(m[ppp]);
//
// var out = document.getElementById('out');
// for (var k in m) {
//     out.innerHTML += k + " =>  " + m[k]+"<br>";
// }

var man={
    "name":"newName",
    "age": 45,
    "id":"4356y45tgr",
    "sex": "male"
};
var man2={
    "name":"newName",
    "age": 45,
    "id":"4356y45tgr",
    "sex": "male",
    "year": function () {
        return 2017-this.age;
    }
};
var m={
    "mas":[4,5,6,76,4],
    "sum":function () {
      var sum=0;
      for (var i=0;i<this.mas.length;i++){
          sum+=this.mas[i];
      }
      return sum;
    }
}


// console.log(man2.year());
console.log(m.sum());
// console.log(man.name);

