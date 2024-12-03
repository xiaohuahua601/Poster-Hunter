<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="所在学校ID" prop="schoolId">
        <el-input v-model="dataForm.schoolId" placeholder="所在学校ID"></el-input>
      </el-form-item>
          <el-form-item label="海报标题" prop="title">
        <el-input v-model="dataForm.title" placeholder="海报标题"></el-input>
      </el-form-item>
          <el-form-item label="海报所有者ID" prop="ownerUid">
        <el-input v-model="dataForm.ownerUid" placeholder="海报所有者ID"></el-input>
      </el-form-item>
          <el-form-item label="摘下海报者ID" prop="pickerUid">
        <el-input v-model="dataForm.pickerUid" placeholder="摘下海报者ID"></el-input>
      </el-form-item>
          <el-form-item label="海报内容" prop="content">
        <el-input v-model="dataForm.content" placeholder="海报内容"></el-input>
      </el-form-item>
          <el-form-item label="是否已收到奖励" prop="isReceived">
        <el-input v-model="dataForm.isReceived" placeholder="是否已收到奖励"></el-input>
      </el-form-item>
          <el-form-item label="悬赏等级" prop="bountyLevel">
        <el-input v-model="dataForm.bountyLevel" placeholder="悬赏等级"></el-input>
      </el-form-item>
          <el-form-item label="发布时间" prop="postTime">
        <el-input v-model="dataForm.postTime" placeholder="发布时间"></el-input>
      </el-form-item>
          <el-form-item label="提交审核时间" prop="submitTime">
        <el-input v-model="dataForm.submitTime" placeholder="提交审核时间"></el-input>
      </el-form-item>
          <el-form-item label="硬币报酬" prop="coinsRemuneration">
        <el-input v-model="dataForm.coinsRemuneration" placeholder="硬币报酬"></el-input>
      </el-form-item>
          <el-form-item label="经验报酬" prop="expRemuneration">
        <el-input v-model="dataForm.expRemuneration" placeholder="经验报酬"></el-input>
      </el-form-item>
          <el-form-item label="是否为官方发布" prop="isOfficial">
        <el-input v-model="dataForm.isOfficial" placeholder="是否为官方发布"></el-input>
      </el-form-item>
          <el-form-item label="是否已被摘下" prop="isPicked">
        <el-input v-model="dataForm.isPicked" placeholder="是否已被摘下"></el-input>
      </el-form-item>
          <el-form-item label="是否已提交审核" prop="isSubmitted">
        <el-input v-model="dataForm.isSubmitted" placeholder="是否已提交审核"></el-input>
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
  id: '',  schoolId: '',  title: '',  ownerUid: '',  pickerUid: '',  content: '',  isReceived: '',  bountyLevel: '',  postTime: '',  submitTime: '',  coinsRemuneration: '',  expRemuneration: '',  isOfficial: '',  isPicked: '',  isSubmitted: ''});

const rules = ref({
          schoolId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          title: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          ownerUid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          pickerUid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          content: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          isReceived: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          bountyLevel: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          postTime: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          submitTime: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          coinsRemuneration: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          expRemuneration: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          isOfficial: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          isPicked: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          isSubmitted: [
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
  baseService.get("/poster/posterposters/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/poster/posterposters", dataForm).then((res) => {
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
