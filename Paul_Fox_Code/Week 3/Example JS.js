

document.querySelector("#list").addEventListener('click', 
(evt) => {

    evt.target.classList.toggle("selected");
}, false);

// document.selectElementById('#draggable').addEventListener('dragstart', 
//     (evt)=> {
//         evt.dataTransfer.setData("text", evt.target.innerText);

//     });

// docuement.querySelector("#finish").addEventListener('dragover', 
//     (evt)=> {
//         evt.preventDefault();
//     });

// docuement.querySelector("#finish").addEventListener('drop', 
// (evt)=> {
//     evt.preventDefault();
//     let data = evt.dataTransfer.getData("text");
//     let old = docuement.querySelector("#draggable")
//     let p = old.parentNode;
//     p.removeChild(old);

//     let newP = docuement.createElement('p');
//     newP.id = 'draggable';
//     newP.innerText = data;
//     newP.draggable = true;
//     document.querySelector("#finish").appendChild(newP);
// });

document.querySelector("#delete").addEventListener('click', 
(evt)=> {

    var toDelete = document.querySelector(".selected");
    var parent = toDelete.parentNode;
    toDelete.classList.add("deleting");
    setTimeout(parent.removeChild(toDelete), 3000);

});

document.querySelector('#new-value').addEventListener('keypress', 
(evt) => {

    var code = evt.keyCode;
    console.log(code);
    if(code === 13){

        var li = document.createElement("li");
        var inputValue = document.querySelector("#new-value").value;
        li.classList.add("list-item");
        var t = document.createTextNode(inputValue);
        li.appendChild(t);
        document.querySelector('#list').appendChild(li);
        console.log(document.querySelector('#list'));


    }

})