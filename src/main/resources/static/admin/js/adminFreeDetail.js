import * as form from './module/form.js';


$(document).ready(function(){
    $('.showBtn').on('click', function(){


        $('.free-reply-section').stop().slideToggle(400);

    })
    let freeBoardRd = $('.freeBoardRd')
    let freeBoardRdValue = $('.freeBoardRdValue')

    $(freeBoardRd).text(form.formatDates($(freeBoardRdValue).val()))


    let commentRd = $('.reply-reg-date');
    let commentRdValue = $('.freeBoarCommentRd');

    for(let i =0; i<commentRd.length; i++){

        $(commentRd[i]).text(form.formatDates($(commentRdValue[i]).val()))
    }

    $('.delete-free-btn').on('click', function (){

        let boardId = $(this).data('boardid');

        if(confirm("삭제하시겠습니까?")){

            window.location.href="/admin/freeBoardDelete/" + boardId;
        }

    })


})
