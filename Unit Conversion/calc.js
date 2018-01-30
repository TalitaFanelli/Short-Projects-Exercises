$(function () {
    $('#calc').click(function () {
        const miles = parseFloat($('#miles').val())
        const meters = (1609.34 * miles)

        $('#meters').val(meters)
    })
})