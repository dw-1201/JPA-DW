import * as form from './module/form.js';



$(document).ready(function(){
    $('.showBtn').on('click', function(){


        $('.walk-reply-section').stop().slideToggle(400);

    })



    $('.questionRegisterDate').text(form.formatDates($('.questionRd').val()));


    let commentRd = $('.reply-reg-date');
    let commentRdValue = $('.questionCommentRd');

    for(let i =0; i<commentRd.length; i++){

        $(commentRd[i]).text(form.formatDates($(commentRdValue[i]).val()))
    }


    //삭제

    $('.delete-qna-btn').on('click', function (){
        let boardId = $(this).data('boardid');

        if(confirm("삭제하시겠습니까?")){

            window.location.href="/admin/questionDelete/" + boardId;
        }

    })



})









