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
});