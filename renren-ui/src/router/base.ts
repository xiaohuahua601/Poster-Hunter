import Layout from "@/layout/layout.vue";
import Error from "@/views/error.vue";
import { RouteRecordRaw } from "vue-router";
import Login from "@/views/login.vue";
import Iframe from "@/views/iframe.vue";

/**
 * 框架基础路由
 */
const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: Layout,
    redirect: "/home",
    meta: { title: "工作台", icon: "icon-desktop" },
    children: [
      {
        path: "/home",
        component: () => import("@/views/home.vue"),
        meta: { title: "主页", icon: "icon-home" }
      }
    ]
  },
  {
    path: "/login",
    component: Login,
    meta: { title: "登录", isNavigationMenu: false }
  },
  {
    path: "/user/password",
    component: () => import("@/views/sys/user-update-password.vue"),
    meta: { title: "修改密码", requiresAuth: true, isNavigationMenu: false }
  },
  {
    path: "/iframe/:id?",
    component: Iframe,
    meta: { title: "iframe", isNavigationMenu: false }
  },
  {
    path: "/error",
    name: "error",
    component: Error,
    meta: { title: "错误页面", isNavigationMenu: false }
  },
  {
    path: "/:path(.*)*",
    redirect: { path: "/error", query: { to: 404 }, replace: true },
    meta: { isNavigationMenu: false }
  },
  {
    path:"/faculty",
    name:"教师管理",
    component:()=>import("@/views/faculty/posterfaculties.vue"),
  },
  {
    path:"/message",
    name:"消息管理",
    component:()=>import("@/views/message/postermessages.vue"),
  },
  {
    path:"/playerState",
    name:"玩家状态管理",
    component:()=>import("@/views/playerState/posterplayerstates.vue"),
  },
  {
    path:"/poster",
    name:"海报管理",
    component:()=>import("@/views/poster/posterposters.vue"),
  },
  {
    path:"/province",
    name:"省份管理",
    component:()=>import("@/views/province/posterprovinces.vue"),
  },
  {
    path:"/question",
    name:"问题管理",
    component:()=>import("@/views/question/posterquestions.vue"),
  },
  {
    path:"/school",
    name:"学校管理",
    component:()=>import("@/views/school/posterschools.vue"),
  },
  {
    path:"/student",
    name:"学生管理",
    component:()=>import("@/views/student/posterstudents.vue"),
  },
  {
    path:"/user",
    name:"用户管理",
    component:()=>import("@/views/user/posterusers.vue"),
  },
  {
    path:"/visitor",
    name:"访客管理",
    component:()=>import("@/views/visitor/postervisitors.vue"),
  }
];

export default routes;
