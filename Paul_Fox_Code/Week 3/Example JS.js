var list = document.querySelector('ul');
list.addEventListener('click', (evt)=>{
    if(evt.target.tagName === 'LI') {

        ev.target.classList.toggle('selected');

    }
});

document.querySelector('#draggable').addEventListener('dragstart', 
    (evt)=> {
        evt.dataTransfer.setData("text", evt.target.innerText);

    });

docuement.querySelector("#finish").addEventListener('dragover', 
    (evt)=> {
        evt.preventDefault();
    });

docuement.querySelector("#finish").addEventListener('drop', 
(evt)=> {
    evt.preventDefault();
    let data = evt.dataTransfer.getData("text");
    let old = docuement.querySelector("#draggable")
    let p = old.parentNode;
    p.removeChild(old);

    let newP = docuement.createElement('p');
    newP.id = 'draggable';
    newP.innerText = data;
    newP.draggable = true;
    document.querySelector("#finish").appendChild(newP);
});