$(function () {
    $('#jwt-login').click(function () {
        $.post('/jwt', { username: $('#jwt-username').val(), password: $('#jwt-password').val() }, function (data) {
            // console.log(err, data)
            if (data.success) {
                $('#token').val(data.token)
            }
            else {
                $('#token').val('error')
            }
        })

        return false;
    })

    $('#jwt-get-user').click(function() {
        const token = $('#token').val()

        $.ajax({
            type: 'GET',
            url: '/get-user',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('x-access-token', token)
            },
            success: function(data) {
               // console.log(data)
               $('#user').val(JSON.stringify(data))
            }
        })
    })
})