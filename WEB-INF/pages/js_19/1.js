var goods = {
    "2445": {
        "name": "banana",
        "cost": 33,
        "img": "https://cdn0.iconfinder.com/data/icons/" +
        "fruits/128/Banana.png",
        "available": "yes"
    },
    "2343": {
        "name": "tomato",
        "cost": 44,
        "img": "https://cdn0.iconfinder.com/data/icons/" +
        "fruits/128/Tomato.png",
        "available": "yes"
    },
    "2344": {
        "name": "apple",
        "cost": 55,
        "img": "https://cdn0.iconfinder.com/data/icons/" +
        "fruits/128/Apple.png",
        "available": "yes"
    }
};

console.log(goods);
var out = "";
for (var key in goods) {
    out += "Name: " + goods[key].name + "<br>";
    out += "Cost: " + goods[key].cost + "<br>";
    out += "Available: " + goods[key].available + "<br>";
    out += "<img src=\"" + goods[key].img + "\">";
    out+="<hr>"
}
document.getElementById('out').innerHTML = out;

