/*
语法:
select 字段列表 from 表名 [where 条件] group by 分组字段名 [having 分组后过滤条件];

多级分组的顺序没有关系

在group by 后如果使用 with roolup 会额外插入一行数据, 对每个字段做avg
但就不允许再order by了

where与having的区别:
执行时机不同:where分组前执行,不满足条件的不参与分组,having分组后对结果过滤
判断条件不同:where不能对聚合函数进行判断,having可以
当条件不含聚合函数时,建议写在where里,这样先筛后分组效率更高

例:
select gender,count(*) from user group by gender; # 根据性别分组,求各组数量
select gender,avg(age) from user group by gender; # 根据性别分组,求各组平均年龄
select address,count(*) add_count from user group by address having count(*)>3; # 根据地址分组,求各地址用户数量,并筛选出用户数量大于3的地址
# 分组查询时查询无关字段无任何意义,如例1中如果查询name无意义,但是在MySQL不会报错


*/
