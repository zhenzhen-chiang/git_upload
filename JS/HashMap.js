
var HashMap = function () {
    const obj = {};//hashmap實際儲存的格式
    return {
        put: function (key, value) {
                obj[key] = value;//把傳進的k、v放進[]//map.key===map['key]
        },
        keys: function () {
            const array = [];
            for (const key in obj) {
                array.push(key);
            }
            return array;
            // Object.keys(map)

        },
        contains: function (keyInput) {
            for (const key in obj) {
                if (key === keyInput) {//key跟傳入的k做比較
                    return true;
                }
            }
            return false;
        },
        get: function (key) {//是透過[k]取得相對應的value
            return obj[key];

        },
        clear: function () {
            for (const key in obj) {

                delete obj[key];
            }

        }
    };
};