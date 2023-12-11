// 리스트 불러오기
export function list(page,callback){

    $.ajax({

        url:`/qnar/qnalist/${page}`,
        type:'get',
        data:{page:page},
        dataType:'json',
        success: function (result){
            console.log(result.content)
            console.log(result.pageable)

            if(callback){
                callback(result)
            }
        },error : function (a,b,c){
            console.error(c)
        }
    })

}