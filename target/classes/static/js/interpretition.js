function collectdata() {

    var objectOfInputData = {};


    objectOfInputData.name = document.getElementById("name").value;
    objectOfInputData.email = document.getElementById("email").value;
    objectOfInputData.subject = document.getElementById("firstLanguage").value;
    objectOfInputData.message= document.getElementById("secondLanguage").value;
    objectOfInputData.message= document.getElementById("message").value;

    jQuery.post("interpretition/order", objectOfInputData, function (res) {
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
        var button=document.getElementById("contact-submit");
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


  $(document).ready(function() {
      $("#js-upload-submit").on("click", uploadFile);
    });

    /**
     * Upload the file sending it via Ajax at the Spring Boot server.
     */
    function uploadFile() {
    $("contact-submit").prop('disabled', true);
    var inputFile= new FormData();
    jQuery.each(jQuery('#js-upload-files')[0].files, function(i, file) {
        inputFile.append('fileToUpload', file);
    });
      $.ajax({
        url: "interpretition/uploadFile",
        type: "POST",
        data: inputFile,
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
          // Handle upload success
          $("#upload-file-message").text("File succesfully uploaded");
        },
        error: function () {
          // Handle upload error
          $("#upload-file-message").text(
              "File not uploaded (perhaps it's too much big)");
        }
      });
    }

function($) {
    'use strict';

    // UPLOAD CLASS DEFINITION
    // ======================

    var dropZone = document.getElementById('drop-zone');
    var uploadForm = document.getElementById('js-upload-form');

    var startUpload = function(files) {
        console.log(files)
    }

    uploadForm.addEventListener('submit', function(e) {
        var uploadFiles = document.getElementById('js-upload-files').files;
        e.preventDefault()

        startUpload(uploadFiles)
    })

    dropZone.ondrop = function(e) {
        e.preventDefault();
        this.className = 'upload-drop-zone';

        startUpload(e.dataTransfer.files)
    }

    dropZone.ondragover = function() {
        this.className = 'upload-drop-zone drop';
        return false;
    }

    dropZone.ondragleave = function() {
        this.className = 'upload-drop-zone';
        return false;
    }

}(jQuery);

