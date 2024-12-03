<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="硬币数量" prop="coins">
        <el-input v-model="dataForm.coins" placeholder="硬币数量"></el-input>
      </el-form-item>
          <el-form-item label="猎人等级" prop="hunterLevel">
        <el-input v-model="dataForm.hunterLevel" placeholder="猎人等级"></el-input>
      </el-form-item>
          <el-form-item label="猎人经验" prop="hunterExp">
        <el-input v-model="dataForm.hunterExp" placeholder="猎人经验"></el-input>
      </el-form-item>
          <el-form-item label="完成的海报数量" prop="posterCompleted">
        <el-input v-model="dataForm.posterCompleted" placeholder="完成的海报数量"></el-input>
      </el-form-item>
          <el-form-item label="德" prop="morality">
        <el-input v-model="dataForm.morality" placeholder="德"></el-input>
      </el-form-item>
          <el-form-item label="智" prop="intelligence">
        <el-input v-model="dataForm.intelligence" placeholder="智"></el-input>
      </el-form-item>
          <el-form-item label="体" prop="physical">
        <el-input v-model="dataForm.physical" placeholder="体"></el-input>
      </el-form-item>
          <el-form-item label="美" prop="aesthetic">
        <el-input v-model="dataForm.aesthetic" placeholder="美"></el-input>
      </el-form-item>
          <el-form-item label="劳" prop="labor">
        <el-input v-model="dataForm.labor" placeholder="劳"></el-input>
      </el-form-item>
          <el-form-item label="上" prop="up">
        <el-input v-model="dataForm.up" placeholder="上"></el-input>
      </el-form-item>
          <el-form-item label="下" prop="down">
        <el-input v-model="dataForm.down" placeholder="下"></el-input>
      </el-form-item>
          <el-form-item label="左" prop="moveLeft">
        <el-input v-model="dataForm.moveLeft" placeholder="左"></el-input>
      </el-form-item>
          <el-form-item label="右" prop="moveRight">
        <el-input v-model="dataForm.moveRight" placeholder="右"></el-input>
      </el-form-item>
          <el-form-item label="交互" prop="interact">
        <el-input v-model="dataForm.interact" placeholder="交互"></el-input>
      </el-form-item>
          <el-form-item label="朋友ID列表" prop="friendsUid">
        <el-input v-model="dataForm.friendsUid" placeholder="朋友ID列表"></el-input>
      </el-form-item>
          <el-form-item label="音量" prop="volume">
        <el-input v-model="dataForm.volume" placeholder="音量"></el-input>
      </el-form-item>
          <el-form-item label="已摘下的海报ID列表" prop="pickedPostersId">
        <el-input v-model="dataForm.pickedPostersId" placeholder="已摘下的海报ID列表"></el-input>
      </el-form-item>
      </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle()">确定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import baseService from "@/service/baseService";
import { ElMessage } from "element-plus";
const emit = defineEmits(["refreshDataList"]);

const visible = ref(false);
const dataFormRef = ref();

const dataForm = reactive({
  id: '',  coins: '',  hunterLevel: '',  hunterExp: '',  posterCompleted: '',  morality: '',  intelligence: '',  physical: '',  aesthetic: '',  labor: '',  up: '',  down: '',  moveLeft: '',  moveRight: '',  interact: '',  friendsUid: '',  volume: '',  pickedPostersId: ''});

const rules = ref({
          coins: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          hunterLevel: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          hunterExp: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          posterCompleted: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          morality: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          intelligence: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          physical: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          aesthetic: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          labor: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          up: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          down: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          moveLeft: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          moveRight: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          interact: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          friendsUid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          volume: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          pickedPostersId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

const init = (id?: number) => {
  visible.value = true;
  dataForm.id = "";

  // 重置表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (id) {
    getInfo(id);
  }
};

// 获取信息
const getInfo = (id: number) => {
  baseService.get("/playerState/posterplayerstates/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/playerState/posterplayerstates", dataForm).then((res) => {
      ElMessage.success({
        message: '成功',
        duration: 500,
        onClose: () => {
          visible.value = false;
          emit("refreshDataList");
        }
      });
    });
  });
};

defineExpose({
  init
});
</script>
