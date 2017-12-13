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
            alert('Обновление предметов - ' + textStatus);
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
            alert('Обновление групп - ' + textStatus);
        }
    });

    $('#refrash').click(function(){

        //Для того, чтобы вывести текст
        //var group = $('#select-group option:selected').text();

        //При приеме был получен id в value
        var group = $('#select-group').val();

        $.ajax({
            url:'http://localhost:8080/teacher/getStudentsByGroup/' + group,
            type:'GET',
            success: function(recieved){

                $('#table-body').empty();

                var out = '';
                var a = 1;

                recieved.forEach(function(item, i, arr) {
                    out += '<tr>' + 
                                '<td>' + a + '</td>' +
                                '<td>' + item.name + '</td>';

                                item.excercisesById.forEach(function(item1, i1, arr1) {
                                    out += '<td>' + item1.date + '</td>';
                                });

                    out += '</tr>';

                    a++;
                });

                $('#table-body').append(out);

            },
            error: function(xhr,textStatus){
                alert('Refrash - ' + textStatus);
            }
        })
    });

    $('#add').click(function(){
        console.log('add');
        console.log(new Date('3.27.2008'));
    });
});