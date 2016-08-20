//对数字进行0补齐处理
function pad(source, length) {
    var pre = ''
    , negative = (source < 0)   //判断是否为负数
    , string = String(Math.abs(source))
    , sLenght = string.length;
    if(sLenght < length) {
        pre = (new Array(length - sLenght + 1)).join('0');
    }
    return (negative? '-' : '') + pre + string;
}

var formatDate = function(time, pattern) {
    function replacer(patternPart, result) {
        pattern = pattern.replace(patternPart, result)
    }

    var year = time.getFullYear()
    , month = time.getMonth() + 1
    , date = time.getDate()
    , hours = time.getHours()
    , minutes = time.getMinutes()
    , seconds = time.getSeconds();

    replacer(/yyyy/g, pad(year, 4));
    replacer(/yy/g, pad(year.toString().slice(2), 4), 2);
    replacer(/MM/g, pad(month, 2));
    replacer(/M/g, year);
    replacer(/dd/g, pad(date, 2));
    replacer(/d/g, year);

    replacer(/HH/g, pad(hours, 2));
    replacer(/H/g, hours);
    replacer(/mm/g, pad(minutes, 2));
    replacer(/m/g, minutes);
    replacer(/ss/g, pad(seconds, 2));
    replacer(/s/g, seconds);

    return pattern;
};
var renderDownChart = function(startDate, totalDownloadNum, downloadNum, updateNum){
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'downLoadChart',
            zoomType: 'x',
            spacingRight: 20
        },
        credits:{
            text: 'MIUI',
            href: 'http://www.miui.com'
        },
        title:{
            text: '下载更新量日变化趋势图',
            align: 'center',
            x: 0,
            margin: 30
        },
        xAxis: {
            type: 'datetime',
            maxZoom: 14 * 24 * 3600000, // fourteen days
            title: {
                text: null
            }
        },
        yAxis: {
            title: {
                text: ''
            },
            min: 0,
            startOnTick: false,
            showFirstLabel: false
        },
        tooltip: {
            formatter: function(){
                return formatDate(new Date(this.x), 'yyyy年MM月dd日') + ": " + this.y + '次';
            }
        },
        plotOptions: {
            area: {
                lineWidth: 1,
                marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 5
                        }
                    }
                },
                shadow: false,
                states: {
                    hover: {
                        lineWidth: 2
                    }
                }
            },
            line: {
                lineWidth: 2,
                marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 5
                        }
                    }
                },
                shadow: false,
                states: {
                    hover: {
                        lineWidth: 3
                    }
                }
            }
        },
        series: [{
            type: 'area',
            name: '日下载更新总量',
            pointInterval: 24 * 3600 * 1000,
            pointStart: startDate,
            data: totalDownloadNum
        },
        {
            type: 'line',
            color: "#ab3f3f",
            name: '日下载量',
            pointInterval: 24 * 3600 * 1000,
            pointStart: startDate,
            data: downloadNum
        },
        {
            type: 'line',
            color: "#8bbc21",
            name: '日更新量',
            pointInterval: 24 * 3600 * 1000,
            pointStart: startDate,
            data: updateNum
        }
        ]
    });
};
var renderGalaxy = function(startDate, totalAccessNum){
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'downLoadChart',
            zoomType: 'x',
            spacingRight: 20
        },
        credits:{
            text: '',
            href: 'http://www.miui.com'
        },
        title:{
            text: '访问量日变化趋势',
            align: 'center',
            x: 0,
            margin: 30
        },
        xAxis: {
            type: 'datetime',
            maxZoom: 14 * 24 * 3600000, // fourteen days
            title: {
                text: null
            }
        },
        yAxis: {
            title: {
                text: ''
            },
            min: 0,
            startOnTick: false,
            showFirstLabel: false
        },
        tooltip: {
            formatter: function(){
                return formatDate(new Date(this.x), 'yyyy年MM月dd日') + ": " + this.y + '次';
            }
        },
        plotOptions: {
            area: {
                lineWidth: 1,
                marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 5
                        }
                    }
                },
                shadow: false,
                states: {
                    hover: {
                        lineWidth: 2
                    }
                }
            },
            line: {
                lineWidth: 2,
                marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 5
                        }
                    }
                },
                shadow: false,
                states: {
                    hover: {
                        lineWidth: 3
                    }
                }
            }
        },
        series: [{
            type: 'area',
            name: '每天访问总量',
            pointInterval: 24 * 3600 * 1000,
            pointStart: startDate,
            data: totalAccessNum
        }
        ]
    });
};