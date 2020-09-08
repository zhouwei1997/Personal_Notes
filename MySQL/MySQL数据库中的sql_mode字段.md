# ONLY_FULL_GROUP_BY 
ONLY_FULL_GROUP_BY字段是对于GROUP BY聚合操作的，如果在SELECT子句中，没有在GROUP BY中出现，那么这个SQL是不合法的，因为列不在GROUP BY从句中。
# NO_AUTO_VALUE_ON_ZERO
NO_AUTO_VALUE_ON_ZERO字段影响的是自增长列的插入，默认设置下，插入0或者NULL代表生成下一个自增长值。如果用户希望插入的值为0，该值又是自增长的，那么这个选项就是有用的
# STRICT_TRANS_TABLES
STRICT_TRANS_TABLES，在该模式下，如果一个值不能插入到一个事物表中，则中断当前的操作，对非事务表不做限制

# NO_ZERO_IN_DATE
在严格模式下，不允许日期和月份为零
# NO_ZERO_DATE
设置该值，mysql数据库不允许插入零日期，插入零日期报错而不是警告

# ERROR_FOR_DIVISION_BY_ZERO
在INSTRT或UPDATE过程中，如果数据被零除，则产生错误而非警告，如果未给出该模式，那么被零除时MySQL返回NULL

# NO_AUTO_CREATE_USER
禁止GRANT创建密码为空的用户
# NO_ENGINE_SUBSTITUTION
如果需要的存储引擎被禁用或未编译，那么抛出错误。不设置此值时，用默认的存储引擎替代，并抛出一个异常
# PIPES_AS_COUCAT 
将“||”视为字符串的连接操作符而非或运算符
# ANSI_QUOTES
启用ANSI_QUOTES后，不能用双引号来引用字符串，因为他被解释为识别符

