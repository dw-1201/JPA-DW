import * as date from './module/dateFormatt.js';

$(document).ready(function(){

    let regDate = $('#regDate').val();
    // let modDate = $('#modDate').val();

    $('.walk-date-register').text(date.formatDates(regDate));
    // date.formatDate(modDate);





    $('.reply-show').on('click', function(){

        $('.walk-reply-section').stop().slideToggle(400);

    })

    $('.apply-show').on('click', function (){

        $('.walk-apply-section').stop().slideToggle(400);

    })
})





