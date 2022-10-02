function guardarInformacion() {

    $("#resultado").empty();

    let myData = { name: $("#name").val(), description: $("#description").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://129.213.160.180:81/api/Category/save',
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
            url: "http://129.213.160.180:81/api/Category/all",
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
    myTable += "<caption>Info Categorias</caption><tr><th>Nombre</th><th>Descripcion</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";


        // myTable+="<td><button onclick='borrarCategoria("+items[i].description+")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}


/*

function editarInformacion() {
    let myData = {
        description: $("#description").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Category/",
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

function borrarElemento(descriptionElemento) {
    let myData = { description: descriptionElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Category/",
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
    let codigo = $("#description").val();

    $.ajax({
        url: "http://localhost:8080/api/Category//" +
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