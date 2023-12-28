let goodsId = $('#goodsId').val();
console.log(goodsId)

//첫 화면 진입시 
$(document).ready(function (){


    getDetailImgs(goodsId, detailImgList)

})

//설명 버튼 눌렀을 시
$('#descriptionLink').on('click', function (e){
    e.preventDefault();
    getDetailImgs(goodsId, detailImgList)


})







// 상세 페이지 제품 상세 사진 가져오기
function getDetailImgs(goodsId, callback){

    $.ajax({

        url : `/shops/shopDetilImgs/${goodsId}`,
        type:'get',
        dataType:'json',
        success : function (result){
            console.log(result);

            if(callback){
                callback(result)
            }
        }

    })

}

function detailImgList(result){

    let text = '';
    let inputSection = $('.row-content');


    result.forEach(r=>{


        text += `
        
            <img src="/shops/shopImg?fileFullPath=${r.goodsDetailImgPath + '/' + r.goodsDetailImgUuid + '_'+ r.goodsDetailImgName}" alt="">
                    
        `

    })

    inputSection.html(text);

}


