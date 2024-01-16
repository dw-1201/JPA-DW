import * as form from './module/form.js';


$(document).ready(function (){
    orderByDay();
    saleByCategory();

    orderMostList(renderOrderMostList)
})




function orderByDay(){

    $.ajax({

        url:'/admins/weeklyOrderState',
        type:'get',
        dataType: 'json',
        success : function (result){

            let OrderCanvas = document.getElementById('weekly-order-chart');

            let labels = [];
            let saleAmount = [];
            let data = '';

            result.forEach(function (sales){

                labels.push(sales.saleDate);
                saleAmount.push(sales.saleCounts)
            })

        data = {

                labels : labels,
                datasets :[
                    {
                        label : '',
                        data : saleAmount,
                        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)',
                            'rgb(75, 192, 192)', 'rgb(93,54,235)', 'rgb(153, 102, 255)','rgb(142,17,115)']
                    }
                ]

        }

            window.barChart = new Chart(OrderCanvas, {
                type: 'bar',
                data: data,
                options: {
                    responsive: false,
                    legend: {
                        display: false
                    }
                },

                legendCallback: customLegend
            })
        }

    })

}



function saleByCategory(){

    $.ajax({
        url:'/admins/salesByCategory',
        type:'get',
        dataType:'json',
        success:function (result){
            console.log(result)

            let CateCanvas = document.getElementById('cate-sale-ratio');
            let labels = [];
            let salesCount = [];
            let totalSales = 0;
            let data = '';

            result.forEach(function (sales){
                labels.push(sales.goodsCategory);
                salesCount.push(sales.goodsSaleCount);
                totalSales += sales.goodsSaleCount;
            });

            let ratioData = salesCount.map(count => (count / totalSales * 100).toFixed(2)); //소수점 자리 제한

            data = {
                labels: labels,
                datasets: [
                    {
                        label: '',
                        data: ratioData,
                        fill: false,
                        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)',
                            'rgb(75, 192, 192)', 'rgb(111,50,222)',  'rgb(192,112,75)']
                    }
                ]
            }

            window.pieChart = new Chart(CateCanvas, {
                type: 'pie',
                data: data,
                options: {
                    responsive: false,
                    legend: {
                        display: false
                    },
                    tooltips: {
                        backgroundColor: 'rgba(124, 35, 35, 0.4)',
                        titleFontSize: 30,
                        bodyFontSize: 17,
                        paddingRight: 10,
                        bodySpacing: 5,
                        callbacks: {
                            label: function(tooltipItem, data) {
                                let dataset = data.datasets[tooltipItem.datasetIndex];
                                let label = data.labels[tooltipItem.index] || '';
                                let value = dataset.data[tooltipItem.index];
                                return label + ': ' + value + '%';
                            }
                        }
                    },
                    legendCallback: customLegend

                }
            });

            document.getElementById('legend-div').innerHTML = pieChart.generateLegend();

        }
    })
}


let customLegend = function (chart) {
    let ul = document.createElement('ul');
    let color = chart.data.datasets[0].backgroundColor;

    chart.data.labels.forEach(function (label, index) {
        ul.innerHTML += `<li><span style="background-color: ${color[index]}"></span>${label}</li>`;
    });

    return ul.outerHTML;
};


function orderMostList(callback){

    $.ajax({

        url:'/admins/mostOrders',
        type:'get',
        dataType:'json',
        success : function (result){

            console.log(result)
            if(callback){
                callback(result)
            }

        },error:function (a,b,c){
            console.log(c)
        }
    })
}

function renderOrderMostList(result){

    let text = '';
    let textInputSection = $('.order-most-list');
    let rank =0;
    result.forEach(r=>{

        rank++;

        text += `
        
        
                <tr class="best-order-content">
                    <td>${rank}</td>
                    <td ><a href="/admin/userDetail/${r.userId}">${r.userAccount}</a></td>
                    <td>${r.userName}</td>
                    <td>${r.totalOrderCount}</td>
                    <td>${form.addCommas(r.totalPrice) + '원'}</td>
                </tr>
        `;

    })

    textInputSection.html(text);


}