&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---车品商城后端部分---
===
* 1.开发环境：jdk 1.8  

* 2.开发框架：springboot 2.5.2  

* 3.其他：mysql 8.0  
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;redis 6.2  
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maven 3.6  
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;druid 1.1  

* 4.项目设计：根据UI图编写接口文档，设计数据库  
  * 4.1.大致上分为四个模块：商品模块、系统模块、用户模块、订单模块  
    * 4.1.1商品模块：<br>【设计思路】根据ui图设计了必要的字段后，考虑到在商品详情页中中可以选择商品的规格，每个规格都应该算是一个商品 
                             因此通过一个unionId外键将这些不同规格的商品关联到一起;再将商品的一、二级分类的信息设计到数据字典中，作为系统
                              模块的部分内容  
                   【实现】编写主要业务逻辑代码，在实现收藏商品功能时，通过Redis做缓存，使用了set集合，将商品编号作为key，UserCollecion作为value。同时，
                           使用了springboot的定时器，设计了定时任务，在某个时间点，将Redis中的用户收藏商品数据持久化到mysql中。  
     
    * 4.1.2系统模块：<br>【设计思路】主要做了关于数据字典的业务，设计了字典表并进行关联。字典表中的信息主要是商品的分类信息。  
                    【实现】编写业务逻辑代码，使用Redis作为缓存，将数据字典的数据存放到redis中，减少了与mysql的请求，提高效率  
                    
    * 4.1.3用户模块：
    
    * 4.1.4订单模块：
    
  * 4.2.其他：  
    * 4.2.1：开发流程遵守MVC模型开发  
    * 4.2.2：使用spring推荐的注解驱动开发，通过自定义注解结合spring的aop实现请求参数判空、token验证、用户操作记录等  
    * 4.2.3：使用控制器增强，建立全局异常处理器来处理异常，在代码有可能出现问题的地方，通过自定义异常类，使用主动抛异常的方式，通过全局异常处理器捕获异常后统一处理异常，便于代码的维护  
    * 4.2.4：
      
    
* 5.包结构如下：  
>com
>>team10  
>>>annotation  
>>>aspect  
>>>config  
>>>enums  
>>>exception  
>>>goods  
>>>handler  
>>>order  
>>>settings  
>>>user  
>>>util  
