$(document).ready(function(){
    $('#delete_button').click(function() {

        var data = [];
        $('#lines').find('tr').each(function () {
            if ($(this).find('input[type="checkbox"]').is(':checked')) {
                var line = {
                    id: $(this).find('td:eq(1)').text(),
                    value: $(this).find('td:eq(2)').text()
                };

                data.push(line);
            }
        });

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: '/delete_checked',
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {
                location.reload();
            },
            error: function (e) {
                alert('error');
            }
        });
    });

    $('.line_value').dblclick(dblcl);

    function dblcl() {
        $(this).off("dblclick");
        input = $("<input type=\"text\" value=\"" + $(this).text() + "\" class=\"input_line\" />");
        $(this).text("");
        $(this).append(input);

        $('.input_line').on("keyup", onEnter);
    }

    function onEnter(e) {
        if (e.which === 13) {
            var text = $(this).val();

            var line = {
                id: $(this).parent().parent().find('td:eq(1)').text(),
                value: text
            };

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: '/update_line',
                data: JSON.stringify(line),
                dataType: 'json',
                timeout: 600000,
                success: function (data) {
                },
                error: function (e) {
                    alert('error');
                }
            });

            $(this).parent().on("dblclick", dblcl);
            $(this).parent().text(text);
        }
    }
});
