<template>
  <div class="mod-user__posterusers">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <ren-select v-model="state.dataForm.identity" dict-type="identity" placeholder="用户身份"></ren-select>
      </el-form-item>
      <!-- <ren-select v-model="state.dataForm.identity" dict-type="identity" placeholder="用户身份">
        <template v-slot:default>
          <option v-for="item in state.getDictList('identity')" :key="item.value" :value="item.value">
            {{ item.label }}
          </option>
        </template>
      </ren-select> -->
      <el-form-item>
        <el-input v-model="state.dataForm.nickname" placeholder="昵称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="state.getDataList()">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('user:posterusers:save')" type="primary" @click="addOrUpdateHandle(false)">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('user:posterusers:delete')" type="danger" @click="state.deleteHandle()">删除</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" border @selection-change="state.dataListSelectionChangeHandle" style="width: 100%">
      <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
      <el-table-column prop="id" label="用户ID" header-align="center" align="center"></el-table-column>
      <el-table-column prop="identity" label="用户身份" header-align="center" align="center">
        <template v-slot="scope">
          {{ state.getDictLabel("identity", scope.row.identity) }}
        </template>
      </el-table-column>
      <el-table-column prop="mobilePhoneNumber" label="手机号" header-align="center" align="center"></el-table-column>
      <el-table-column prop="nickname" label="用户昵称" header-align="center" align="center"></el-table-column>
      <el-table-column prop="password" label="密码" header-align="center" align="center"></el-table-column>
      <el-table-column prop="isAdmin" label="是否为管理员" header-align="center" align="center"></el-table-column>
      <el-table-column prop="isOnline" label="是否在线" header-align="center" align="center"></el-table-column>
      <el-table-column prop="schoolId" label="所在学校ID" header-align="center" align="center"></el-table-column>
      <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
        
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('user:posterusers:save')" type="primary" link @click="addOrUpdateHandle(true, scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('user:posterusers:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="state.page" :page-sizes="[10, 20, 50, 100]" :page-size="state.limit" :total="state.total" layout="total, sizes, prev, pager, next, jumper" @size-change="state.pageSizeChangeHandle" @current-change="state.pageCurrentChangeHandle"></el-pagination>
    <add-or-update ref="addOrUpdateRef" @refreshDataList="state.getDataList"></add-or-update>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref, toRefs } from "vue";
import useView from "@/hooks/useView";
import AddOrUpdate from "./posterusers-add-or-update.vue";

const view = reactive({
  deleteIsBatch: true,
  getDataListURL: "/user/posterusers/page",
  getDataListIsPage: true,
  exportURL: "/user/posterusers/export",
  deleteURL: "/user/posterusers",
  dataForm: {
    identity: "",
    nickname: ""
  }
});

const state = reactive({ 
  ...useView(view), 
  ...toRefs(view)
});

const addOrUpdateRef = ref();
// 新增或修改触发方法
const addOrUpdateHandle = (isEdit: boolean, id?: number) => {
  addOrUpdateRef.value.init(isEdit, id);
};
</script>
