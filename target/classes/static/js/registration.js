function onsub() {  // a form submitja esetén fut le. Ez a függvény kezeli a többi függvényt.

    if (validateselects()) { //ez a függvény validáltatja a selecteket.
       collectdata(); //meghívja a függvényt ami összeállítja az adatokat. 
       
       return false;
    } else {return false };
}


function validateselects() {
    var age = document.getElementById("age");
    var firstLanguage = document.getElementById("fistLanguage");
    var secondLanguage = document.getElementById("secondLanguage");
    var education = document.getElementById("education"); // megkeresem a selecteket
    var label = document.createElement("label");
    var firstEmail = document.getElementById("firstEmail");
    var lastEmail = document.getElementById("lastEmail");
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var email= firstEmail.value.replace(/ /gi, "")+ "@" + lastEmail.value.replace(/ /gi, "");
    var currentlabel = document.querySelector(".error ~ label"); /*ha nem választotta ki az előzőben valamelyik
    selectet, akkor kap egy error class-t és egy labelt, a class melletti elem egy label és
     ezzel a szelektorral kiválasztom label elemet.*/


    if (currentlabel != null) { // megvizsgálom, hogy van-e egyáltalán label elem
        currentlabel.parentNode.removeChild(currentlabel); // eltávolítom az eddigi label elemet
        education.classList.remove("error");
        firstLanguage.classList.remove("error");
        secondLanguage.classList.remove("error");
        age.classList.remove("error");
        lastEmail.classList.remove("error");
        firstEmail.classList.remove("error");
    }

    if(re.test(email)==false) { // e-mail címet teszteli
        label.setAttribute("for", "lastEmail");
        label.innerHTML = "<br/> Helytelen e-mail cím! <br/>"
        lastEmail.parentNode.appendChild(label);
        lastEmail.focus();
        lastEmail.classList.add("error");
        return false;
    }
    if(education.value == "default") {
        label.setAttribute("for", "education");
        label.innerHTML = "<br/> Nem választottál ki képzettséget! <br/>";
        education.parentNode.appendChild(label);  
        education.classList.add("error"); /* ha nem válaszott ki képzést akkor kap egy error classt és egy label
        ami kiírja, hogy miért hibás*/
        return false;
    }
    if (firstLanguage.value == "default") {
        label.setAttribute("for", "firstLanguage");
        label.innerHTML = "<br/> Nem választottál ki első nyelvet! <br/>";
        firstLanguage.parentNode.appendChild(label);
        firstLanguage.classList.add("error");
        return false;
    }
    if (secondLanguage.value == "default") {
        label.setAttribute("for", "secondLanguage");
        label.innerHTML = "<br/> Nem választottál ki második nyelvet! <br/>";
        firstLanguage.parentNode.appendChild(label);
        firstLanguage.classList.add("error");
        return false;
    }
    if (age.value == "default") {
        label.setAttribute("for", "age");
        label.innerHTML = "<br/> Nem választottál ki kort! <br/>";
        age.parentNode.appendChild(label);
        age.classList.add("error");
        return false;
    }    else {
        return true;
    }
}



function collectdata() {

    var firstNameInput = document.getElementById("firstName").value;
    var lastNameinput = document.getElementById("lastName").value;
    var emailchecked = document.getElementById("firstEmail").value.replace(/ /gi, "")+ "@"
        + document.getElementById("lastEmail").value.replace(/ /gi, "");
    var educationinput = document.getElementById("education").value;
    var firstLanguage = document.getElementById("firstLanguage").value;
    var secondLanguage = document.getElementById("secondLanguage").value;
    var ageinput = document.getElementById("age").value;
    var newsLetterinput = document.getElementById("newsLetter");
    var phoneInput= document.getElementById("phone").value;


    var objectOfInputData = {};


    objectOfInputData.firstName = firstNameInput.replace(/ /gi, "");
    objectOfInputData.lastName = lastNameinput.replace(/ /gi, "");
    objectOfInputData.email = emailchecked;
    objectOfInputData.education = educationinput;
    objectOfInputData.firstLanguage = firstLanguage;
    objectOfInputData.secondLanguage = secondLanguage;
    objectOfInputData.age = ageinput;
   

    if (newsLetterinput.checked) {
        objectOfInputData.newsLetter = "on";
    }
    if (phoneInput != "") {
        objectOfInputData.phone = phoneInput;
    }

    senddata(objectOfInputData);

}
function senddata(objectOfInputData) {
    console.log(objectOfInputData);
    $.post("", objectOfInputData, function (res) {
        aftervalidate(res);
    });
}

function aftervalidate(res) {

    if (res.success==false) {
        submit.value = "Sikertelen Regisztráció";
        return;
    }


    if (res.success == true) {
       document.getElementById("contact-form").setAttribute()
        submit.value = "Sikeres Regisztráció";
    }
}

