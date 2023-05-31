## 数据库
查看resource目录
数据库文件：ctlb.sql
1. 新建数据库ctlb，
2. 运行ctlb.sql文件，
3. 修改application.yml文件中的用户名和密码
最后运行即可

## 项目
均采用JDK1.8，重要，重要，重要！！！

## 包结构
common: 公共类
config: 配置类
controller: 逻辑处理，api接口信息（核心）
domain: 实体，与数据库对应
dto: 实现游戏逻辑需要的类，也是与数据库进行交互

## 加密
数据库密码采用md5加密
