//系统管理员：
var ROLE_MANAGER_SYSTEM = [
    {
        "name":"基础选项",
        "child":[
            {
                "name": "零件管理",
                "url": "base/parts"
            },
            {
                "name": "工序管理",
                "url": "base/process"
            },
            {
                "name": "外协单位管理",
                "url": "base/out"
            },
            {
                "name": "提醒设置",
                "url": "base/warning"
            }
        ]
    },
    {
        "name":"系统管理",
        "child":[
            {
                "name":"用户管理",
                "url":"system/user"
            }
        ]
    }
]


//生产厂长：
var ROLE_PRODUCTION_DIRECTOR = [
    {
        "name":"生产管理",
        "child":[
            {
                "name":"审批管理",
                "url":"produce/approval"
            }
        ]
    }
]


//外协管理员：
var ROLE_MANAGER_OUTSOURCE = [
    {
        "name":"基础选项",
        "child":[
            {
                "name": "零件管理",
                "url": "base/parts"
            },
            {
                "name": "工序管理",
                "url": "base/process"
            },
            {
                "name": "外协单位管理",
                "url": "base/out"
            },
            {
                "name": "提醒设置",
                "url": "base/warning"
            }
        ]
    },
    {
        "name":"生产管理",
        "child":[
            {
                "name":"生产计划",
                "url":"produce/plan"
            }
        ]
    }
]


//统计管理员：
var ROLE_MANAGER_STATISTICS = [
    {
        "name":"生产管理",
        "child":[
            {
                "name":"订单管理",
                "url":"produce/order"
            },
            {
                "name":"生产计划",
                "url":"produce/plan"
            },
            {
                "name":"订单零件",
                "url":"produce/parts"
            }
        ]
    }
]


