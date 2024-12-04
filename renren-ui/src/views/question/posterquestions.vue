<template>
  <div class="mod-question__posterquestions">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <el-button v-if="state.hasPermission('question:posterquestions:save')" type="primary" @click="addOrUpdateHandle(false)">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('question:posterquestions:delete')" type="danger" @click="state.deleteHandle()">删除</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" border @selection-change="state.dataListSelectionChangeHandle" style="width: 100%">
      <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
              <el-table-column prop="id" label="问题ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="posterId" label="海报ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="questionContent" label="问题内容" header-align="center" align="center"></el-table-column>
              <el-table-column prop="choices" label="问题选项" header-align="center" align="center"></el-table-column>
              <el-table-column prop="answer" label="正确答案" header-align="center" align="center"></el-table-column>
            <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('question:posterquestions:update')" type="primary" link @click="addOrUpdateHandle(true, scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('question:posterquestions:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
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
import AddOrUpdate from "./posterquestions-add-or-update.vue";

const view = reactive({
  deleteIsBatch: true,
  getDataListURL: "/question/posterquestions/page",
  getDataListIsPage: true,
  exportURL: "/question/posterquestions/export",
  deleteURL: "/question/posterquestions"
});

const state = reactive({ ...useView(view), ...toRefs(view) });

const addOrUpdateRef = ref();
// 新增或修改触发方法
const addOrUpdateHandle = (isEdit: boolean, id?: number) => {
  addOrUpdateRef.value.init(isEdit, id);
};
</script>
