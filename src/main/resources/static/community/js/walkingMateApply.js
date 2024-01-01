$(document).ready(function (e){

    if(e.target === $('.apply-modal-section')[0]){
        $('.apply-modal-section').removeClass('showModal');

    }
})


//모달창 팝업
$('.apply-btn').on('click', function (){

    $('.apply-modal-section').addClass('showModal')

})

//신청서 제출
$('.apply-submit-btn').on('click', function (e){

    $('.apply-modal-section').removeClass('showModal');




    let userId = $('#userId').val();
    let walkMateId = $('#walkBoardId').val();
    let petId = $('#sessionUserPet').val();


    if(confirm("신청하시겠습니까?")){
        walkingMateApply(walkMateId, userId, petId);
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

        },error : function (a,b,c){
            console.error(c)
        }
    })
}