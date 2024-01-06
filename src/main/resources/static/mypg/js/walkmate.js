import * as list from "./module/list.js";
import * as page from "./module/page.js";
import {listSearchDto} from "./module/list.js";


// 모집현황 데이터 불러오기
function searchRecruitmentForm(){

    let state = $("input[name='state']:checked").val();
    console.log(state +"searchRecruitmentForm() ")
    return{
        state : state

    }

}

function moveState(state){
    let userId = $('.walkmate').data('userid');
    searchRecruitmentForm().state = state;
    console.log( searchRecruitmentForm().state + " moveState");
    list.listSearchDto(0,userId,searchRecruitmentForm(),'mypgs','myregisterwalkmatewrite',showList);
}

function showList(result){
    let text = '';
    let textInput = $('.walk-list');

    if(result.content.length ===0){
        text = `<div className="nonepage">
            <div className="none-img-area">
                <div className="none-img">
                    <img src="../img/b556fdf429d8de25c3acf62f8186ddb9.png"/>
                </div>
            </div>
            <div className="nonetext-area">
                <p>등록된 내용이 없습니다.</p>
            </div>
        </div>
        `;
    }else {
        result.content.forEach(r => {

            text += `
                 <div class="list-content" th:value="${r.id}">
                            <div class="content-text-box">
                                <div class="list-content-title">${r.walkingMateTitle}</div>
                                <div class="list-content-content">
                                    <div class="list-content-content-detail">
                                    ${r.walkingMateContent}
                                    </div> 
                                </div>
                                <div class="list-content-etc">
                                    <div class="list-content-address">
                                        <span>${r.walkCity} ${r.walkCounty}</span>
                                    </div>
                                    
                                    <div class="list-content-recruit">
                                        <span>모집인원</span>
                                        <span class="recruit-count">${r.walkingMateToday}/${r.walkingMatePerson}</span>
                                    </div>
                                    `;
                                    if(r.currentState==0 || (r.walkingMateToday != r.walkingMatePerson)) {
                                      text += `   <div class="recruit-btn-box">
                                            <button>모집 대기</button>
                                        </div>
                                        `;
                                    }else if(r.currentState==1 || (r.walkingMateToday == r.walkingMatePerson)){
                                        text +=`
                                              <div class="recruit-box" >
                                        <span>모집 완료</span>
                                    </div>
                                        `;
                                    }
                                  text +=`  
                                </div>
                            </div>
                            <div class="content-img-box">
                                <div class="content-img">
                                    <img src="/mypgs/petImg?fileFullPath=${r.petPath+'/'+r.petUuid+'_'+r.petFileName}" alt="">
                                </div>
                            </div>
                          
                 </div>
            `;



        })
    }

    console.log(text);
    textInput.html(text);

    let paginations = $('.pagination-ul');
    page.pagination(result, paginations)
    paginations.find('a').on('click', function (e) {
        e.preventDefault();
        const page = parseInt($(this).data('page'));
        let userId = $('.walkmate').data('userid');
        searchRecruitmentForm.state=$("input[name='state']:checked").val()
        list.listSearchDto(page,userId, searchRecruitmentForm(),'mypgs','myregisterwalkmatewrite', showList)



    });

}


$(document).ready(function (){
    let userId = $('.walkmate').data('userid');
    console.log(userId);
    list.listSearchDto(0,userId,searchRecruitmentForm(),'mypgs','myregisterwalkmatewrite',showList);


    $("input[name='state']").on('change', function (){

        let status = $(this).val();
        moveState(status);
        console.log(status+"야옹~")
    });
})