let applyBtn = $('.apply-btn');
let applyCancelBtn = $('.apply-cancel-btn');
let applyComplete = $('.apply-complete-btn');


$(document).ready(function () {
    let walkMateId = $('#walkBoardId').val();

    $(document).on('click', function (e) {
        let modal = $('.modal-open');
        // 클릭한 요소가 모달 외부에 있고, 모달이 열려 있는 경우에만 모달을 닫습니다.
        if (modal.is(e.target) && modal.has(e.target).length === 0) {

            if(confirm("작성을 취소하시겠습니까?")){
                modal.removeClass('showModal');
            }
        }
    });
    // check(walkMateId)
    applyCheck(walkMateId);
});


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
    }


    $('.modal-open').addClass('showModal');
    applyCheck(walkMateId)

})

//신청서 제출
$('.apply-submit-btn').on('click', function (){


    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();
    let petId = $('#sessionUserPet').val();




    if(confirm("신청하시겠습니까?")){
        walkingMateApply(walkMateId, userId, petId);

        $('.modal-open').removeClass('showModal');


        alert("신청이 완료되었습니다.");

    }
})


//신청취소
$('.apply-cancel-btn').on('click', function (){

    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();

    if(confirm("신청을 취소하겠습니까?")){

        window.location.href="/walk/applyCancel/" +walkMateId +"/"+userId;


            alert("정상적으로 신청이 취소되었습니다.");


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
            state : 0,
            writerCheck :0
        },
        success : function (){

            $('.apply-cancel-btn').css('display','block');
            applyBtn.css('display', 'none');

        },error : function (a,b,c){
            console.error(c)
        }
    })
}

//산책메이트 중복신청 검사
function applyCheck(walkMateId){

    let currentPerson = $('#currentPerson').val();
    let matePerson = $('#matePerson').val();
    let currentState = $('#currentState').val();

    $.ajax({

        url : `/walks/applyCheck/${walkMateId}`,
        type:  'get',
        success : function (result){

            if(result=='' || result == null){

                applyCancelBtn.css('display','none');
                applyBtn.css('display', 'block');

                if((currentPerson==matePerson) || currentState==1 ){
                    applyComplete.css('display', 'block');
                }else {
                    applyComplete.css('display', 'none');

                }

            }else {

                applyCancelBtn.css('display','block');
                applyBtn.css('display', 'none');

                if((currentPerson==matePerson) || currentState==1 ){
                    applyComplete.css('display', 'block');
                }else {
                    applyComplete.css('display', 'none');

                }
            }
        }
    })
}


// //통신확인용
// function check(walkMateId){
//
//     $.ajax({
//
//
//         url : `/walks/applierPetInfo/${walkMateId}`,
//         type:'get',
//         dataType:'json',
//         success :function (result){
//             console.log(result)
//         }
//     })
//
// }