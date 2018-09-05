$(document).ready(function() {
    $("#test").text("切换背景图片")
    $("#test").click(function () {
        $("body").css("background-image","url('/image/wallhaven-680441.jpg')")
    })
})