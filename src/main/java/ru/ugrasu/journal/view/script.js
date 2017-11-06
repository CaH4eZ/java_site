$( document ).ready(function() {

    $('#findRequest').click(function(){
        var id = $('#findIdText').val();

        $.ajax({
            url:'http://localhost:8080/user/findById/' + id,
            type:'GET',
            success: function(data){
                console.log(data);
                $('#idDiv').html('');
                $('#idDiv').html(data.name);
            },
            error: function(xhr,textStatus){
                if(xhr.status=="500")
                    $('#idDiv').html("<H1 style='color:red'>Ошибка на сервере</H1>");
                else $('#idDiv').html("<H1 style='color:red'>Ничего не найдено</H1>");
            }

        })
    })

    $('#saveRequest').click(function(){
        var data = $("#saveForm").serialize();

        $.ajax({
            url:'http://localhost:8080/user/save',
            type:'POST',
            data: data,
            success: function(data){
                console.log(data);
                $('#saveDiv').html(data.id + " " + data.name + " " + data.group + " " + data.role + " ");
            },
            error: function(xhr,textStatus){
                if(xhr.status=="500")
                    $('#saveDiv').html("<H1 style='color:red'>Ошибка на сервере</H1>");
                else $('#saveDiv').html("<H1 style='color:red'>Ничего не найдено</H1>");
            }
        })
    })

    $('#deleteRequest').click(function(){
        var id = $('#deleteIdText').val();

        $.ajax({
            url:'http://localhost:8080/user/deleteById/' + id,
            type:'GET',
            success: $('#deleteDiv').html("Удален с id = " + id),
            error: function(xhr,textStatus){
                if(xhr.status=="500")
                    $('#deleteDiv').html("<H1 style='color:red'>Ошибка на сервере</H1>");
                else $('#deleteDiv').html("<H1 style='color:red'>Ничего не найдено</H1>");
            }

        })
    })

});
console.log( );