

	$(function(){
		//alert("====");
		//获取省份保存的位置
		var $pronivce = $("[name='province']");
		
		var url = "/springMvc_6/province/findProvinceAllInfo";
		var params = {};
		
		$.post(
			url,
			params,
			function(pro){
			// alert(pro);
				var $data = $(pro);
				$data.each(function(index,dom){
					$pronivce.append("<option value='"+dom.provinceid+"'>"+dom.name+"</option>");
				});
			},
			"json"
				
		);
		
	});
	
	
	function loadCity(obj){
		
		//获取省份的id值得到对象的城市
		//alert(obj.value);
		var provinceId = obj.value;
		
		//通过js获取到省份的名称
		//alert(obj[provinceId].innerHTML);
		var proName = obj[provinceId].innerHTML;
		//获取隐藏框的位置
		$("#provinceName").val(proName);
		
		//获取城市保存的位置
		var $city = $("[name='city']");
		
		var url = "/springMvc_6/city/findCityByProvId";
		var params = {"provinceId":provinceId};
		$city.empty();
		
		$.post(
			url,
			params,
			function(citys){
				//alert(citys);
				//将json格式转换jquery格式
				var $data = $(citys);
				$data.each(function(index,dom){
					$city.append("<option value='"+dom.name+"'>"+dom.name+"</option>");
				});
			},
			"json"
		
		);
	}
	
	