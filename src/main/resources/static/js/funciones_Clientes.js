function guardarInformacion() {

    $("#resultado").empty();

    let myData = { name: $("#name").val(), email: $("#email").val(), age: $("#age").val(), password: $("#password").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://129.213.160.180:81/api/Client/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta) {
            //console.log(respuesta);
            alert("Inserción exitosa");
            traerInformacion();
        },
        error: function(xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
            traerInformacion();
        }

    });
}

function traerInformacion() {
    $.ajax({
            url: "http://129.213.160.180:81/api/Client/all",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                pintarRespuestaCategoria(respuesta);
                traerInformacion();

            },
            error: function(xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);

            }


        }

    );
}


function pintarRespuestaCategoria(items) {

    $("#resultado").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<caption>Info Clientes</caption><tr><th>Codigo</th><th>Nombre</th><th>Email</th><th>Edad</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idClient + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        // myTable+="<td><button onclick='borrarCategoria("+items[i].id+")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}


/*

function editarInformacion() {
    let myData = {
        idClient: $("#idClient").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            //console.log(respuesta);
            alert("Actualizacion exitosa");
            traerInformacion();
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function borrarElemento(idElemento) {
    let myData = { idClient: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/",
        type: "DELETE",
        data: dataToSend,
        contentType: "application/json",
        datatype: "JSON",
        success: function(respuesta) {
            // console.log(respuesta);
            alert("Borrado exitoso");
            traerInformacion();
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}*/
/*
function consultarId() {
    let codigo = $("#id").val();

    $.ajax({
        url: "http://localhost:8080/api/Client//" +
            codigo,
        type: "GET",
        dataType: "json",
        success: function(respuesta) {
            pintarRespuesta(respuesta.items);
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
        },
    });
} 
*/