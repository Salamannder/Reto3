 $.get("/user" ,function (data){
    console.log(data);
    $("#user").html(data.name);
    $(".unauthenticated").hide();
    $(".authenticated").show();
    }
);