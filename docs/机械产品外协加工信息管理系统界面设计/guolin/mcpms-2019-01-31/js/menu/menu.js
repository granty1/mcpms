/**
 * 统计管理员菜单列表
 * @type {{name: string, child: *[]}[]}
 */
var statisticalAdministratorMenuList = [
    {
        "name": "生产管理",
        "child": [
            {
                "name": "订单产品",
                "url": "product/orderproduct"
            },
            {
                "name": "生产计划",
                "url": "product/productplan"
            },
            {
                "name": "订单零件",
                "url": "product/orderparts"
            },
            {
                "name": "外协审批",
                "url": "product/outsourceapproval"
            }
        ]
    }
]

/**
 * 生产厂长菜单列表
 * @type {*[]}
 */
var directorOfProductionMenuList = [
    {
        "name": "生产管理",
        "child": [
            {
                "name": "生产计划审批",
                "url": "product/productplanapproval"
            }
        ]
    },
    {
        "name": "外协管理",
        "child": [
            {
                "name": "外协审批",
                "url": "outsource/outsourceapproval"
            }
        ]
    }
]

/**
 * 外协管理员菜单列表
 * @type {*[]}
 */
var outSourceManagerMenuList = [
    {
        "name": "生产管理",
        "child": [
            {
                "name": "生产计划查询",
                "url": "product/productplanselect"
            }
        ]
    },
    {
        "name": "外协管理",
        "child": [
            {
                "name": "外协出库",
                "url": "outsource/outsourceoutofstock"
            },
            {
                "name": "外协入库",
                "url": "outsource/outsourceinofstock"
            }
        ]
    }
]

/**
 * 系统管理员菜单列表
 * @type {*[]}
 */
var systemAdministratorMenuList = [
    {
        "name": "系统管理",
        "child": [
            {
                "name": "用户管理",
                "url": "system/usermanage"
            }
        ]
    },
    {
        "name": "基础选项",
        "child": [
            {
                "name": "零件管理",
                "url": "system/base/parts.html"
            },
            {
                "name": "产品管理",
                "url": "system/base/product.html"
            },
            {
                "name": "工序管理",
                "url": "system/base/process.html"
            },
            {
                "name": "外协单位管理",
                "url": "base/outsourcemanage"
            },
            {
                "name": "提醒设置",
                "url": "base/warningset"
            }
        ]
    }
]