

function searchForm(){

    let cate =$('#walk-search-cate').val();
    let keyword = $('#walk-search-keyword').val();


    return {
        cate : cate,
        keyword : keyword
    }

}


$('.result-walk-submit-btn').on('click', function (){

    getWalkList(0, searchForm())


})


getWalkList(0, searchForm())



function getWalkList(page, searchForm){
    $.ajax({

        url : `/admins/walkList/${page}`,
        type:'get',
        data : searchForm,
        success : function (result){
            console.log(result)
        }


    })
}