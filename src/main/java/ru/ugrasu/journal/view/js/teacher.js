$( document ).ready(function() {
    
    //Глобальный массив для хранения всех занятий по группе и предмету
    var arrayDate = [];

    //СМЕНА СТРАНИЦЫ
    $('#account').click(function(){
        location.replace("admin.html");
    });

    $('.datepicker').pickadate({
        selectMonth: true,
        selectYears: 5,
        today: 'Сегодня',
        clear: 'Очистить',
        close: 'OK',
        closeOnSelect: false,
        format: 'yyyy-mm-dd'
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

    function getStudents(group) {
        $.ajax({
            url:'http://localhost:8080/teacher/getStudentsByGroup/' + group,
            type:'GET',
            success: function(recieved) {

                var out = '';
                var rowNum = 1;

                recieved.forEach(function(item, i, arr) {
                    out += '<tr>' + 
                                '<td>' + rowNum + '</td>' +
                                '<td>' + item.name + '</td>';

                                var arrayIndex = 0;

                                if (item.excercisesById.length != 0) {
                                    item.excercisesById.forEach(function(item1, i1, arr1) {
                                        
                                        //Если даты не совпадают - на занятии не был
                                        while (arrayDate[arrayIndex] != item1.date) {
                                            out += '<td class="red lighten-2">Н</td>';
                                            arrayIndex++;
                                        }

                                        //Если совпадают - был
                                        out += '<td class="light-green lighten-2">+</td>';
                                        arrayIndex++;
                                    });
                                }
                                else {
                                    for (var i = 0; i < arrayDate.length; i++) {
                                        out += '<td class="red lighten-2">Н</td>';
                                        arrayIndex++;
                                    }
                                }

                                while (arrayIndex < arrayDate.length) {
                                    out += '<td class="red lighten-2">Н</td>';
                                    arrayIndex++;
                                }

                    out += '</tr>';

                    rowNum++;
                });

                $('#table-body').append(out);

            },
            error: function(xhr,textStatus){
                alert('Refrash - ' + textStatus);
            }
        })
    };

    $('#refrash').click(function (){

        //Для того, чтобы вывести текст
        //var group = $('#select-group option:selected').text();

        //При приеме был получен id в value
        var subject = $('#select-subject').val();
        var group = $('#select-group').val();

        $.ajax({
            url:'http://localhost:8080/teacher/getExcercises/' + subject + '/' + group,
            type:'GET',
            success: function(recieved) {

                $('#table-head').empty();
                $('#table-body').empty();
                arrayDate = [];

                var out = '';

                if (recieved.length == 0) {
                    out += '<tr><th>Похоже, у данной группы не ведется этот предмет =)</th></tr>';
                }
                else {
                    out += '<tr><th>№</th><th>Студент</th>';

                    recieved.forEach(function(item, i, arr) {
                        out += '<th>' + item.date + '</th>';
                        arrayDate.push(item.date);
                    })

                    out += '</tr>';

                    //Добавляем студентов через другой запрос
                    getStudents(group);
                };

                $('#table-head').append(out);
            },
            error: function(xhr,textStatus){
                alert('Refrash - ' + textStatus);
            }
        });
    })

    $('#add').click(function() {
        //Дата, группа и предмет
        //Передаем для сохранения занятия
        var d = $('#datepicker').val();
        var g = $('#select-group').val();
        var s = $('#select-subject').val();

        $.ajax({
            url:'http://localhost:8080/teacher/saveExcercise',
            type:'POST',
            data: {
                date: d,
                groupId: g,
                subjectId: s
            },
            success: function(recieved) {
                //Обновляем данные
                $('#refrash').click();
            },
            error: function(xhr,textStatus){
                alert('Add Date - ' + textStatus);
            }
        });

    });
});