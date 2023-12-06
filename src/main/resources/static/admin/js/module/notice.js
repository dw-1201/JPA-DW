//리스트 불러오기
export function list(page,searchForm, section, callback){

    $.ajax({

        url:`/admins/${section}/${page}`,
        type:'get',
        data:searchForm,
        dataType:'json',
        success :function (result){
            console.log(result.content)
            console.log(result.pageable)

            if(callback){
                callback(result)
            }


        },error : function (a,b,c){
            console.error(c);
        }

    })
}
export function sliding(a,b){
        // Use event delegation to bind click event to a static parent element
        $(a).on('click', '.admin-notice-lists .rr', function() {
            let $currentSection = $(this).next(b);

            // Toggle the current section
            $currentSection.stop().slideToggle(400);
            // Collapse other sections
            $(this).parent().siblings().find(b).slideUp(400);
        });

}
