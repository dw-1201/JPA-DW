$('.detail-btn').on('click', function(){

    window.location.href="/admin/html/adminUserDetail.html";

})


$(document).ready(function (){
    getUserList(0);

})

function searchUserForm(){

    let cate = $('#search-cate').val();
    let keyword = $('#search-keyword').val();

    return {

        cate:cate,
        keyword:keyword

    }
}



function getUserList(page){

    $.ajax({

        url:`/admins/userList/${page}`,
        type:'get',
        data:'json',
        success:function (result){

            console.log(result.content)
            console.log(result.pageable)

        },error : function (a,b,c){
            console.error(c);
        }


    })

}