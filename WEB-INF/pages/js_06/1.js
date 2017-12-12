function out() {
    var p=document.getElementById("out");

    // p6.innerHTML+=' <b>hello</b>';
    //
    // p6.insertAdjacentHTML('beforeBegin','Hi');
    // p6.insertAdjacentHTML('afterBegin','Hi ');
    // p6.insertAdjacentHTML('beforeEnd',' Hi');
    // p6.insertAdjacentHTML('afterEnd','Hi');
    p.outerHTML='<div class="one">hello</div>';
}