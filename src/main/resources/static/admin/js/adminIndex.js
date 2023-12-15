$(document).ready(function (){
    dailyJoinUserCount()
    status(showRecentStatus)
})


function dailyJoinUserCount(){

    $.ajax({

        url : '/admins/daily',
        type :'get',
        dataType:'json',
        success : function (result){

            console.log(result)
            let joinCanvas = document.getElementById('weekly-join-chart');
            let labels = [];
            let counts = [];
            let data = '';
        result.forEach(function (daily){
                labels.push(daily.joinDate);
                counts.push(daily.counts);
        })
            data = {
                labels : labels,
                datasets : [{
                    label: '일별 회원가입',
                    data: counts,
                    fill: false,
                    borderColor: 'rgb(75, 192, 192)',
                    borderWidth:2
                }]
            }
            let myLineChart = new Chart(joinCanvas.getContext('2d'), {
                type: 'bar',
                data: data
            });
        }
    })

}

function status(callback){

    $.ajax({


        url:'/admins/newUserStatus',
        type:'get',
        data:'json',
        success : function (result){
            console.log(result)

            if(callback){
                callback(result)
            }

        },error : function (a,b,c){
            console.error(c)
        }

    })


}

function showRecentStatus(result){

    let text = '';
    let statusText = '';
    let section = $('.recent-user-list');
    let statusSection = $('.user-status-ul');
        result.userRecent.forEach(r=>{

            text += `
                         <tr>
                                                
                            <td><a href="/admin/userDetail/${r.id}">${r.userAccount}</a></td>
                            <td>${r.userName}</td>
                            <td>${r.userEmail}</td>
                            <td>${r.userJoinDate}</td>
                        </tr>
        `;

        })

            statusText = `
    
                        <li>전체회원
                            <div class="total-user admin-user-info" style="color:rgb(0, 157, 255)">
                                ${result.userInfoCount[0]}
                            </div>
                        </li>
                        <li>오늘 가입회원
                            <div class="today-join-user admin-user-info" style="color:rgb(235, 153, 1)">
                                ${result.userInfoCount[1]}
                            </div>
                        </li>
                        <li>오늘 탈퇴회원
                            <div class="delete-user admin-user-info" style="color:gray">
                                ${result.userInfoCount[2]}
                            </div>
                        </li>
                        <li>총 탈퇴회원
                            <div class="total-delete-user admin-user-info">
                                ${result.userInfoCount[3]}
                            </div>
                        </li>
            `;

    section.html(text)
    statusSection.html(statusText);
}












