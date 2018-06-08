创建出来项目后：
1. 替换掉所有 statistic 相关的名字/文件 （不区分大小写）

# statistic service
统计相关服务

## 表结构

```sql
均为 utf8, innodb

create database parastatistic default charset utf8 collate utf8_unicode_ci; 

create table `t_statistic`(
    login_id varchar(100) NOT NULL,
    ip varchar(100) NOT NULL,
    value SMALLINT NOT NULL,
    created_date datetime NOT NULL,
    updated_date datetime NOT NULL,
    PRIMARY KEY (`login_id`, `ip`),
	INDEX `create_date_index` (created_date)
);


```

## API
statistic service的baseurl 为 [baseUrl]. 下面全部省略
baseUrl =  "https://statistic.paratera.com/statistic/api"
所有的异常均类似下面的json, 同时httpstatus 为 500
```javascript
{"code":404, "msg":"", "desc":"NO AUHTORIZE"}
```
异常信息详见    异常信息列表
返回值详见 json实例


