$(document).ready(function (){
    
});

function addPerson(){
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/admin/addProduct",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log(data);
                alert("add Product success");
                location.pathname = "/admin/listProduct";
            },
            error: function (e) {

                alert("add Product fail");
            }
        });
}