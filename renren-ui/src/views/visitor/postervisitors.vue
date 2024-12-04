<template>
  <div class="mod-visitor__postervisitors">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <el-button v-if="state.hasPermission('visitor:postervisitors:save')" type="primary" @click="addOrUpdateHandle(false)">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('visitor:postervisitors:delete')" type="danger" @click="state.deleteHandle()">删除</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" border @selection-change="state.dataListSelectionChangeHandle" style="width: 100%">
      <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
              <el-table-column prop="id" label="访客ID" header-align="center" align="center"></el-table-column>
            <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('visitor:postervisitors:update')" type="primary" link @click="addOrUpdateHandle(true, scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('visitor:postervisitors:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="state.page" :page-sizes="[10, 20, 50, 100]" :page-size="state.limit" :total="state.total" layout="total, sizes, prev, pager, next, jumper" @size-change="state.pageSizeChangeHandle" @current-change="state.pageCurrentChangeHandle"> </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update ref="addOrUpdateRef" @refreshDataList="state.getDataList">确定</add-or-update>
  </div>
</template>

<script lang="ts" setup>
import useView from "@/hooks/useView";
import { reactive, ref, toRefs } from "vue";
import AddOrUpdate from "./postervisitors-add-or-update.vue";

const view = reactive({
  deleteIsBatch: true,
  getDataListURL: "/visitor/postervisitors/page",
  getDataListIsPage: true,
  exportURL: "/visitor/postervisitors/export",
  deleteURL: "/visitor/postervisitors"
});

const state = reactive({ ...useView(view), ...toRefs(view) });

const addOrUpdateRef = ref();
// 新增或修改触发方法
const addOrUpdateHandle = (isEdit: boolean, id?: number) => {
  addOrUpdateRef.value.init(isEdit, id);
};
</script>
