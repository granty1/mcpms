app.filter('RemarkFilter',function () {
    return function (str) {

        if(str != null){
            var array = str.split("");
            if (array.length<=4){
                return str;
            }else {
                return array[0]+array[1]+array[2]+array[3]+'...'
            }
        }
        return null
    }
})