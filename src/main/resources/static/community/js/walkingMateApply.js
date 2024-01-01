$(document).ready(function (e){

    let walkMateId = $('#walkBoardId').val();


    applyCheck(walkMateId);

})


//모달창 팝업
$('.apply-btn').on('click', function (){

    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();

    if(userId == '' || userId==null){

        alert("로그인이 필요합니다. ");

        if(confirm("로그인 페이지로 이동하시겠습니까?")){
            window.location.href="/user/enterLogin";

        }
        return false;
    }else {

    }
    $('.apply-modal-section').addClass('showModal');
    applyCheck(walkMateId)

})

//신청서 제출
$('.apply-submit-btn').on('click', function (e){




    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();
    let petId = $('#sessionUserPet').val();




    if(confirm("신청하시겠습니까?")){
        walkingMateApply(walkMateId, userId, petId);

        $('.apply-modal-section').removeClass('showModal');


        alert("신청이 완료되었습니다.");

    }
})


//신청취소
$('.apply-cancel-btn').on('click', function (){

    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();

    if(confirm("신청을 취소하겠습니까?")){

        applyCancel(walkMateId, userId, function (){


            alert("정상적으로 신청이 취소되었습니다.");


        })
    }

})







//산책메이트 신청저장
function walkingMateApply(walkMateId, userId, petId){

    $.ajax({

        url:'/walks/applyWalkMate',
        type:'get',
        data : {
            walkingMateId : walkMateId,
            userId : userId,
            petId : petId,
            state : 0
        },
        success : function (){

            $('.apply-cancel-btn').css('display','block');
            $('.apply-btn').css('display', 'none');

        },error : function (a,b,c){
            console.error(c)
        }
    })
}

//산책메이트 중복신청 검사
function applyCheck(walkMateId){


    $.ajax({

        url : `/walks/applyCheck/${walkMateId}`,
        type:  'get',
        success : function (result){

            if(result=='' || result == null){

                $('.apply-cancel-btn').css('display','none');
                $('.apply-btn').css('display', 'block');

            }else {

                $('.apply-cancel-btn').css('display','block');
                $('.apply-btn').css('display', 'none');
            }


        }
    })
}

//산책메이트 신청 취소
function applyCancel(walkMateId, userId, callback){

    $.ajax({

        url:`/walks/applyCancel/${walkMateId}/${userId}`,
        type:'delete',
        success : function (){

            $('.apply-cancel-btn').css('display','none');
            $('.apply-btn').css('display', 'block');

            if(callback){
                callback()
            }
        }
    })
}