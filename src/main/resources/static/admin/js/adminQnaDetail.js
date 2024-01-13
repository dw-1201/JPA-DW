import * as form from './module/form.js';



$(document).ready(function(){
    $('.showBtn').on('click', function(){


        $('.walk-reply-section').stop().slideToggle(400);

    })



    $('.questionRegisterDate').text(form.formatDates($('.questionRd').val()));


})









