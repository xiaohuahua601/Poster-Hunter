<template>
  <div class="mod-playerState__posterplayerstates">
    <el-form :inline="true" :model="state.dataForm" @keyup.enter="state.getDataList()">
      <el-form-item>
        <el-button v-if="state.hasPermission('playerState:posterplayerstates:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="state.hasPermission('playerState:posterplayerstates:delete')" type="danger" @click="state.deleteHandle()">删除</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="state.dataListLoading" :data="state.dataList" border @selection-change="state.dataListSelectionChangeHandle" style="width: 100%">
      <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
              <el-table-column prop="id" label="用户ID" header-align="center" align="center"></el-table-column>
              <el-table-column prop="coins" label="硬币数量" header-align="center" align="center"></el-table-column>
              <el-table-column prop="hunterLevel" label="猎人等级" header-align="center" align="center"></el-table-column>
              <el-table-column prop="hunterExp" label="猎人经验" header-align="center" align="center"></el-table-column>
              <el-table-column prop="posterCompleted" label="完成的海报数量" header-align="center" align="center"></el-table-column>
              <el-table-column prop="morality" label="德" header-align="center" align="center"></el-table-column>
              <el-table-column prop="intelligence" label="智" header-align="center" align="center"></el-table-column>
              <el-table-column prop="physical" label="体" header-align="center" align="center"></el-table-column>
              <el-table-column prop="aesthetic" label="美" header-align="center" align="center"></el-table-column>
              <el-table-column prop="labor" label="劳" header-align="center" align="center"></el-table-column>
              <el-table-column prop="up" label="上" header-align="center" align="center"></el-table-column>
              <el-table-column prop="down" label="下" header-align="center" align="center"></el-table-column>
              <el-table-column prop="moveLeft" label="左" header-align="center" align="center"></el-table-column>
              <el-table-column prop="moveRight" label="右" header-align="center" align="center"></el-table-column>
              <el-table-column prop="interact" label="交互" header-align="center" align="center"></el-table-column>
              <el-table-column prop="friendsUid" label="朋友ID列表" header-align="center" align="center"></el-table-column>
              <el-table-column prop="volume" label="音量" header-align="center" align="center"></el-table-column>
              <el-table-column prop="pickedPostersId" label="已摘下的海报ID列表" header-align="center" align="center"></el-table-column>
            <el-table-column label="操作" fixed="right" header-align="center" align="center" width="150">
        <template v-slot="scope">
          <el-button v-if="state.hasPermission('playerState:posterplayerstates:update')" type="primary" link @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button v-if="state.hasPermission('playerState:posterplayerstates:delete')" type="primary" link @click="state.deleteHandle(scope.row.id)">删除</el-button>
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
import AddOrUpdate from "./posterplayerstates-add-or-update.vue";

const view = reactive({
  deleteIsBatch: true,
  getDataListURL: "/playerState/posterplayerstates/page",
  getDataListIsPage: true,
  exportURL: "/playerState/posterplayerstates/export",
  deleteURL: "/playerState/posterplayerstates"
});

const state = reactive({ ...useView(view), ...toRefs(view) });

const addOrUpdateRef = ref();
const addOrUpdateHandle = (id?: number) => {
  addOrUpdateRef.value.init(id);
};
</script>
