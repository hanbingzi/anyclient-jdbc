

<p align="center">
	<a href="https://www.clientbiz.cn"><img src="./doc/icons/anyclient.ico" width="150" /></a>
</p>
<h1 align="center">AnyClient JDBC Driver </h1>


[官网地址](https://www.anyclient.cn)

[AnyClient IDE 版本请移步此处（源码地址）](https://github.com/hanbingzi/anyclient-ide)

![github](./doc/icons/main/github.svg)
[GitHub主页地址](https://github.com/hanbingzi)

![gitee](./doc/icons/main/gitee.svg)
[Gitee主页地址](https://gitee.com/hanbingzi)

AnyClient JDBC Driver 用于支持AnyClient部分客户端的操作驱动。


## 项目目录
```text
any-client-jdbc
├─src
|  ├─core
|  |  ├─app //项目核心
|  |  ├─common //项目通用
|  |  ├─base //jdbc底层操作
|  |  |   ├─
|  |  |   ├─sq-base
|  |  |   ├─
|  |  ├─plugin-api //与plugins通信model
|  |  └server //后台node启动入口
|  |     ├─Mysql8
|  |     ├─DB2
|  |     ├─KingBase
|  |     ├─Hive
|  |     ├─SparkSql
|  ├─plugins //1.主流驱动不兼容的驱动，例如mysql8的驱动不兼容mysql5，需要通过osgi引用 2.为了减少plugins的jar包大小，plugins减少引入

```


## Java JDBC 类型与 PreparedStatement 设置方法对应

以下是 Java JDBC 类型与 `PreparedStatement` 设置方法的对应关系：

| **Java 类型** | **JDBC 类型** | **PreparedStatement 方法** |
|---|---|---| 
| `boolean` | `BOOLEAN` (16) | `setBoolean(int parameterIndex, boolean x)` |
| `byte` | `TINYINT` (-6) | `setByte(int parameterIndex, byte x)` |
| `short` | `SMALLINT` (5) | `setShort(int parameterIndex, short x)` |
| `int` | `INTEGER` (4) | `setInt(int parameterIndex, int x)` |
| `long` | `BIGINT` (-5) | `setLong(int parameterIndex, long x)` |
| `float` | `REAL` (7) | `setFloat(int parameterIndex, float x)` |
| `double` | `DOUBLE` (8) | `setDouble(int parameterIndex, double x)` |
| `java.math.BigDecimal` | `NUMERIC` (2), `DECIMAL` (3) | `setBigDecimal(int parameterIndex, BigDecimal x)` |
| `String` | `CHAR` (1), `VARCHAR` (12), `LONGVARCHAR` (-1) | `setString(int parameterIndex, String x)` |
| `java.sql.Date` | `DATE` (91) | `setDate(int parameterIndex, Date x)` |
| `java.sql.Time` | `TIME` (92) | `setTime(int parameterIndex, Time x)` |
| `java.sql.Timestamp` | `TIMESTAMP` (93) | `setTimestamp(int parameterIndex, Timestamp x)` |
| `byte[]` | `BINARY` (-2), `VARBINARY` (-3), `LONGVARBINARY` (-4) | `setBytes(int parameterIndex, byte[] x)` |
| `java.sql.Blob` | `BLOB` (2004) | `setBlob(int parameterIndex, Blob x)` |
| `java.sql.Clob` | `CLOB` (2005) | `setClob(int parameterIndex, Clob x)` |
| `java.net.URL` | `DATALINK` (70) | `setURL(int parameterIndex, URL x)` |
| `Object` | `JAVA_OBJECT` (2000) | `setObject(int parameterIndex, Object x)` |
| `Object` | `OTHER` (1111) | `setObject(int parameterIndex, Object x, int targetSqlType)` |

**注意事项：**

*   `parameterIndex` 表示参数在 SQL 语句中的索引，从 1 开始。
*   对于 `Object` 类型，需要根据实际的 SQL 类型选择合适的 `targetSqlType`。
*   某些 JDBC 类型可能没有直接对应的 Java 类型，例如 `ROWID`、`NCHAR`、`NCLOB` 等。
*   一些数据库可能支持特定的 JDBC 类型，例如 `TIME_WITH_TIMEZONE`、`TIMESTAMP_WITH_TIMEZONE` 等。

**示例：**

```java
PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
pstmt.setString(1, "John Doe");
pstmt.setInt(2, 30);
pstmt.executeUpdate();
```

**总结：**

使用 `PreparedStatement` 设置参数时，需要根据 Java 类型选择合适的 JDBC 类型和设置方法。
