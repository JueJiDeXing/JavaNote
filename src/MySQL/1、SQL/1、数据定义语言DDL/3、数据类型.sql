# 类型         大小(字节)      描述
/* 数值类型 */
tinyint      1字节        signed/unsigned
smallint     2字节
mediumint    3字节
int/Integer  4字节
bigint       8字节

float        4字节
double       8字节
Decimal               精度:长度  标度:小数位数

/* 字符串类型 */
char          255        定长,固定占用空间,如char(10)固定10个字符串长
varchar       65535      变长,根据长度改变占用空间
tinyblob      255        二进制文本
tinytext      255        短文本
blob          65535      长二进制文本
text          65535      长短文本
mediumblob    16777215   中等长二进制文本
mediumtext    16777215   中等长文本
longblob      4294967295 超长二进制文本
longtext      4294967295 超长文本

/* 日期类型 */
date          3字节       1000-01-01 至9999-12-31
time          3字节       -835:59:59 至835:59:59
year          1字节       1901 至2155
datetime      8字节       1000-01-01 00:00:00 至9999-12-31 23:59:59
timestamp     4字节       1970-01-01 00:00:01 至2038-01-19 03:14:07






