function shop(page, searchForm){
    $.ajax({
        url:`/shops/shop-a/${page}`,
        type:'get',
        data: searchForm,
        dataType:'json',
        success: function(result) {
            console.log(result.pageable);
            console.log(result.content);
            showShopList(result.content);
            pagination(result);
        },
        error: function(a, b, c) {
            console.error(c);
        }
    });
}
