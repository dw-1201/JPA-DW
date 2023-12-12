import  * as page from './module/pagination.js';



$('.detail-btn').on('click', function(){

    window.location.href="/admin/html/adminUserDetail.html";

})


function searchUserForm(){

    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();

    return {

        cate:cate,
        keyword:keyword

    }
}


$(document).ready(function (){
    //첫로드 화면
    updateUserState(0, 1, searchUserForm(), showUserList);

    $("input[name='userState']").on('change', function () {
        let userState = $(this).val();
        updateBasedOnState(userState);
    });

    $('.result-submit-btn').on('click', function() {
        let userState = $("input[name='userState']:checked").val();
        $(this).data('clicked', true);
        updateBasedOnState(userState);
    });
});


//회원 상태에 따라 리스트 불러오는 함수
function updateBasedOnState(userState) {
    updateUserState(0, userState, searchUserForm(), showUserList);
}




function updateUserState(page, userStateValue, searchForm, callback) {
        $.ajax({
            url: `/admins/userList/${page}`,
            type: 'get',
            data: {
                userState: userStateValue,
                cate: searchForm.cate,
                keyword: searchForm.keyword
            }
            ,
            success: function (result) {
                console.log(result.content);
                console.log(result.pageable);

                if(callback){
                    callback(result)
                }

            },
            error: function (a, b, c) {
                console.error(c);
            }
        });
    }


function showUserList(result){

    let text ='';
    let textInput = $('.user-list');

    result.content.forEach(r=>{


        text += `
        
                    <tr>
                        <td>${r.userAccount}</td>
                        <td>${r.userName}</td>
                        <td>${r.userEmail}</td>
                        <td>${r.userPhone}</td>
                        <td>추후 조인</td>
                        <td>추후 조인</td>
                        <td class="list-btns">
                            <button type="button" class="detail-btn btn">상세보기</button>
                            <button type="button" class="delete-btn btn">탈퇴처리</button>
                        </td>
                    </tr>
        
       
        `;


    })
    textInput.html(text);
    let paginations = $('.pagination-ul');
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        updateUserState(page, $("input[name='userState']:checked").val(), searchUserForm(), showUserList);

    });
}







