$(document).ready(function (){
    dailyJoinUserCount()

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











