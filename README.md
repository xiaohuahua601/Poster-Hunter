# Poster-Hunter｜校园海报与悬赏管理后台

> 一个围绕校园海报、问题与奖励数据的管理端项目。仓库在 [renren-security](https://gitee.com/renrenio/renren-security) 后台框架上扩展业务模块，面试阅读重点是这些业务模块及其前后端数据链路。

## 面试官 30 秒了解

| 项目要点 | 说明 |
| --- | --- |
| 解决的问题 | 集中管理校园海报、关联问题、学生及学校信息，并维护消息和玩家状态数据。 |
| 当前实现 | 提供海报、问题、消息、玩家状态、学生、学校、院系和省份等管理页面及后台接口。海报等模块支持分页查询、详情、保存、修改、删除和 Excel 导出。 |
| 技术栈 | Spring Boot 3、MyBatis-Plus、MySQL、Shiro；管理端使用 Vue 3、TypeScript、Element Plus 和 Vite。 |
| 代码范围 | 仓库主要呈现管理后台。海报“发布→摘取→审核→结算”的完整用户侧闭环不能仅凭现有管理接口认定已实现。 |

## 项目如何组织

- **业务数据**：海报实体包含学校、发布者、摘取者、悬赏等级、硬币和经验报酬、提交审核状态等字段；问题实体保存海报关联、选项与答案；玩家状态保存硬币、等级、经验等数据。
- **后端接口**：`renren-admin/src/main/java/io/renren/modules/` 下的 `poster`、`question`、`message`、`playerState` 等模块按 Controller → Service → DAO/Entity 组织。以 [海报控制器](renren-admin/src/main/java/io/renren/modules/poster/controller/PosterPostersController.java) 为例，可查看分页、增删改查、权限注解及导出接口。
- **管理页面**：`renren-ui/src/views/` 下有对应的海报、问题、消息、学校等列表和编辑页面；`renren-ui/src/service/baseService.ts` 负责前端请求封装。
- **通用能力**：用户、角色、菜单权限、日志、定时任务等来自所采用的 renren-security 基础框架；`renren-api/` 还包含独立的登录、注册示例 API。

## 阅读路径

1. [海报数据模型](renren-admin/src/main/java/io/renren/modules/poster/entity/PosterPostersEntity.java) 与 [问题数据模型](renren-admin/src/main/java/io/renren/modules/question/entity/PosterQuestionsEntity.java)：先看业务字段。
2. [海报接口](renren-admin/src/main/java/io/renren/modules/poster/controller/PosterPostersController.java) 与 [海报管理页](renren-ui/src/views/poster/posterposters.vue)：对照一次管理操作的前后端路径。
3. [玩家状态模型](renren-admin/src/main/java/io/renren/modules/playerState/entity/PosterPlayerStatesEntity.java)：了解奖励相关的数据设计。

## 运行说明

项目包含多模块 Maven 后端和 `renren-ui` 前端。后端需要 JDK 17、Maven、MySQL，并先导入 [数据库脚本](renren-admin/db/mysql.sql)、配置本地数据库连接；前端在 `renren-ui` 安装依赖后运行 `npm run dev`。本 README 根据仓库源码编写，未对完整系统进行本机启动验证。部署前请检查并替换示例配置与账号。

## 来源与边界

本仓库使用 renren-security 作为基础框架。其原始功能与通用模块归属于上游项目；本仓库中的校园海报相关模块是这里重点展示的扩展内容。仓库未提供完整用户端游戏流程和可复现的端到端演示，因此不将数据字段或管理页描述成已验证的业务闭环。
