
// let data = {
//     labels: [
//
//         '1','2','3','4','5','6','7'
//     ],
//     datasets: [{
//         data: [21,33,35,36,45,39, 99],
//         backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)'],
//     }]
// };
// let barChartDraw = function(){
//     let OrderCanvas = document.getElementById('weekly-order-chart');
//
//     window.barChart = new Chart(OrderCanvas, {
//         type: 'bar',
//         data: data,
//         options: {
//             reoponsive: false,
//             legend: {
//                 display: false
//             }
//         },
//
//         legendCallback: customLegend
//     })
// }


$(document).ready(function (){
    orderByDay();
    saleByCategory();

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
                            'rgb(75, 192, 192)', 'rgb(93,54,235)', 'rgb(153, 102, 255)','rgb(241,43,209)']
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