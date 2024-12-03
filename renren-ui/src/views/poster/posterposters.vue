<template>
  <div class="mod-poster__posterposters">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <el-button v-if="state.hasPermission('poster:posterposters:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('poster:posterposters:delete')" type="danger" @click="state.deleteHandle()">删除</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" border @selection-change="state.dataListSelectionChangeHandle" style="width: 100%">
      <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
              <el-table-column prop="id" label="海报ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="schoolId" label="所在学校ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="title" label="海报标题" header-align="center" align="center"></el-table-column>
              <el-table-column prop="ownerUid" label="海报所有者ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="pickerUid" label="摘下海报者ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="content" label="海报内容" header-align="center" align="center"></el-table-column>
              <el-table-column prop="isReceived" label="是否已收到奖励" header-align="center" align="center"></el-table-column>
              <el-table-column prop="bountyLevel" label="悬赏等级" header-align="center" align="center"></el-table-column>
              <el-table-column prop="postTime" label="发布时间" header-align="center" align="center"></el-table-column>
              <el-table-column prop="submitTime" label="提交审核时间" header-align="center" align="center"></el-table-column>
              <el-table-column prop="coinsRemuneration" label="硬币报酬" header-align="center" align="center"></el-table-column>
              <el-table-column prop="expRemuneration" label="经验报酬" header-align="center" align="center"></el-table-column>
              <el-table-column prop="isOfficial" label="是否为官方发布" header-align="center" align="center"></el-table-column>
              <el-table-column prop="isPicked" label="是否已被摘下" header-align="center" align="center"></el-table-column>
              <el-table-column prop="isSubmitted" label="是否已提交审核" header-align="center" align="center"></el-table-column>
            <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('poster:posterposters:update')" type="primary" link @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('poster:posterposters:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
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
import AddOrUpdate from "./posterposters-add-or-update.vue";

const view = reactive({
  deleteIsBatch: true,
  getDataListURL: "/poster/posterposters/page",
  getDataListIsPage: true,
  exportURL: "/poster/posterposters/export",
  deleteURL: "/poster/posterposters"
});

const state = reactive({ ...useView(view), ...toRefs(view) });

const addOrUpdateRef = ref();
const addOrUpdateHandle = (id?: number) => {
  addOrUpdateRef.value.init(id);
};
</script>
