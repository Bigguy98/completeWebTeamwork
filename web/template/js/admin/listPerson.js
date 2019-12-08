var pageSize = 10;
var currentPage = 1;
var totalPage ;

$(document).ready(function () {
    getTotalPage();
    getPersonByPage();
});

function getTotalPage(){
    $.ajax({
        url : "/admin/countPerson",
        type: 'GET',
        success: function (data) {
            totalPage = Math.ceil(data/pageSize);
            console.log("total person: "+ data);  
            console.log("total page: "+totalPage);
        }
    });
}

function getPersonByPage(){
    $('#table-tbody').empty();
    $.ajax({
        url : "/admin/getPersonPage",
        type: 'GET',
        data:{
            "pageSize" : pageSize,
            "currentPage" : currentPage
        },
        success: function (data) {
            showPerson(JSON.parse(data));
        },
        error: function () {
            alert("getPersonByPage fail !!! ");
        }
    });
}
function showPerson(data){
    data.forEach(function (customer) {
        console.log(customer.name);
        var cover =document.createElement("tr");
        cover.setAttribute("class","table-content");
        
        var column_1 = document.createElement("td");
        column_1.setAttribute("class","column-1");
        column_1.innerHTML = customer.id;
        
        var column_2 = document.createElement("td");
        column_2.setAttribute("class","column-2");
        column_2.innerHTML = customer.name;
        
        var column_3 = document.createElement("td");
        column_3.setAttribute("class","column-3");
        column_3.innerHTML = customer.age;
        
        var column_4 = document.createElement("td");
        column_4.setAttribute("class","column-4");
        column_4.innerHTML = customer.address;
        
        var column_5 = document.createElement("td");
        column_5.setAttribute("class","column-5");
        column_5.innerHTML = customer.role;
        
        var column_6 = document.createElement("td");
        column_6.setAttribute("class","column-6");
        
//        var a_delete = document.createElement("a");
//        a_delete.setAttribute("href","#");
//        a_delete.onclick = deletePerson(customer.id);
//        a_delete.innerHTML = "Delete";
        
        var a_edit = document.createElement("a");
        a_edit.setAttribute("href","/admin/editPerson?idPerson="+customer.id);
        a_edit.innerHTML="Edit";
        
//        column_6.appendChild(a_delete);
      
        column_6.appendChild(a_edit);
        
        cover.appendChild(column_1);
        cover.appendChild(column_2);
        cover.appendChild(column_3);
        cover.appendChild(column_4);
        cover.appendChild(column_5);
        cover.appendChild(column_6);
        
        $('#table-tbody').append(cover);
        
    });
    check();
}
function first() {
    currentPage = 1;
    getItem();
}
function previous() {
    currentPage -= 1;
    getItem();
}

function next() {
    currentPage += 1;
    getItem();
}
function last() {
    currentPage = totalPage;
    getItem();
}
function check() {
    document.getElementById("first").disabled = currentPage === 1 ? true: false;
    document.getElementById("previous").disabled = (currentPage === 1) ? true: false;
    document.getElementById("next").disabled = (currentPage === totalPage) ? true: false;
    document.getElementById("last").disabled = (currentPage === totalPage) ? true: false;
}

//function deletePerson(id){
//    $.ajax({
//        url : "/admin/deletePerson",
//        type: 'POST',
//        data:{
//            "idPerson" : id
//        },
//        success: function (data, textStatus, jqXHR) {
//            alert("delete person success");
//            console.log(data);
//        },error: function (jqXHR, textStatus, errorThrown) {
//            alert("delete person fail");
//        }
//    });
//        
//}
