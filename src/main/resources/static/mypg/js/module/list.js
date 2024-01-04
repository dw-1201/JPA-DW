



// 리스트 불러오기
export function list(page,userId,name,section,callback) {


    $.ajax({

        url: `/${name}/${section}/${page}/${userId}`,
        type: 'get',

        dataType: 'json',
        success: function (result) {
            console.log(result.content)
            console.log(result.pageable)


            if (callback) {
                callback(result)
            }
        }, error: function (a, b, c) {
            console.error(c)
        }
    })
}








