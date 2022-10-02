function guardarInformacion() {

    $("#resultado").empty();

    let myData = { startDate: $("#startDate").val(), devolutionDate: $("#devolutionDate").val(), partyroom: { id: $("#partyroomId").val() }, client: { idClient: $("#clientId").val() }, score: $("#score").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://129.213.160.180:81/api/Reservation/save',
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
            url: "http://129.213.160.180:81/api/Reservation/all",
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
    myTable += "<caption>Info Reservas</caption><tr><th>Id Reservacion</th><th>Fecha de inicio</th><th>Fecha de Devolucion</th><th>Estado Reserva</th><th>Salon</th><th>Id Cliente</th><th>Cliente</th><th>Correo Cliente</th><th>Calificacion</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].startDate + "</td>";
        myTable += "<td>" + items[i].devolutionDate + "</td>";
        myTable += "<td>" + items[i].status + "</td>";
        myTable += "<td>" + items[i].partyroom.name + "</td>";
        myTable += "<td>" + items[i].client.idClient + "</td>"
        myTable += "<td>" + items[i].client.name + "</td>"
        myTable += "<td>" + items[i].client.email + "</td>"
        myTable += "<td>" + items[i].score + "</td>";;
        // myTable+="<td><button onclick='borrarCategoria("+items[i].id+")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}


/*

function editarInformacion() {
    let myData = {
        idReservation: $("#idReservation").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        status: $("#status").val(),
        password: $("#password").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/",
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
    let myData = { idReservation: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/",
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
        url: "http://localhost:8080/api/Reservation//" +
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