# Poster-Hunter｜校园海报管理后台

Poster-Hunter 是一个校园海报业务的**管理端项目**。管理员可以维护海报、海报关联问题、站内消息，以及学校、院系、学生和玩家状态等基础数据。仓库主要展示管理页面、接口和数据模型；面向学生的完整海报任务流程并未在这里形成可验证的闭环。

## 能做什么

- **管理海报**：查看列表与详情，新增、编辑、删除和导出海报数据。海报记录包含学校、发布者、摘取者、悬赏等级、奖励以及审核相关状态。
- **维护关联内容**：为海报保存问题、选项与答案；管理消息、学生、学校、院系等数据。
- **查看玩家状态**：维护硬币、等级、经验、已完成海报数量等字段。

以管理一张海报为例：管理员在 [海报页面](renren-ui/src/views/poster/posterposters.vue) 发起操作，后端 [海报接口](renren-admin/src/main/java/io/renren/modules/poster/controller/PosterPostersController.java) 校验请求与权限，再由 Service 和 MyBatis-Plus 处理数据。列表、详情、增删改和 Excel 导出都能从这条路径追踪。

## 技术与仓库结构

| 位置 | 作用 |
| --- | --- |
| `renren-ui/` | Vue 3、TypeScript、Element Plus、Vite 管理界面 |
| `renren-admin/` | Spring Boot 3、Shiro、MyBatis-Plus 后台与业务模块 |
| `renren-api/` | 独立的登录、注册示例 API |
| [数据库脚本](renren-admin/db/mysql.sql) | MySQL 初始化数据 |

本仓库基于 [renren-security](https://gitee.com/renrenio/renren-security) 扩展。用户、角色、菜单权限、日志和定时任务等属于上游基础框架；校园海报相关模块是此仓库重点展示的内容。

## 从哪里看代码

[海报数据模型](renren-admin/src/main/java/io/renren/modules/poster/entity/PosterPostersEntity.java) → [海报接口](renren-admin/src/main/java/io/renren/modules/poster/controller/PosterPostersController.java) → [海报管理页](renren-ui/src/views/poster/posterposters.vue)。关联问题可看 [问题模型](renren-admin/src/main/java/io/renren/modules/question/entity/PosterQuestionsEntity.java)，奖励字段可看 [玩家状态模型](renren-admin/src/main/java/io/renren/modules/playerState/entity/PosterPlayerStatesEntity.java)。

## 运行与范围

后端需要 JDK 17、Maven 和 MySQL，先导入数据库脚本并配置本地连接；前端在 `renren-ui` 安装依赖后运行 `npm run dev`。本文依据仓库源码编写，未进行整套系统的本机启动验证。仓库中的管理接口和状态字段不等于“发布、摘取、审核、结算”完整流程已实现。
