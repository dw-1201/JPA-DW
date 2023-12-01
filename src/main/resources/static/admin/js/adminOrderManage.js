
window.onload = function () {
    
}


let data = {
    labels: [

        '1','2','3','4','5','6','7'
    ],
    datasets: [{
        data: [21,33,35,36,45,39, 99],
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)'],
    }]
};
let barChartDraw = function(){
    let OrderCanvas = document.getElementById('weekly-order-chart');

    window.barChart = new Chart(OrderCanvas, {
        type: 'bar',
        data: data,
        options: {
            reoponsive: false,
            legend: {
                display: false
            }
        },
        
        legendCallback: customLegend
    })
}







window.onload = function () {
    pieChartDraw();
    document.getElementById('legend-div').innerHTML = pieChart.generateLegend();

    barChartDraw();

}

let cateData = {
    labels: [

        '간식','영양제','장난감','케리어'
    ],
    datasets: [{
        data: [21,33,35,36],
        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)']
    }]
};

let pieChartDraw = function(){
    let CateCanvas = document.getElementById('cate-sale-ratio');

    window.pieChart= new Chart(CateCanvas, {
        type: 'pie',
        data: cateData,
        options: {
            resposive: false,
            legend: {
                display: false
            },
            tooltips: {
                backgroundColor: 'rgba(124, 35, 35, 0.4)',
                titleFontSize: 30,
                bodyFontSize: 30,
                paddingRight: 10,
                bodySpacing: 5
            },
            legendCallback: customLegend
        }
    });
    
}

let customLegend = function (chart) {
    let ul = document.createElement('ul');
    let color = chart.data.datasets[0].backgroundColor;

    chart.data.labels.forEach(function (label, index) {
        ul.innerHTML += `<li><span style="background-color: ${color[index]}"></span>${label}</li>`;
    });

    return ul.outerHTML;
};