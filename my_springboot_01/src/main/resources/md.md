
// 增加用户
{
"id": "4",
"username": "赵尚志4",
"password": "123456",
"nickname": "zhaoshagnzhi4",
"email": "1@qq.com",
"status": 0,
"createUser": 20,
"updateUser": 20,
"age": 64
}


// 增加库存

localhost:8099/elasticsearch/sku/add



{
"id": "1",
"name": "赵尚志",
"price": 2500,
"num": "100",
"image": "1@qq.com",
"images": "",
"spuId": "1",
"categoryId": 1,
"categoryName": "手机/运营商",
"brandId": 1,
"brandName": "华为",
"skuAttribute":  "{\"就业薪资\": \"10K起\", \"学习费用\": \"2万\",  \"手机屏尺寸\": \"5.0到5.9英寸\",\"像素\": \"2000-3000万\",   \"价格范围\": \"5000元以上\"}",
"status": 1
}


{
"id": "3",
"name": "赵尚志3",
"price": 2500,
"num": "100",
"image": "1@qq.com",
"images": "",
"spuId": "1",
"categoryId": 1,
"categoryName": "手机",
"brandId": 1,
"brandName": "华为",
"skuAttribute":  "{\"就业薪资\": \"10K起\", \"学习费用\": \"3万\",  \"手机屏尺寸\": \"4.0到4.9英寸\",\"像素\": \"1000-2000万\",   \"价格范围\": \"3000-4000\"}",
"status": 1
}

查询：
localhost:8099/elasticsearch/sku/search

{
"keywords": "赵尚志",
"category": "手机/运营商",
"brand": "华为",
"price": 2500,
"sfield": "price",
"sm": "desc",
"attr_学习费用": "2万",
"attr_价格范围": "5000元以上",
"attr_像素": "2000-3000万",
"page": 1,
"size": 10
}

查看堆内存
D:/java/java8/jdk-8u271-jdk/bin/jvisualvm.exe