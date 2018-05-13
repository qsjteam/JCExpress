var myneed;
/*
FileReader共有4种读取方法：
1.readAsArrayBuffer(file)：将文件读取为ArrayBuffer。
2.readAsBinaryString(file)：将文件读取为二进制字符串
3.readAsDataURL(file)：将文件读取为Data URL
4.readAsText(file, [encoding])：将文件读取为文本，encoding缺省值为'UTF-8'
             */
var wb;//读取完成的数据
var rABS = false; //是否将文件读取为二进制字符串
var table;
function importExcel(obj) {//导入
    if(!obj.files) {
        return;
    }
    const IMPORTFILE_MAXSIZE = 1*1024;//这里可以自定义控制导入文件大小
    var suffix = obj.files[0].name.split(".")[1]
    if(suffix != 'xls' && suffix !='xlsx'){
        alert('导入的文件格式不正确!')
        return
    }
    if(obj.files[0].size/1024 > IMPORTFILE_MAXSIZE){
        alert('导入的表格文件不能大于1M')
        return
    }
    var f = obj.files[0];
    var reader = new FileReader();
    reader.onload = function(e) {
        var data = e.target.result;
        if(rABS) {
            wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                type: 'base64'
            });
        } else {
            wb = XLSX.read(data, {
                type: 'binary'
            });
        }
        //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
        //wb.Sheets[Sheet名]获取第一个Sheet的数据
		myneed=JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]) );
        table=$('#example').dataTable( {
		    	"aLengthMenu": [[5, 15, 25, -1], ["5条", "15条", "25条", "All"]],
		    /* 	 ajax : {
		              url : "test.json",
		              type : "get"
		         }, */
		    	"bAutoWidth": false,
		    	"scrollX": true,
		         bFilter: true,
		        "data": XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]),
		        columns : [
		              {"data":"*收件人姓名","title": "*收件人姓名"},
		              {"data":"*收件人联系方式","title": "*收件人联系方式"},
		              {"data":"*省","title": "*省"},
		              {"data":"*市","title": "*市"},
		              {"data":"区","title": "区"},
		              {"data":"*详细地址","title": "*详细地址"},
		              {"data":"*物品重量","title": "*物品重量"},
		              {"data":"*物品类型","title": "*物品类型"},
		              {"data":"备注","title": "备注"},
		    		]
		    } ); 
    };
    if(rABS) {
        reader.readAsArrayBuffer(f);
    } else {
        reader.readAsBinaryString(f);
    }
}
function fixdata(data) { //文件流转BinaryString
    var o = "",
        l = 0,
        w = 10240;
    for(; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
    o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
    return o;
}
function submit(){
	var send=$("#sendProvince").find("option:selected").text()+
	$("#sendCity").find("option:selected").text()+$("#sendVillage").find("option:selected").text();
	var params='';
	params+=$("#createOrders").serialize();
	params+="&receives="+myneed+"&send_area="+send;
	$.ajax({
		// 几个参数需要注意一下
		type : "POST",// 方法类型
		dataType : "json",// 预期服务器返回的数据类型
		url : Backstagelocation+ "/order/createOrders",// url
		data : params,
		success : function(result) {
			console.log(result);// 打印服务端返回的数据(调试用)
			if (result.code == 1) {
				AMUI.dialog.alert({
					title : '预约成功',
					content : '请耐心等待取派员取件',
					onConfirm : function() {
						console.log('close');
						window.location.reload();
					}
				});
			} else {
				AMUI.dialog.alert({
					title : '预约失败',
					content : result.message,
					onConfirm : function() {
						console.log('close');
						window.location.reload();
					}
				});
			};
		},
		error : function() {
			alert("异常！");
		}
	});
}


function downLoad(){
	window.open(baselocation+"/ExcelTemplate/batchOrder.xlsx");
}