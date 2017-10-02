function collectdata() {

    var objectOfInputData = {};


    objectOfInputData.name = document.getElementById("name").value;
    objectOfInputData.email = document.getElementById("email").value;
    objectOfInputData.subject = document.getElementById("subject").value;
    objectOfInputData.message= document.getElementById("message").value;

    jQuery.post("contact/submitContact", ContactParser, function (res) {
        console.log(res);
        aftervalidate(res);
    });
}

function aftervalidate(res) {

    if (res[0] == "success") {
        var inputs= document.querySelectorAll("#contact-form input");
        for(var docElement in inputs){
        docElement.setAttribute("disabled","disabled");
        docElement.style="background-color:grey";
         }
//        var name=document.getElementById("name");
//        var email=document.getElementById("email");
//        var subject=document.getElementById("subject");
//        var message=document.getElementById("message");
        var button=document.getElementById("contact-submit");
//        name.setAttribute("disabled","disabled");
//        email.setAttribute("disabled","disabled");
//        subject.setAttribute("disabled","disabled");
//        message.setAttribute("disabled","disabled");
//        button.setAttribute("disabled","disabled");
        button.setAttribute("class","alert alert-success");
        button.value=res[1];
    }


     if (res[0] == "fail") {
            var errorDiv= document.getElementById("error");
            var errorPlace= document.querySelector("#error strong");
            errorPlace.parentElement.setAttribute("style","display:block");
            errorPlace.innerText=res[1];
        }
}

