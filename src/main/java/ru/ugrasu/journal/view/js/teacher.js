$( document ).ready(function() {
    $('.datepicker').pickadate({
        selectMonth: true,
        selectYears: 5,
        today: 'Сегодня',
        clear: 'Очистить',
        close: 'OK',
        closeOnSelect: false
    });

    //Обновление предметов
    $.ajax({
        url:'http://localhost:8080/teacher/refrashSubject',
        type:'GET',
        success: function(recieved){

            //Удаление дочерних (jQuery)
            $('#select-subject').empty();

            var out = '<optgroup label="Предметы">';

            recieved.forEach(function(item, i, arr) {
               out += '<option value=' + item.id + '>' + item.name + '</option>';
            });

            out += '</optgroup>';

            $('#select-subject').append(out);
            
            //Обновление material_select
            $('select').material_select();
        },
        error: function(xhr,textStatus){
            console.log(textStatus);
        }
    });

    //Обновление групп 
    $.ajax({
        url:'http://localhost:8080/teacher/refrashStudyGroup',
        type:'GET',
        success: function(recieved){

            //Удаление дочерних (jQuery)
            $('#select-group').empty();

            var out = '<optgroup label="Группы">';

            recieved.forEach(function(item, i, arr) {
               out += '<option value=' + item.id + '>' + item.name + '</option>';
            });

            out += '</optgroup>';

            $('#select-group').append(out);
            
            //Обновление material_select
            $('select').material_select();
        },
        error: function(xhr,textStatus){
            console.log(textStatus);
        }
    });

    $('#refrash').click(function(){

        var subject = $('#select-subject').val();
        var group   = $('#select-group option:selected').text();

        console.log("1 - " + subject + ", 2 - " + group);

        $.ajax({
            url:'http://localhost:8080/teacher/getStudents',
            type:'GET',
            success: function(recieved){

                $('#table-body').empty();

                var out = '';
                var a = 1;

                recieved.forEach(function(item, i, arr) {
                   if (group == item.studyGroupByStudyGroup) {
                        out += '<tr>' + 
                                        '<td>' + a + '</td>' +
                                        '<td>' + item.name + '</td>' +
                                        '<td>' + item.studyGroupByStudyGroup + '</td>' +
                                '<tr>';

                        a++;
                   }
                });

                $('#table-body').append(out);

            },
            error: function(xhr,textStatus){
                console.log(textStatus);
            }
        })
    });

    $('#add').click(function(){
        console.log('add');
        console.log(new Date('3.27.2008'));
    });

    /*
    $('#findIdRequest').click(function(){
        var id = $('#findIdText').val();

        $.ajax({
            url:'http://localhost:8080/user/findById/' + id,
            type:'GET',
            success: function(data){
                console.log(data);
                $('#findIdDiv').html('');
                $('#findIdDiv').html(data.name);
            },
            error: function(xhr,textStatus){
                if(xhr.status=="500")
                    $('#findIdDiv').html("<H1 style='color:red'>Ошибка на сервере</H1>");
                else $('#findIdDiv').html("<H1 style='color:red'>Ничего не найдено</H1>");
            }

        })
    })

    $('#findNameRequest').click(function(){
        var name = $('#findNameText').val();

        $.ajax({
            url:'http://localhost:8080/user/findByName/' + name,
            type:'GET',
            success: function(data){
                console.log(data);
                var out = '';
                data.forEach(function(item, i, arr) {
                    out = out + item.id + ' ' + item.name + ' ' + item.role.role + ' ' + item.group + '<br>';
                });

                $('#findNameDiv').html(out);
            },
            error: function(xhr,textStatus){
                if(xhr.status=="500")
                    $('#findNameDiv').html("<H1 style='color:red'>Ошибка на сервере</H1>");
                else $('#findNameDiv').html("<H1 style='color:red'>Ничего не найдено</H1>");
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
    */
});