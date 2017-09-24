function onsub() {  // a form submitja esetén fut le. Ez a függvény kezeli a többi függvényt.

    //ez a függvény validáltatja a selecteket.
        collectdata(); //meghívja a függvényt ami összeállítja az adatokat.
        return false;
}


function validateselects() {
    var name = document.getElementById("name");
    var subject = document.getElementById("subject");
    var message = document.getElementById("message");
    var label = document.createElement("label");
    var email = document.getElementById("firstEmail");
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var currentlabel = document.querySelector(".error ~ label");
    /*ha nem választotta ki az előzőben valamelyik
     selectet, akkor kap egy error class-t és egy labelt, a class melletti elem egy label és
     ezzel a szelektorral kiválasztom label elemet.*/


    if (re.test(email) == false) { // e-mail címet teszteli
        label.setAttribute("for", "lastEmail");
        label.innerHTML = "<br/> Helytelen e-mail cím! <br/>"
        lastEmail.parentNode.appendChild(label);
        lastEmail.focus();
        lastEmail.classList.add("error");
        return false;
    }
    alert("eljut idáig");
    return true;
}


function collectdata() {

    var objectOfInputData = {};


    objectOfInputData.name = document.getElementById("name");
    objectOfInputData.subject = document.getElementById("subject");
    objectOfInputData.email = document.getElementById("message");
    objectOfInputData.message= document.getElementById("email");

    // if (newsLetterinput.checked) {
    //     objectOfInputData.newsLetter = "on";
    // }
    // if (phoneInput != "") {
    //     objectOfInputData.phone = phoneInput;
    // }

    senddata(objectOfInputData);

}
function senddata(objectOfInputData) {


    jQuery.post( "http://localhost:8080/contact/submitContact",
        function( objectOfInputData ) {
            alert( "Data Loaded: " + data );
        });
}

function aftervalidate(res) {

    if (res.success == false) {
        submit.value = "Sikertelen Regisztráció";
        return;
    }


    if (res.success == true) {
        var firstNameinput = document.getElementById("firstName");
        var lastNameinput = document.getElementById("lastName");
        var educationinput = document.getElementById("education");
        var english = document.getElementById("englishLevel");
        var ageinput = document.getElementById("age");
        var newsLetterinput = document.getElementById("newsLetter");
        var submit = document.getElementById("submit");
        var phone = document.getElementById("phone");
        var firstEmail = document.getElementById("firstEmail");
        var lastEmail = document.getElementById("lastEmail");

        phone.setAttribute("disabled", "disabled");
        firstEmail.setAttribute("disabled", "disabled");
        lastEmail.setAttribute("disabled", "disabled");
        firstNameinput.setAttribute("disabled", "disabled");
        lastNameinput.setAttribute("disabled", "disabled");
        educationinput.setAttribute("disabled", "disabled");
        english.setAttribute("disabled", "disabled");
        ageinput.setAttribute("disabled", "disabled");
        newsLetterinput.setAttribute("disabled", "disabled");
        submit.setAttribute("disabled", "disabled");
        submit.classList.add("success");
        submit.value = "Sikeres Regisztráció";
    }
}

