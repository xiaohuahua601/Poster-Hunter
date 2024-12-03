<template>
  <el-dialog v-model="visible" :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
          <el-form-item label="海报ID" prop="posterId">
        <el-input v-model="dataForm.posterId" placeholder="海报ID"></el-input>
      </el-form-item>
          <el-form-item label="问题内容" prop="questionContent">
        <el-input v-model="dataForm.questionContent" placeholder="问题内容"></el-input>
      </el-form-item>
          <el-form-item label="问题选项" prop="choices">
        <el-input v-model="dataForm.choices" placeholder="问题选项"></el-input>
      </el-form-item>
          <el-form-item label="正确答案" prop="answer">
        <el-input v-model="dataForm.answer" placeholder="正确答案"></el-input>
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
  id: '',  posterId: '',  questionContent: '',  choices: '',  answer: ''});

const rules = ref({
          posterId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          questionContent: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          choices: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          answer: [
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
  baseService.get("/question/posterquestions/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 表单提交
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      return false;
    }
    (!dataForm.id ? baseService.post : baseService.put)("/question/posterquestions", dataForm).then((res) => {
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
