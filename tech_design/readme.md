## 模块设计
    base模块
        基础DO层、DAO层&service层
    commons模块
        基础工具类  -- 时间转换，加密算法等
        插件支持  --  redis 支持
        外接  -- 阿里支付&微信支付等
    restful模块
        对外开放API
    site模块
        自用数据统计  -- 传统web cs架构

## 数据库标识：
    数据状态： 1正常数据 0删除数据
    
    
    
## 文件说明
    tech_design：设计集合
    commons: commons模块设计集合
    sql_Version  保留每个阶段的最终sql