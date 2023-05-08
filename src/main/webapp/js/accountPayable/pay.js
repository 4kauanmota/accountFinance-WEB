const checkUpdate = (element) =>{
  let parent = element.parentNode.parentNode.parentNode;
  let p = parent.lastElementChild;

  if(p.children[0] == undefined){
    let button = document.createElement('button');
    button.classList.add('pointer');
    button.setAttribute('type', 'submit');
    button.innerHTML = '<lord-icon src="https://cdn.lordicon.com/wfadduyp.json" trigger="hover" colors="primary:#fff" class="updateIcon"></lord-icon>';
  
    p.appendChild(button);
    parent.appendChild(p);
  }
}

const checkPay = (element) =>{
  let parent = element.parentNode.parentNode;
  let p = parent.children[5];
  let updated = false;

  if(element.value != ""){
    if(p.children[0] != undefined) {
      p.children[0].remove();
      updated = true;
    }

    let input = document.createElement('input');
    input.setAttribute('type', 'submit');
    input.setAttribute('value', 'Pay');
    input.classList.add('pointer');
    updated ? input.classList.add('updated') : input.classList.add('notUpdated');
  
    p.appendChild(input);
    parent.appendChild(p);
  }
  else if(p.children[0].classList.contains('updated')){
    p.children[0].remove();

    let button = document.createElement('button');
    button.classList.add('pointer');
    button.setAttribute('type', 'submit');
    button.innerHTML = '<lord-icon src="https://cdn.lordicon.com/wfadduyp.json" trigger="hover" colors="primary:#fff" class="updateIcon"></lord-icon>';
  
    p.appendChild(button);
    parent.appendChild(p);
  }
  else{
    p.children[0].remove();
  }
}