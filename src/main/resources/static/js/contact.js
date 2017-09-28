function collectdata() {

    var objectOfInputData = {};


    objectOfInputData.name = document.getElementById("name").value;
    objectOfInputData.email = document.getElementById("email").value;
    objectOfInputData.subject = document.getElementById("subject").value;
    objectOfInputData.message= document.getElementById("message").value;

    senddata(objectOfInputData);

}
function senddata(ContactParser) {


    jQuery.post("contact/submitContact", ContactParser, function (res) {
        alert(res);
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

