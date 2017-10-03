function collectdata() {

    var objectOfInputData = {};


    objectOfInputData.name = document.getElementById("name").value;
    objectOfInputData.email = document.getElementById("email").value;
    objectOfInputData.subject = document.getElementById("subject").value;
    objectOfInputData.message= document.getElementById("message").value;

    jQuery.post("contact/submitContact", objectOfInputData, function (res) {
        console.log(res);
        aftervalidate(res);
    });
}

function aftervalidate(res) {

if (res[0] == "success") {
        var inputs= document.querySelectorAll("#contact-form input");
        $(".form-control, #contact-submit").attr("disabled", "disabled")
        document.getElementById("submit").setAttribute("style","text-align:center");
        $(".form-control").hide();
        var button=document.getElementById("contact-submit");
        var responsePlace=document.getElementById("responsePlace");
        responsePlace.innerText="Thanks for contacting us. We will reach you out soon!"
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

